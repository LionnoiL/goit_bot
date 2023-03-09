package org.example.telegrambots.currency.commands;

public enum Commands {
  BACK("⬅ Back"),
  MAIN_MENU("Main menu"),
  MAIN_GET_INFO("Get info"),
  MAIN_OPTIONS("Options"),
  OPTIONS_NUMBER_SYMBOL_AFTER_COMMA("A number of symbols after comma"),
  OPTIONS_BANK("Bank"),
  OPTIONS_CURRENCY("Currency"),
  NUMBERS_2("2"),
  NUMBERS_3("3"),
  NUMBERS_4("4"),
  CURRENCY_USD("USD"),
  CURRENCY_EUR("EUR"),
  BANK_NBU("NBU"),
  BANK_PRIVATBANK("Privatbank"),
  BANK_MONOBANK("Monobank"),
  NOTIFICATION("Notification time")
  ;

  private String buttonText;

  Commands(String buttonText) {
    this.buttonText = buttonText;
  }

  public String getButtonText() {
    return buttonText;
  }
}
