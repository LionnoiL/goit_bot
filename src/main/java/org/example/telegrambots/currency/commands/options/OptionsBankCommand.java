package org.example.telegrambots.currency.commands.options;

import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.menus.BankMenu;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class OptionsBankCommand extends BotCommand {
    public OptionsBankCommand() { super(new TelegramService(new CurrencySender()));}

    @Override
    public void execute(UserMessage userMessage) {
        InlineKeyboardMarkup menu = new BankMenu().createMenu(userMessage);

        getTelegramService().sendMessage(userMessage.getChatId(), "Choose your bank",
                menu);
    }
}
