package org.example.telegrambots.weather.commands;

import lombok.Getter;
import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.weather.sender.WeatherSender;

@Getter
public class GetInfoCommand extends BotCommand {

  public GetInfoCommand() {
    super(new TelegramService(new WeatherSender()));
  }

  @Override
  public void execute(UserMessage userMessage) {
    getTelegramService().sendMessage(userMessage.getChatId(), "weather");
  }
}
