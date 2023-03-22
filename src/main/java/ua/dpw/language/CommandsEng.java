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
  HEADSIGN_USERTIME("Enter the number of hours now ⤵"),
  BACK("⬅ Back"),
  MAIN_MENU("Main menu"),
  MAIN_GET_INFO("Currency rates"),
  MAIN_OPTIONS("Options"),
  OPTIONS_NUMBER_SYMBOL_AFTER_COMMA("Symbols after comma"),
  OPTIONS_BANK("Bank"),
  OPTIONS_CURRENCY("Currency"),
  OPTIONS_NOTIFICATIONS("Notification time"),
  OPTIONS_USERTIME("Set your time"),
  NUMBERS_2("2"),
  NUMBERS_3("3"),
  NUMBERS_4("4"),
  CURRENCY_USD("USD"),
  CURRENCY_EUR("EUR"),
  MESSAGE_SERVICE_HEADER("Currency from %s:"),
  MESSAGE_SERVICE_BODY_ROW("\n%s/UAH:\nBuy\t%s\nSell\t%s"),
  MESSAGE_SERVICE_BANK_RATES_NOT_FOUND("At the moment, there is no information about the exchange rates of \"%s\". Please select another bank in the settings."),
  MESSAGE_CURRENCY_NOT_SELECTED("To get information about the exchange rate, please select the currency you are interested in in the settings."),
  CRYPTOCURRENCY("Cryptocurrency"),
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
  PL_BUTTON("Polski"),
  TIME_0("00"),
  TIME_1("01"),
  TIME_2("02"),
  TIME_3("03"),
  TIME_4("04"),
  TIME_5("05"),
  TIME_6("06"),
  TIME_7("07"),
  TIME_8("08"),
  TIME_9("09"),
  TIME_10("10"),
  TIME_11("11"),
  TIME_12("12"),
  TIME_13("13"),
  TIME_14("14"),
  TIME_15("15"),
  TIME_16("16"),
  TIME_17("17"),
  TIME_18("18"),
  TIME_19("19"),
  TIME_20("20"),
  TIME_21("21"),
  TIME_22("22"),
  TIME_23("23"),
  BITCOIN("Bitcoin"),
  ETHEREUM("Ethereum"),
  HOME("Home"),
  HELP("Help"),
  HELP_MESSAGE(
        "This bot will help you track current exchange rates from different banks. "
            + "The bot can provide information both on request and automatically according to the specified schedule.\n\n"
            + "To get the exchange rate of the selected bank, click the \"Currency rates\" button in the main menu\n\n"
            + "To configure the bot's convenient operating mode, use the \"Settings\" menu section.");

  private final String text;

  CommandsEng(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
