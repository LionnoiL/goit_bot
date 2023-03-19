package ua.dpw.telegrambots.currencybot.commands.options;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.telegrambots.bot.commands.BotCommand;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;
import ua.dpw.telegrambots.currencybot.menus.CurrencyMenu;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;
import ua.dpw.users.UserService;

public class OptionsCurrencyCommand extends BotCommand {

    public OptionsCurrencyCommand() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {
        updateUserCurrency(userMessage);

        InlineKeyboardMarkup menu = new CurrencyMenu().createMenu(userMessage);
        getTelegramService().sendMessage(userMessage.getChatId(),
            userMessage.getUser().getLanguage().get("HEADSIGN_CURRENCYMENU"),
            menu);
    }

    private void updateUserCurrency(UserMessage userMessage) {
        if (UserMessage.isBlankCallback(userMessage)) {
            return;
        }
        UserService userService = new UserService();
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case CURRENCY_EUR:
                userService.updateUser(userMessage.getUser(), Currency.EUR);
                break;
            case CURRENCY_USD:
                userService.updateUser(userMessage.getUser(), Currency.USD);
                break;
            case CURRENCY_BITCOIN:
                userService.updateUser(userMessage.getUser(), Currency.BITCOIN);
                break;
            case CURRENCY_ETHEREUM:
                userService.updateUser(userMessage.getUser(), Currency.ETHEREUM);
                break;
            default:
        }
    }
}
