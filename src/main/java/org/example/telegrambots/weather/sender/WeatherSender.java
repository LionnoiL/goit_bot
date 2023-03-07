package org.example.telegrambots.weather.sender;

import org.example.telegrambots.bot.sender.BotSender;
import org.example.telegrambots.weather.WeatherBot;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class WeatherSender extends BotSender {

  public WeatherSender() {
    super(new DefaultBotOptions(), WeatherBot.PROPERTIES.getToken());
  }
}
