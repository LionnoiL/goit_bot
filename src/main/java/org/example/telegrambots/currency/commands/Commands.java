package org.example.telegrambots.currency.commands;

public enum Commands {
  MAIN_GET_INFO("Get info"),
  MAIN_OPTIONS("Options"),
  OPTIONS_NUMBER_SIMBOLS_AFTER_COMMA("A number of simbols after comma"),
  OPTIONS_BANK("Bank"),
  OPTIONS_CURRENCY("Currency"),
  NUMBERS_2("2"),
  NUMBERS_3("3"),
  NUMBERS_4("4"),
  ;

  private String buttonText;

  Commands(String buttonText) {
    this.buttonText = buttonText;
  }

  public String getButtonText() {
    return buttonText;
  }
}
