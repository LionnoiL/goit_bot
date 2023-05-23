package ua.dpw.telegrambots.currencybot.commands.options;

import static ua.dpw.database.Service.BANK_SERVICE;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
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
        getTelegramService().sendEditedMenu(userMessage.getChatId(), userMessage.getMessageId(),
            userMessage.getUser().getTranslate("HEADSIGN_BANKSMENU"),
            menu);
    }

    private void updateUserBank(UserMessage userMessage) {
        if (UserMessage.isBlankCallback(userMessage)) {
            return;
        }
        UserService userService = new UserService();
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case BANK_PRIVATBANK:
                userService.updateUser(userMessage.getUser(), BANK_SERVICE.getByName("PRIVATBANK"));
                break;
            case BANK_MONOBANK:
                userService.updateUser(userMessage.getUser(), BANK_SERVICE.getByName("MONOBANK"));
                break;
            case BANK_NBU:
                userService.updateUser(userMessage.getUser(), BANK_SERVICE.getByName("NBU"));
                break;
            case BANK_OSCHADBANK:
                userService.updateUser(userMessage.getUser(), BANK_SERVICE.getByName("OSCHADBANK"));
                break;
            default:
        }
    }
}
