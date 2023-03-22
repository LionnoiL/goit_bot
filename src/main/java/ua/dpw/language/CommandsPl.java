package ua.dpw.language;

public enum CommandsPl {
  START_MESSAGE("Gratulacje! Bardzo się cieszymy, że dołączyłeś do naszego serwisu. Ten bot pomoże Ci śledzić aktualne kursy walut z różnych banków. Bot może przekazywać informacje zarówno na żądanie, jak i automatycznie według określonego harmonogramu. Aby skonfigurować wygodny tryb pracy bota, skorzystaj z sekcji menu „Ustawienia”."),
  HEADSIGN_MAINMENU("Jak mogę ci pomóc? ⤵"),
  HEADSIGN_OPTIONS("Ustawienia"),
  HEADSIGN_INFO("Wasze ustawienia"),
  HEADSIGN_COMMASYMBOLS("Symbole po przecinku"),
  HEADSIGN_BANKSMENU("Wybierz swój bank"),
  HEADSIGN_CURRENCYMENU("Wybierz swoją walutę"),
  HEADSIGN_NOTIFICATIONTIME("Wybierz godzinę powiadomienia"),
  HEADSIGN_USERTIME("Wprowadź teraz swoje godziny ⤵"),
  BACK("⬅ Wróć"),
  MAIN_MENU("Menu główne"),
  MAIN_GET_INFO("Kurs wymiany"),
  MAIN_OPTIONS("Opcje"),
  OPTIONS_NUMBER_SYMBOL_AFTER_COMMA("Symbole po przecinku"),
  OPTIONS_BANK("Bank"),
  OPTIONS_CURRENCY("Waluta"),
  OPTIONS_NOTIFICATIONS("Czas powiadomienia"),
  OPTIONS_USERTIME("Swój czas"),
  NUMBERS_2("2"),
  NUMBERS_3("3"),
  NUMBERS_4("4"),
  CURRENCY_USD("USD"),
  CURRENCY_EUR("EUR"),
  MESSAGE_SERVICE_HEADER("Waluta od %s:"),
  MESSAGE_SERVICE_BODY_ROW("\n%s/UAH:\nKupić\t%s\nSprzedać\t%s"),
  MESSAGE_SERVICE_BANK_RATES_NOT_FOUND("Informacje o kursach walut dla banku \"%s\" nieobecny! Proszę wybrać inny bank w ustawieniach."),
  MESSAGE_CURRENCY_NOT_SELECTED("Aby uzyskać informacje o kursie walut, wybierz w ustawieniach interesującą Cię walutę."),
  CRYPTOCURRENCY("Kryptowaluty"),
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
  ALERT_OFF("Wyłączyć"),
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
  OPTIONS_LANGUAGE("Język"),
  UA_BUTTON("Українська"),
  EN_BUTTON("English"),
  PL_BUTTON("Polski"),
  BITCOIN("Bitcoin"),
  ETHEREUM("Ethereum"),
  HOME("Dom"),
  HELP("Pomoc"),
  HELP_MESSAGE(
      "Ten bot pomoże Ci śledzić aktualne kursy walut z różnych banków. "
          + "Bot może przekazywać informacje zarówno na żądanie, jak i automatycznie według określonego harmonogramu.\n\n"
          + "Aby uzyskać kurs wybranego banku, kliknij przycisk „Kurs wymiany” w menu głównym\n\n"
          + "Aby skonfigurować wygodny tryb pracy bota, skorzystaj z sekcji menu „Ustawienia”.");

  private final String text;

  CommandsPl(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
