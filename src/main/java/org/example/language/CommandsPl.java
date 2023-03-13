package org.example.language;

public enum CommandsPl {
  HEADSIGN_MAINMENU("Jak mogę ci pomóc? ⤵"),
  HEADSIGN_OPTIONS("Ustawienia"),
  HEADSIGN_INFO("Wasze ustawienia"),
  HEADSIGN_COMMASYMBOLS("Symbole po przecinku"),
  HEADSIGN_BANKSMENU("Wybierz swój bank"),
  HEADSIGN_CURRENCYMENU("Wybierz swoją walutę"),
  HEADSIGN_NOTIFICATIONTIME("Wybierz godzinę powiadomienia"),
  BACK("⬅ Wróć"),
  MAIN_MENU("Menu główne"),
  MAIN_GET_INFO("Waluta"),
  MAIN_OPTIONS("Opcje"),
  OPTIONS_NUMBER_SYMBOL_AFTER_COMMA("Symbole po przecinku"),
  OPTIONS_BANK("Bank"),
  OPTIONS_CURRENCY("Waluta"),
  OPTIONS_NOTIFICATIONS("Czas powiadomienia"),
  NUMBERS_2("2"),
  NUMBERS_3("3"),
  NUMBERS_4("4"),
  CURRENCY_USD("USD"),
  CURRENCY_EUR("EUR"),
  CURRENCY_TXT("Waluta od %s:"),
  BUY("Kupić"),
  SELL("Sprzedać"),
  ALLERT_FIRST_PART("Informacje o kursach walut dla banku "),
  ALLERT_SECOND_PART(" nieobecny!"),
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
  OPTIONS_LANGUAGE("Język"),
  UA_BUTTON("Українська"),
  EN_BUTTON("English"),
  PL_BUTTON("Polski");

  private final String text;

  CommandsPl(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
