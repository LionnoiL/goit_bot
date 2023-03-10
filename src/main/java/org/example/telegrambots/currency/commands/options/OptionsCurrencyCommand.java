package org.example.telegrambots.currency.commands.options;

import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.menus.CurrencyMenu;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class OptionsCurrencyCommand extends BotCommand {
    public OptionsCurrencyCommand () { super (new TelegramService(new CurrencySender()));}
    @Override
    public void execute(UserMessage userMessage) {
        InlineKeyboardMarkup menu = new CurrencyMenu().createMenu(userMessage);

        getTelegramService().sendMessage(userMessage.getChatId(), "Choose your currency",
                menu);
    }
}
