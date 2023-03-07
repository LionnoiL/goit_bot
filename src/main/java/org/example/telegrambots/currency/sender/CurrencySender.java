package org.example.telegrambots.currency.sender;

import org.example.telegrambots.bot.sender.BotSender;
import org.example.telegrambots.currency.CurrencyBot;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class CurrencySender extends BotSender {

  public CurrencySender() {
    super(new DefaultBotOptions(), CurrencyBot.PROPERTIES.getToken());
  }
}
