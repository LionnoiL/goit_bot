package org.example.properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.example.AppLauncher;
import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;
import org.example.users.User;
import org.example.utils.FilesUtils;

@Getter
public class ApplicationProperties {

    static final String RESOURCES_PATH = "src/main/resources/";
    static final String APPLICATION_PROPERTIES_FILE_NAME = "application.properties";
    static final String JSON_USERS_FILE_NAME = "users.json";
    private int decimalPrecision;
    private Bank bank;
    private Currency currency;
    @Setter
    private Map<Long, User> users;

    public ApplicationProperties() {
        loadFromFile();
        users = getUsersListFromFile();
    }

    public static void saveUsersListToFile() {
        FilesUtils.saveTextFile(RESOURCES_PATH + JSON_USERS_FILE_NAME,
            new Gson().toJson(AppLauncher.APPLICATION_PROPERTIES.getUsers()));
    }

    private void loadFromFile() {
        String decimalPrecisionString = PropertiesService.getApplicationProperties(
            APPLICATION_PROPERTIES_FILE_NAME,
            "decimalPrecision");
        String bankString = PropertiesService.getApplicationProperties(
            APPLICATION_PROPERTIES_FILE_NAME, "bank");
        String currencyString = PropertiesService.getApplicationProperties(
            APPLICATION_PROPERTIES_FILE_NAME, "currency");

        try {
            if (!decimalPrecisionString.isBlank()) {
                decimalPrecision = Integer.parseInt(decimalPrecisionString);
            }
        } finally {
            decimalPrecision = 2;
        }

        try {
            if (!bankString.isBlank()) {
                bank = Bank.valueOf(bankString);
            }
        } finally {
            bank = Bank.PRIVATBANK;
        }

        try {
            if (!currencyString.isBlank()) {
                currency = Currency.valueOf(currencyString);
            }
        } finally {
            currency = Currency.USD;
        }
    }

    public Map<Long, User> getUsersListFromFile() {
        Map<Long, User> savedUsers = new HashMap<>();
        String jsonFileName = RESOURCES_PATH + JSON_USERS_FILE_NAME;
        File file = new File(jsonFileName);
        if (!file.exists()) {
            FilesUtils.saveTextFile(jsonFileName, "{}");
        }

        try (FileReader fileReader = new FileReader(jsonFileName)) {
            savedUsers = new Gson().fromJson(fileReader, new TypeToken<Map<Integer, User>>() {
            }.getType());
        } catch (Exception e) {
            //NOP
        }
        return savedUsers;
    }
}
