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
        UserService userService = new UserService();
        User user = userMessage.getUser();

        if (Commands.NUMBERS_2.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(user, 2);
        } else if (Commands.NUMBERS_3.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(user, 3);
        } else if (Commands.NUMBERS_4.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(user, 4);
        }

        InlineKeyboardMarkup menu = new ChoiceNumberSymbolMenu().createMenu(userMessage);
        getTelegramService().sendMessage(userMessage.getChatId(),
            userMessage.getUser().getLanguage().get("HEADSIGN_COMMASYMBOLS"),
            menu);
    }
}
