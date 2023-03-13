package org.example.users;

import static org.example.AppLauncher.APPLICATION_PROPERTIES;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;
import org.example.properties.ApplicationProperties;

public class UserService {

    private static final Logger LOG = LogManager.getLogger(UserService.class);

    public User createUser(long userId, String firstName, String lastName) {
        LOG.info("Add new user with id " + userId + " " + firstName + " " + lastName);
        User user = new User();
        user.setUserId(userId);
        user.setUserName(firstName);
        user.setLastName(lastName);
        user.setUserHours(0);
        user.setAlertTime(100);
        user.setSymbolsAfterComma(APPLICATION_PROPERTIES.getDecimalPrecision());
        user.setBank(APPLICATION_PROPERTIES.getBank());
        user.getCurrencies().add(APPLICATION_PROPERTIES.getCurrency());
        return user;
    }

    public void addUser(User user) {
        APPLICATION_PROPERTIES.getUsers().put(user.getUserId(), user);
        ApplicationProperties.saveUsersListToFile();
    }

    public void deleteUser(User user) {
        APPLICATION_PROPERTIES.getUsers().remove(user.getUserId());
        ApplicationProperties.saveUsersListToFile();
    }

    public User getUserById(long userId) {
        return APPLICATION_PROPERTIES.getUsers().get(userId);
    }

    public void updateUser(User user, Bank bank) {
        user.setBank(bank);
        addUser(user);
    }

    public void updateUser(User user, Currency currency) {
        List<Currency> userCurrencyList = user.getCurrencies();
        if (userCurrencyList.contains(currency)) {
            userCurrencyList.remove(currency);
        } else {
            userCurrencyList.add(currency);
        }
        addUser(user);
    }

    public void updateUser(User user, int value) {
        if (value < 5) {
            user.setSymbolsAfterComma(value); //символів після коми
        } else {
            user.setAlertTime(value); // час сповіщень
        }
        addUser(user);
    }
}
