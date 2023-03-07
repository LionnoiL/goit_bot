package org.example.telegrambots.weather;

import java.util.logging.Logger;
import lombok.Getter;
import org.example.telegrambots.weather.handlers.WeatherBotMessageHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
public class WeatherBot extends TelegramLongPollingBot {

  public static final Logger LOG = Logger.getLogger(WeatherBot.class.getName());
  public static final BotProperties PROPERTIES = new BotProperties();

  public WeatherBot() {
    super(PROPERTIES.getToken());
  }

  @Override
  public void onUpdateReceived(Update update) {
    WeatherBotMessageHandler.resolveMessage(update);
  }

  @Override
  public String getBotUsername() {
    return PROPERTIES.getName();
  }
}
