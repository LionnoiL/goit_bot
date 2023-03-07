package org.example;

import org.example.telegrambots.currency.CurrencyBot;
import org.example.telegrambots.weather.WeatherBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class AppLauncher {

  public static void main(String[] args) {

    try {
      TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
      botsApi.registerBot(new CurrencyBot());
      botsApi.registerBot(new WeatherBot());
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }
}