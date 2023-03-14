package ua.dpw.properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.dpw.AppLauncher;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.users.User;
import ua.dpw.utils.FilesUtils;

@Getter
public class ApplicationProperties {

    public static final String CACHE_PATH = "cache/";
    public static final String CONFIG_PATH = "config/";
    public static final String BASE_PATH = "db/";
    public static final String RESOURCES_PATH = "";
    public static final String APPLICATION_PROPERTIES_FILE_NAME =
        CONFIG_PATH + "application.properties";
    public static final String JSON_USERS_FILE_NAME = BASE_PATH + "users.json";
    public static final String MARK_EMOJI = "✔";
    private static final Logger LOG = LogManager.getLogger(ApplicationProperties.class);
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

        if (!decimalPrecisionString.isBlank()) {
            decimalPrecision = Integer.parseInt(decimalPrecisionString);
        } else {
            decimalPrecision = 2;
        }

        if (!bankString.isBlank()) {
            bank = Bank.valueOf(bankString);
        } else {
            bank = Bank.NBU;
        }

        if (!currencyString.isBlank()) {
            currency = Currency.valueOf(currencyString);
        } else {
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
            savedUsers = new Gson().fromJson(fileReader, new TypeToken<Map<Long, User>>() {
            }.getType());
        } catch (Exception e) {
            LOG.warn("Error read users file from " + JSON_USERS_FILE_NAME);
        }
        return savedUsers;
    }
}