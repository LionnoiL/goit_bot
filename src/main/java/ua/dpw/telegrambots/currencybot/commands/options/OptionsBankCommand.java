package ua.dpw.telegrambots.currencybot.commands.options;

import static ua.dpw.telegrambots.currencybot.commands.Commands.BANK_MONOBANK;
import static ua.dpw.telegrambots.currencybot.commands.Commands.BANK_NBU;
import static ua.dpw.telegrambots.currencybot.commands.Commands.BANK_OSCHADBANK;
import static ua.dpw.telegrambots.currencybot.commands.Commands.BANK_PRIVATBANK;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.currency.bank.Bank;
import ua.dpw.telegrambots.bot.commands.BotCommand;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.menus.BankMenu;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;
import ua.dpw.users.User;
import ua.dpw.users.UserService;

public class OptionsBankCommand extends BotCommand {

    public OptionsBankCommand() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {
        UserService userService = new UserService();
        User user = userMessage.getUser();

        if (BANK_PRIVATBANK.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(user, Bank.PRIVATBANK);
        } else if (BANK_MONOBANK.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(user, Bank.MONOBANK);
        } else if (BANK_NBU.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(user, Bank.NBU);
        } else if (BANK_OSCHADBANK.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(user, Bank.OSCHADBANK);
        }

        InlineKeyboardMarkup menu = new BankMenu().createMenu(userMessage);
        getTelegramService().sendMessage(userMessage.getChatId(),
            userMessage.getUser().getLanguage().get("HEADSIGN_BANKSMENU"),
            menu);
    }
}
