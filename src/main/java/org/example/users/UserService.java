package org.example.users;

import static org.example.AppLauncher.APPLICATION_PROPERTIES;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;
import org.example.properties.ApplicationProperties;

public class UserService {

    public User createUser(long userId, String firstName, String lastName){
        User user = new User();
        user.setUserId(userId);
        user.setUserName(firstName);
        user.setLastName(lastName);
        user.setUserHours(0);
        user.setAlertTime(100);
        user.setSymbolsAfterComma(APPLICATION_PROPERTIES.getDecimalPrecision());
        user.setBank(APPLICATION_PROPERTIES.getBank());
        user.setCurrencies(Collections.singletonList(APPLICATION_PROPERTIES.getCurrency()));
        return user;
    }

    public void addUser(User user) {
        Map<Long, User> users = APPLICATION_PROPERTIES.getUsers();
        users.put(user.getUserId(), user);
        APPLICATION_PROPERTIES.setUsers(users);
        ApplicationProperties.saveUsersListToFile();
    }

    public void deleteUser(User user) {
        Map<Long, User> users = APPLICATION_PROPERTIES.getUsers();
        users.remove(user.getUserId());
        APPLICATION_PROPERTIES.setUsers(users);
        ApplicationProperties.saveUsersListToFile();
    }

    public User getUserById(long userId){
        Map<Long, User> users = APPLICATION_PROPERTIES.getUsers();
        return users.get(userId);
    }
    public void updateUser(User user, Bank bank){
        user.setBank(bank);
        addUser(user);
    }

    public void updateUser(User user, Currency currency){
        List<Currency> userCurrencyList = user.getCurrencies();
        if( userCurrencyList.contains(currency)){
            userCurrencyList.remove(currency);
        } else {
            userCurrencyList.add(currency);
        }
        user.setCurrencies(userCurrencyList);
        addUser(user);
    }

    public void updateUser(User user, int value){
        if (value<5) {
            user.setSymbolsAfterComma(value); //символів після коми
        } else {
            user.setAlertTime(value); // час сповіщень
        }
            addUser(user);
    }
}
