package org.example.telegrambots.currency.commands.options;

import static org.example.telegrambots.currency.commands.Commands.CURRENCY_EUR;
import static org.example.telegrambots.currency.commands.Commands.CURRENCY_USD;

import org.example.currency.currencies.Currency;
import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.example.telegrambots.currency.menus.CurrencyMenu;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.example.users.UserService;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class OptionsCurrencyCommand extends BotCommand {

    public OptionsCurrencyCommand() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {
        UserService userService = new UserService();
        if (CURRENCY_EUR.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(userMessage.getUser(), Currency.EUR);
        } else if (CURRENCY_USD.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(userMessage.getUser(), Currency.USD);
        }

        InlineKeyboardMarkup menu = new CurrencyMenu().createMenu(userMessage);

        getTelegramService().sendMessage(userMessage.getChatId(),
            Commands.HEADSIGN_CURRENCYMENU.getButtonText(userMessage),
            menu);
    }
}
