package ua.dpw.telegrambots.currencybot.commands.options;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.telegrambots.bot.commands.BotCommand;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;
import ua.dpw.telegrambots.currencybot.menus.ChoiceNumberSymbolMenu;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;
import ua.dpw.users.User;
import ua.dpw.users.UserService;

public class OptionsNumberSimbolsCommand extends BotCommand {

    public OptionsNumberSimbolsCommand() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {
        updateUserSymbolsAfterComma(userMessage);

        InlineKeyboardMarkup menu = new ChoiceNumberSymbolMenu().createMenu(userMessage);
        getTelegramService().sendMessage(userMessage.getChatId(),
            userMessage.getUser().getLanguage().get("HEADSIGN_COMMASYMBOLS"),
            menu);
    }

    private void updateUserSymbolsAfterComma(UserMessage userMessage) {
        if (UserMessage.isBlankCallback(userMessage)) {
            return;
        }
        UserService userService = new UserService();
        User user = userMessage.getUser();
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case NUMBERS_3:
                userService.updateUserSymbolsAfterComma(user, 3);
                break;
            case NUMBERS_4:
                userService.updateUserSymbolsAfterComma(user, 4);
                break;
            default:
                userService.updateUserSymbolsAfterComma(user, 2);
        }
    }
}
