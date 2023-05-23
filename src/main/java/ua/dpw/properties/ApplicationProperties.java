package ua.dpw.properties;

import static ua.dpw.database.Service.BANK_SERVICE;
import static ua.dpw.database.Service.CURRENCY_SERVICE;
import static ua.dpw.users.UserService.loadUsersFromFile;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.currencies.Currency;

@Getter
public class ApplicationProperties {

    public static final String CONFIG_PATH = "config/";
    public static final String APPLICATION_PROPERTIES_FILE_NAME =
        CONFIG_PATH + "application.properties";
    private static final Logger LOG = LogManager.getLogger(ApplicationProperties.class);
    private int decimalPrecision;
    private Bank bank;
    private Currency currency;

    public ApplicationProperties() {
        loadDefaultsPropertiesFromFile();
        loadUsersFromFile();
    }

    private void loadDefaultsPropertiesFromFile() {
        setDecimalPrecision();
        setBank();
        setCurrency();
    }

    private void setDecimalPrecision() {
        String decimalPrecisionString = PropertiesService.getApplicationProperties(
            APPLICATION_PROPERTIES_FILE_NAME,
            "decimalPrecision");
        if (!decimalPrecisionString.isBlank()) {
            decimalPrecision = Integer.parseInt(decimalPrecisionString);
        } else {
            decimalPrecision = 2;
        }
    }

    private void setBank() {
        String bankString = PropertiesService.getApplicationProperties(
            APPLICATION_PROPERTIES_FILE_NAME, "bank");
        if (!bankString.isBlank()) {
            bank = BANK_SERVICE.getByName(bankString);
        } else {
            bank = BANK_SERVICE.getByName("NBU");
        }
    }

    private void setCurrency() {
        String currencyString = PropertiesService.getApplicationProperties(
            APPLICATION_PROPERTIES_FILE_NAME, "currency");
        if (!currencyString.isBlank()) {
            currency = CURRENCY_SERVICE.getByName(currencyString);
        } else {
            currency = CURRENCY_SERVICE.getByName("USD");
        }
    }
}
