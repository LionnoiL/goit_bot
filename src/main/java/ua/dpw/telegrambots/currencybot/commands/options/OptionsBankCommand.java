package ua.dpw.telegrambots.currencybot.commands.options;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.currency.bank.Bank;
import ua.dpw.telegrambots.bot.commands.BotCommand;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;
import ua.dpw.telegrambots.currencybot.menus.BankMenu;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;
import ua.dpw.users.UserService;

public class OptionsBankCommand extends BotCommand {

    public OptionsBankCommand() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {
        updateUserBank(userMessage);

        InlineKeyboardMarkup menu = new BankMenu().createMenu(userMessage);
        getTelegramService().sendMessage(userMessage.getChatId(),
            userMessage.getUser().getLanguage().get("HEADSIGN_BANKSMENU"),
            menu);
    }

    private void updateUserBank(UserMessage userMessage) {
        if (UserMessage.isBlankCallback(userMessage)) {
            return;
        }
        UserService userService = new UserService();
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case BANK_PRIVATBANK:
                userService.updateUser(userMessage.getUser(), Bank.PRIVATBANK);
                break;
            case BANK_MONOBANK:
                userService.updateUser(userMessage.getUser(), Bank.MONOBANK);
                break;
            case BANK_NBU:
                userService.updateUser(userMessage.getUser(), Bank.NBU);
                break;
            case BANK_OSCHADBANK:
                userService.updateUser(userMessage.getUser(), Bank.OSCHADBANK);
                break;
            default:
        }
    }
}
