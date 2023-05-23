package ua.dpw.telegrambots.currencybot.commands.options;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.telegrambots.bot.commands.BotCommand;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;
import ua.dpw.telegrambots.currencybot.menus.LanguageMenu;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;
import ua.dpw.users.User;
import ua.dpw.users.UserService;

public class OptionsLanguageCommand extends BotCommand {

    public OptionsLanguageCommand() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {
        updateUserLanguage(userMessage);

        InlineKeyboardMarkup menu = new LanguageMenu().createMenu(userMessage);
        getTelegramService().sendEditedMenu(userMessage.getChatId(), userMessage.getMessageId(),
            userMessage.getUser().getTranslate("OPTIONS_LANGUAGE"),
            menu);
    }

    private void updateUserLanguage(UserMessage userMessage) {
        if (UserMessage.isBlankCallback(userMessage)) {
            return;
        }
        UserService userService = new UserService();
        User user = userMessage.getUser();

        switch (Commands.valueOf(userMessage.getCallBack())) {
            case UA_BUTTON:
                user.setLangCode("uk");
                break;
            case EN_BUTTON:
                user.setLangCode("en");
                break;
            case PL_BUTTON:
                user.setLangCode("pl");
                break;
            default:
        }
        userService.update(user);
        userMessage.setUser(user);
    }
}
