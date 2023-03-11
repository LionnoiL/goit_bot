package org.example.telegrambots.currency.commands.options;

import org.example.currency.currencies.Currency;
import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.menus.CurrencyMenu;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.example.users.User;
import org.example.users.UserService;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import static org.example.telegrambots.currency.commands.Commands.*;

public class OptionsCurrencyCommand extends BotCommand {
    public OptionsCurrencyCommand () { super (new TelegramService(new CurrencySender()));}
    @Override
    public void execute(UserMessage userMessage) {
        if (CURRENCY_EUR.toString().equals(userMessage.getCallBack())) {
            User user = userMessage.getUser();
            UserService userService = new UserService();
            userService.updateUser(user, Currency.EUR);
        } else if (CURRENCY_USD.toString().equals(userMessage.getCallBack())) {
                User user = userMessage.getUser();
                UserService userService = new UserService();
                userService.updateUser(user, Currency.USD);
        }

        InlineKeyboardMarkup menu = new CurrencyMenu().createMenu(userMessage);

        getTelegramService().sendMessage(userMessage.getChatId(), userMessage.getUser().getLanguage().get("HEADSIGN_CURRENCYMENU"),
                menu);
    }
}
