package ua.dpw.telegrambots.currencybot.commands.options;

import static ua.dpw.telegrambots.currencybot.commands.Commands.CURRENCY_EUR;
import static ua.dpw.telegrambots.currencybot.commands.Commands.CURRENCY_USD;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.telegrambots.bot.commands.BotCommand;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.menus.CurrencyMenu;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;
import ua.dpw.users.User;
import ua.dpw.users.UserService;

public class OptionsCurrencyCommand extends BotCommand {

    public OptionsCurrencyCommand() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {
        UserService userService = new UserService();
        User user = userMessage.getUser();

        if (CURRENCY_EUR.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(user, Currency.EUR);
        } else if (CURRENCY_USD.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(user, Currency.USD);
        }

        InlineKeyboardMarkup menu = new CurrencyMenu().createMenu(userMessage);
        getTelegramService().sendMessage(userMessage.getChatId(),
            userMessage.getUser().getLanguage().get("HEADSIGN_CURRENCYMENU"),
            menu);
    }
}
