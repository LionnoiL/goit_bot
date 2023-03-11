package org.example.telegrambots.currency.commands.options;

import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.example.telegrambots.currency.menus.NotificationMenu;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class OptionsNotificationCommand extends BotCommand {
    public OptionsNotificationCommand() {super (new TelegramService(new CurrencySender()));}

    @Override
    public void execute(UserMessage userMessage) {
        InlineKeyboardMarkup notificationMenu = new NotificationMenu().createMenu(userMessage);

        getTelegramService().sendMessage(userMessage.getChatId(), Commands.HEADSIGN_NOTIFICATIONTIME.getButtonText(),
                notificationMenu);
    }
}
