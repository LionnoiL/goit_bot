package ua.dpw.language;

public enum CommandsEng {
  START_MESSAGE("Congratulations! We are very glad that you have joined our service. This bot will help you track current exchange rates from different banks. The bot can provide information both on request and automatically according to the specified schedule. To configure the bot's convenient operating mode, use the \"Settings\" menu section."),
  HEADSIGN_MAINMENU("How can I help you? ⤵"),
  HEADSIGN_OPTIONS("Settings"),
  HEADSIGN_INFO("Your settings:"),
  HEADSIGN_COMMASYMBOLS("Symbols after comma"),
  HEADSIGN_BANKSMENU("Choose your bank"),
  HEADSIGN_CURRENCYMENU("Choose your currency"),
  HEADSIGN_NOTIFICATIONTIME("Select notification time"),
  BACK("⬅ Back"),
  MAIN_MENU("Main menu"),
  MAIN_GET_INFO("Currency rates"),
  MAIN_OPTIONS("Options"),
  OPTIONS_NUMBER_SYMBOL_AFTER_COMMA("Symbols after comma"),
  OPTIONS_BANK("Bank"),
  OPTIONS_CURRENCY("Currency"),
  OPTIONS_NOTIFICATIONS("Notification time"),
  NUMBERS_2("2"),
  NUMBERS_3("3"),
  NUMBERS_4("4"),
  CURRENCY_USD("USD"),
  CURRENCY_EUR("EUR"),
  MESSAGE_SERVICE_HEADER("Currency from %s:"),
  MESSAGE_SERVICE_BODY_ROW("\n\n%s/UAN:\nBuy\t%s\nSell\t%s"),
  MESSAGE_SERVICE_BANK_RATES_NOT_FOUND("At the moment, there is no information about the exchange rates of \"%s\". Please select another bank in the settings."),
  NBU("NBU"),
  PRIVATBANK("Privatbank"),
  MONOBANK("Monobank"),
  OSCHADBANK("Oschadbank"),
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
  ALERT_OFF("Switch Off"),
  OPTIONS_LANGUAGE("Language"),
  UA_BUTTON("Українська"),
  EN_BUTTON("English"),
  PL_BUTTON("Polski");

  private final String text;

  CommandsEng(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
