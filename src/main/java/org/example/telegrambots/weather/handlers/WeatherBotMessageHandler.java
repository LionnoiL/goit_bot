package org.example.telegrambots.weather.handlers;

import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.weather.commands.GetInfoCommand;
import org.telegram.telegrambots.meta.api.objects.Update;

public class WeatherBotMessageHandler {

  private WeatherBotMessageHandler() {
  }

  public static void resolveMessage(Update update) {
    if (update.hasMessage() || update.hasCallbackQuery()) {
      UserMessage userMessage = UserMessage.fromTelegramUpdate(update);
      if (userMessage == null) {
        return;
      }
      new GetInfoCommand().execute(userMessage);
    }
  }
}
