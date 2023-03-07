package org.example.telegrambots.bot.sender;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public abstract class BotSender extends DefaultAbsSender {

  protected BotSender(DefaultBotOptions options, String botToken) {
    super(options, botToken);
  }
}
