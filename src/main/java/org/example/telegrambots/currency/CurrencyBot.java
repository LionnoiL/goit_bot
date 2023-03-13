package org.example.telegrambots.currency;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.telegrambots.currency.handlers.CurrencyBotMessageHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
public class CurrencyBot extends TelegramLongPollingBot {

  public static final Logger LOG = LogManager.getLogger(CurrencyBot.class);
  public static final BotProperties PROPERTIES = new BotProperties();

  public CurrencyBot() {
    super(PROPERTIES.getToken());
  }

  @Override
  public void onUpdateReceived(Update update) {
    CurrencyBotMessageHandler.resolveMessage(update);
  }

  @Override
  public String getBotUsername() {
    return PROPERTIES.getName();
  }
}
