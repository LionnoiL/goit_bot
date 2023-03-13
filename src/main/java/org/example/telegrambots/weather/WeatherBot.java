package org.example.telegrambots.weather;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.telegrambots.weather.handlers.WeatherBotMessageHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
public class WeatherBot extends TelegramLongPollingBot {

  private static final Logger LOG = LogManager.getLogger(WeatherBot.class);
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
