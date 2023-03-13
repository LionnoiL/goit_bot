package org.example.language;

public enum CommandsUa {
  HEADSIGN_MAINMENU("Чим Вам допомогти? ⤵"),
  HEADSIGN_OPTIONS("Налаштування"),
  HEADSIGN_INFO("Ваші налаштування:"),
  HEADSIGN_COMMASYMBOLS("Знаків після коми"),
  HEADSIGN_BANKSMENU("Який банк Вас цікавить?"),
  HEADSIGN_CURRENCYMENU("Яка валюта Вас цікавить?"),
  HEADSIGN_NOTIFICATIONTIME("Коли сповістити?"),
  BACK("⬅ Назад"),
  MAIN_MENU("Головне меню"),
  MAIN_GET_INFO("Курс валют"),
  MAIN_OPTIONS("Налаштування"),
  OPTIONS_NUMBER_SYMBOL_AFTER_COMMA("Точність"),
  OPTIONS_BANK("Банк"),
  OPTIONS_CURRENCY("Валюта"),
  OPTIONS_NOTIFICATIONS("Час сповіщень"),
  NUMBERS_2("2"),
  NUMBERS_3("3"),
  NUMBERS_4("4"),
  CURRENCY_USD("Долар США"),
  CURRENCY_EUR("Євро"),
  CURRENCY_TXT("Курс в %s:"),
  BUY("Купівля"),
  SELL("Продаж"),
  ALLERT_FIRST_PART("Інформація про курси валют по банку "),
  ALLERT_SECOND_PART(" відсутня!"),
  NBU("НБУ"),
  PRIVATBANK("ПриватБанк"),
  MONOBANK("Монобанк"),
  OSCHADBANK("Ощадбанк"),
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
  ALERT_OFF("Вимкнути");

  private final String text;

  CommandsUa(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
