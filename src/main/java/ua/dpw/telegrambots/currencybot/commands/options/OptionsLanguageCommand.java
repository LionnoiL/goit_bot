package ua.dpw.telegrambots.currencybot.commands.options;

import static ua.dpw.telegrambots.currencybot.commands.Commands.EN_BUTTON;
import static ua.dpw.telegrambots.currencybot.commands.Commands.PL_BUTTON;
import static ua.dpw.telegrambots.currencybot.commands.Commands.UA_BUTTON;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.language.LanguageSwitcher;
import ua.dpw.telegrambots.bot.commands.BotCommand;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
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

        UserService userService = new UserService();
        User user = userMessage.getUser();

        if (UA_BUTTON.toString().equals(userMessage.getCallBack())) {
            user.setLangCode("uk");
            user.setLanguage(LanguageSwitcher.setLanguageMap("uk"));
            userService.addUser(user);
            userMessage.setUser(user);
        }

        if (EN_BUTTON.toString().equals(userMessage.getCallBack())) {
            user.setLangCode("en");
            user.setLanguage(LanguageSwitcher.setLanguageMap("en"));
            userService.addUser(user);
            userMessage.setUser(user);
        }

        if (PL_BUTTON.toString().equals(userMessage.getCallBack())) {
            user.setLangCode("pl");
            user.setLanguage(LanguageSwitcher.setLanguageMap("pl"));
            userService.addUser(user);
            userMessage.setUser(user);
        }

        InlineKeyboardMarkup menu = new LanguageMenu().createMenu(userMessage);
        getTelegramService().sendMessage(userMessage.getChatId(),
            userMessage.getUser().getLanguage().get("OPTIONS_LANGUAGE"),
            menu);
    }
}
