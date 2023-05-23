package ua.dpw;

import java.util.ArrayList;
import java.util.List;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.users.User;

public class TestUtil {

    public static int getUserAlertTime() {
        return 10;
    }

    public static List<User> getUsersList() {
        List<User> users = new ArrayList<>();
        users.add(getUser());
        return users;
    }

    public static User getUser() {
        User user1 = new User();
        user1.setUserId(1L);
        user1.setLangCode("en");
        user1.setUserName("Tom");
        user1.setLastName("Sojer");
        user1.setBank(new Bank(1, "PRIVATBANK"));
        user1.setCurrencies(List.of(new Currency(1, "USD")));
        return user1;
    }
}
