package org.example.properties;

import lombok.Getter;
import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;

@Getter
public class ApplicationProperties {

  private final String FILE_NAME = "application.properties";
  private int decimalPrecision;
  private Bank bank;
  private Currency currency;

  public ApplicationProperties() {
    loadFromFile();
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
}
