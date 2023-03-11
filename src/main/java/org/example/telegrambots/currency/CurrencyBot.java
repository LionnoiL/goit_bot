package org.example.telegrambots.currency;

import java.util.logging.Logger;
import lombok.Getter;
import org.example.auto.language.switcher.AutoLanguageSwitcher;
import org.example.telegrambots.currency.handlers.CurrencyBotMessageHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
public class CurrencyBot extends TelegramLongPollingBot {

  public static final Logger LOG = Logger.getLogger(CurrencyBot.class.getName());
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
