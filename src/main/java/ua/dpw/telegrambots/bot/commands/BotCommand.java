package ua.dpw.telegrambots.bot.commands;

import lombok.Data;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;

@Data
public abstract class BotCommand {

    private final TelegramService telegramService;

    public abstract void execute(UserMessage userMessage);
}
