package org.example.auto.language.switcher;

public enum CommandsUa {
  BACK("⬅ Назад"),
  MAIN_MENU("Головне меню"),
  MAIN_GET_INFO("Інформація"),
  MAIN_OPTIONS("Налаштування"),
  OPTIONS_NUMBER_SYMBOL_AFTER_COMMA("Знаків після коми"),
  OPTIONS_BANK("Банк"),
  OPTIONS_CURRENCY("Валюта"),
  NUMBERS_2("2"),
  NUMBERS_3("3"),
  NUMBERS_4("4"),
  CURRENCY_USD("Долар США"),
  CURRENCY_EUR("Євро"),
  BANK_NBU("НБУ"),
  BANK_PRIVATBANK("ПриватБанк"),
  BANK_MONOBANK("Монобанк"),
  NOTIFICATION("Час сповіщення")
  ;

  private final String buttonText;

  CommandsUa(String buttonText) {
    this.buttonText = buttonText;
  }

  public String getButtonText() {
    return buttonText;
  }
}
