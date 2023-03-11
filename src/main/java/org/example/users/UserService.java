package org.example.users;

import static org.example.AppLauncher.APPLICATION_PROPERTIES;

import java.util.Map;
import org.example.properties.ApplicationProperties;

public class UserService {

    public User createUser(long userId, String firstName, String lastName, String language){
        User user = new User();
        user.setUserId(userId);
        user.setUserName(firstName);
        user.setLastName(lastName);
        user.setUserHours(0);
        user.setAlertTime(100);
        user.setSymbolsAfterComma(APPLICATION_PROPERTIES.getDecimalPrecision());
        user.setBank(APPLICATION_PROPERTIES.getBank());
        user.setCurrency(APPLICATION_PROPERTIES.getCurrency());
        user.setLanguage(language);
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
}
