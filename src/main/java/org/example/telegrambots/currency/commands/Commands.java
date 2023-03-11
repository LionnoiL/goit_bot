package org.example.telegrambots.currency.commands;

public enum Commands {
  HEADSIGN_MAINMENU("Чим Вам допомогти?","How can I help you? ⤵"),

  HEADSIGN_OPTIONS("Налаштування","Settings"),
  HEADSIGN_INFO("Ваші налаштування:","Your settings:"),

  HEADSIGN_COMMASYMBOLS("Знаків після коми","Symbols after comma"),
  HEADSIGN_BANKSMENU("Який банк Вас цікавить?","Choose your bank"),
  HEADSIGN_CURRENCYMENU("Яка валюта Вас цікавить?","Choose your currency"),
  HEADSIGN_NOTIFICATIONTIME("Коли сповістити?","Select notification time"),
  BACK("⬅ Назад", "⬅ Back"),
  MAIN_MENU("Головне меню","Main menu"),
  MAIN_GET_INFO("Інформація","Get info"),
  MAIN_OPTIONS("Налаштування","Options"),
  OPTIONS_NUMBER_SYMBOL_AFTER_COMMA("Точність","A number of symbols after comma"),
  OPTIONS_BANK("Банк","Bank"),
  OPTIONS_CURRENCY("Валюта","Currency"),
  OPTIONS_NOTIFICATIONS("Час сповіщень","Notification time"),
  NUMBERS_2("2","2"),
  NUMBERS_3("3","3"),
  NUMBERS_4("4","4"),
  CURRENCY_USD("Долар США","USD"),
  CURRENCY_EUR("Євро","EUR"),
  BANK_NBU("НБУ","NBU"),
  BANK_PRIVATBANK("ПриватБанк","Privatbank"),
  BANK_MONOBANK("Монобанк","Monobank"),
  ALERT_9("9:00","9:00"),
  ALERT_10("10:00","10:00"),
  ALERT_11("11:00","11:00"),
  ALERT_12("12:00","12:00"),
  ALERT_13("13:00","13:00"),
  ALERT_14("14:00","14:00"),
  ALERT_15("15:00","15:00"),
  ALERT_16("16:00","16:00"),
  ALERT_17("17:00","17:00"),
  ALERT_18("18:00","18:00"),
  ALERT_OFF("Вимкнути","Switch Off")
  ;

  private final String buttonText, buttonEngText;

  Commands(String buttonText, String buttonEngText) {
    this.buttonText = buttonText;
    this.buttonEngText = buttonEngText;
  }

  public String getButtonText() {
    return buttonText;
  }
  public String getButtonEngText(){
    return buttonEngText;
  }
}
