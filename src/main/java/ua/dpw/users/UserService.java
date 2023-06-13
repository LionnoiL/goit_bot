package ua.dpw.users;

import static ua.dpw.database.Service.BANK_SERVICE;
import static ua.dpw.database.Service.CURRENCY_SERVICE;
import static ua.dpw.database.Service.USER_SERVICE;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.dpw.AppLauncher;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.database.HibernateUtil;
import ua.dpw.notifications.Scheduler;

@Slf4j
public class UserService {

    public static void loadUsersFromFile() {
        String jsonFileName = "db/users.json";
        File file = new File(jsonFileName);
        if (file.exists()) {
            try (FileReader fileReader = new FileReader(jsonFileName)) {
                Map<Long, JsonObject> savedUsers = getJsonUsers(fileReader);

                for (Entry<Long, JsonObject> entry : savedUsers.entrySet()) {

                    User user = USER_SERVICE.getUserById(entry.getKey());
                    if (user == null) {
                        User newUser = createUserFromJsonObject(entry);
                        USER_SERVICE.addUser(newUser);
                    }
                }
            } catch (Exception e) {
                log.error("Error read users file from {}", jsonFileName);
            }
        }
    }

    private static User createUserFromJsonObject(Entry<Long, JsonObject> entry) {
        JsonObject userObject = entry.getValue();
        User newUser = new User();
        newUser.setUserId(entry.getKey());
        newUser.setUserName(userObject.get("userName").getAsString());
        if (userObject.get("lastName") != null) {
            newUser.setLastName(userObject.get("lastName").getAsString());
        }
        newUser.setLangCode(userObject.get("langCode").getAsString());
        newUser.setSymbolsAfterComma(
            userObject.get("symbolsAfterComma").getAsInt());
        newUser.setDeltaHours(userObject.get("deltaHours").getAsInt());
        newUser.setAlertTime(userObject.get("alertTime").getAsInt());
        newUser.setBank(
            BANK_SERVICE.getByName(userObject.get("bank").getAsString()));

        List<Currency> currencies = new ArrayList<>();
        JsonArray currenciesJson = userObject.get("currencies").getAsJsonArray();
        for (JsonElement currencyJson : currenciesJson) {
            currencies.add(
                CURRENCY_SERVICE.getByName(currencyJson.getAsString()));
        }
        newUser.setCurrencies(currencies);
        newUser.setCreatedDate(LocalDate.now());
        newUser.setUpdatedDate(LocalDate.now());
        return newUser;
    }

    private static Map<Long, JsonObject> getJsonUsers(FileReader fileReader) {
        GsonBuilder gsonBuilder = new Gson().newBuilder().serializeNulls()
            .setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.fromJson(fileReader,
            new TypeToken<Map<Long, JsonObject>>() {
            }.getType());
    }


    public List<User> getAllByAlertTime(int alertTime) {
        List<User> userList;
        try (Session session = HibernateUtil.openSession()) {
            String hql = """
                FROM User WHERE alertTime = :alert_time + deltaHours
                """;
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("alert_time", alertTime);
            userList = query.list();
        }
        return userList;
    }

    private User getById(long id) {
        try (Session session = HibernateUtil.openSession()) {
            String hql = """
                FROM User WHERE id = :id
                """;
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("id", id);
            return query.stream().findFirst().orElse(null);
        }
    }

    public User createUserWithDefaultProperties(long userId, String firstName, String lastName,
        String langCode) {
        log.info("Add new user with id {} {} {}", userId, firstName, lastName);
        User user = new User();
        user.setUserId(userId);
        user.setUserName(firstName);
        user.setLastName(lastName);
        user.setDeltaHours(0);
        user.setAlertTime(100);
        user.setSymbolsAfterComma(AppLauncher.APPLICATION_PROPERTIES.getDecimalPrecision());
        user.setBank(AppLauncher.APPLICATION_PROPERTIES.getBank());
        user.setCurrencies(List.of(AppLauncher.APPLICATION_PROPERTIES.getCurrency()));
        user.setLangCode(langCode);
        user.setCreatedDate(LocalDate.now());
        return user;
    }

    public void addUser(User user) {
        if (user == null) {
            return;
        }
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
    }

    public User getUserById(long userId) {
        User user = getById(userId);
        if (user != null) {
            String langCode = user.getLangCode();
            if (langCode == null) {
                langCode = "en";
            }
            user.setLangCode(langCode);
        }
        return user;
    }

    public List<User> getUsersFromCurrencyChanges() {
        List<User> result = new ArrayList<>();
        try (Session session = HibernateUtil.openSession()) {
            String sql = """
                SELECT USERS_CURRENCIES.USER_ID, RATES.bank_id FROM RATES_CHANGES
                LEFT JOIN RATES ON RATES.id = RATES_CHANGES.rate_id
                LEFT JOIN USERS_CURRENCIES ON USERS_CURRENCIES.CURRENCY_ID = RATES.CURRENCY_ID
                LEFT JOIN USERS on USERS.id = USERS_CURRENCIES.USER_ID
                WHERE users.ALERT_TIME = 200
                GROUP BY USERS_CURRENCIES.USER_ID, RATES.bank_id
                """;
            Query<Object[]> query = session.createNativeQuery(sql, Object[].class);
            List<Object[]> list = query.getResultList();

            for (Object[] row : list) {
                User user = getUserById((Integer) row[0]);
                if (user.getBank().getId() == (Integer) row[1]) {
                    result.add(user);
                }
            }
        }
        return result;
    }

    public void deleteCurrencyChanges() {
        try (Session session = HibernateUtil.openSession()) {
            String hql = """
                DELETE FROM CurrencyRateChanges
                """;
            Query query = session.createQuery(hql);
            session.beginTransaction();
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public void update(User user) {
        if (user == null) {
            return;
        }
        user.setUpdatedDate(LocalDate.now());
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        }
    }

    public void updateUser(User user, Bank bank) {
        user.setBank(bank);
        update(user);
    }

    public void updateUser(User user, Currency currency) {
        List<Currency> userCurrencyList = user.getCurrencies();
        if (userCurrencyList.contains(currency)) {
            userCurrencyList.remove(currency);
        } else {
            userCurrencyList.add(currency);
        }
        update(user);
    }

    public void updateUserTime(User user, int value) {
        user.setDeltaHours(value - Scheduler.getCurrentHour());
        update(user);
    }

    public void updateUserSymbolsAfterComma(User user, int value) {
        user.setSymbolsAfterComma(value);
        update(user);
    }

    public void updateUserAlertTime(User user, int value) {
        user.setAlertTime(value);
        update(user);
    }
}


