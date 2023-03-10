package org.example.telegrambots.currency.commands;

public enum Commands {
  BACK("⬅ Назад", "⬅ Back"),
  MAIN_MENU("Головне меню","Main menu"),
  MAIN_GET_INFO("Інформація","Get info"),
  MAIN_OPTIONS("Налаштування","Options"),
  OPTIONS_NUMBER_SYMBOL_AFTER_COMMA("Знаків після коми","A number of symbols after comma"),
  OPTIONS_BANK("Банк","Bank"),
  OPTIONS_CURRENCY("Валюта","Currency"),
  NUMBERS_2("2","2"),
  NUMBERS_3("3","3"),
  NUMBERS_4("4","4"),
  CURRENCY_USD("Долар США","USD"),
  CURRENCY_EUR("Євро","EUR"),
  BANK_NBU("НБУ","NBU"),
  BANK_PRIVATBANK("ПриватБанк","Privatbank"),
  BANK_MONOBANK("Монобанк","Monobank"),
  NOTIFICATION("Час сповіщення","Notification time")
  ;

  private final String buttonUkrText, buttonEngText;

  Commands(String buttonText, String buttonEngText) {
    this.buttonUkrText = buttonText;
    this.buttonEngText = buttonEngText;
  }

  public String getButtonUkrText() {
    return buttonUkrText;
  }
  public String getButtonEngText(){
    return buttonEngText;
  }
}
