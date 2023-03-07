package org.example.telegrambots.bot.commands;

import lombok.Data;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;

@Data
public abstract class BotCommand {

  private final TelegramService telegramService;

  public abstract void execute(UserMessage userMessage);
}
