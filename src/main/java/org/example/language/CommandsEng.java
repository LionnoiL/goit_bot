package org.example.language;

public enum CommandsEng {
  HEADSIGN_MAINMENU("How can I help you? ⤵"),
  HEADSIGN_OPTIONS("Settings"),
  HEADSIGN_INFO("Your settings:"),
  HEADSIGN_COMMASYMBOLS("Symbols after comma"),
  HEADSIGN_BANKSMENU("Choose your bank"),
  HEADSIGN_CURRENCYMENU("Choose your currency"),
  HEADSIGN_NOTIFICATIONTIME("Select notification time"),
  BACK("⬅ Back"),
  MAIN_MENU("Main menu"),
  MAIN_GET_INFO("Currency"),
  MAIN_OPTIONS("Options"),
  OPTIONS_NUMBER_SYMBOL_AFTER_COMMA("A number of symbols after comma"),
  OPTIONS_BANK("Bank"),
  OPTIONS_CURRENCY("Currency"),
  OPTIONS_NOTIFICATIONS("Notification time"),
  NUMBERS_2("2"),
  NUMBERS_3("3"),
  NUMBERS_4("4"),
  CURRENCY_USD("USD"),
  CURRENCY_EUR("EUR"),
  BANK_NBU("NBU"),
  BANK_PRIVATBANK("Privatbank"),
  BANK_MONOBANK("Monobank"),
  BANK_OSCHADBANK("Oschadbank"),
  ALERT_9("9:00"),
  ALERT_10("10:00"),
  ALERT_11("11:00"),
  ALERT_12("12:00"),
  ALERT_13("13:00"),
  ALERT_14("14:00"),
  ALERT_15("15:00"),
  ALERT_16("16:00"),
  ALERT_17("17:00"),
  ALERT_18("18:00"),
  ALERT_OFF("Switch Off");

  private final String buttonText;

  CommandsEng(String buttonText) {
    this.buttonText = buttonText;
  }

  public String getButtonText() {
    return buttonText;
  }
}
