package org.example.properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;
import org.example.users.User;
import org.example.utils.FilesUtils;

@Getter
public class ApplicationProperties {

  static final String RESOURCES_PATH = "src/main/resources/";
  private final String FILE_NAME = "application.properties";
  private int decimalPrecision;
  private Bank bank;
  private Currency currency;
  private Map<Integer, User> users;

  public ApplicationProperties() {
    loadFromFile();
    users = getUsersListFromFile();
  }

  private void loadFromFile() {
    String decimalPrecisionString = PropertiesService.getApplicationProperties(FILE_NAME,
        "decimalPrecision");
    String bankString = PropertiesService.getApplicationProperties(FILE_NAME, "bank");
    String currencyString = PropertiesService.getApplicationProperties(FILE_NAME, "currency");

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

  public Map<Integer, User> getUsersListFromFile() {
    Gson gson = new Gson();
    Map<Integer, User> users = new HashMap<>();
    FileReader fileReader = null;

    File file = new File(RESOURCES_PATH + "users.json");
    if (!file.exists()) {
      FilesUtils.saveTextFile(RESOURCES_PATH + "users.json", "{}");
    }

    try {
      fileReader = new FileReader(RESOURCES_PATH + "users.json");
      users = new Gson().fromJson(fileReader, new TypeToken<Map<Integer, User>>() {
      }.getType());
    } catch (Exception e) {

    }
    return users;
  }

  public void saveUsersListToFile() {

  }
}
