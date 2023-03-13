package org.example.telegrambots.currency.commands.options;

import static org.example.telegrambots.currency.commands.Commands.EN_BUTTON;
import static org.example.telegrambots.currency.commands.Commands.UA_BUTTON;

import org.example.language.LanguageSwitcher;
import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.menus.LanguageMenu;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.example.users.User;
import org.example.users.UserService;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class OptionsLanguageCommand extends BotCommand {

    public OptionsLanguageCommand() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {

        UserService userService = new UserService();

        if (UA_BUTTON.toString().equals(userMessage.getCallBack())) {
            User user = userMessage.getUser();
            user.setLangCode("uk");
            user.setLanguage(LanguageSwitcher.setLanguageMap("uk"));
            userService.addUser(user);
            userMessage.setUser(user);
        }

        if (EN_BUTTON.toString().equals(userMessage.getCallBack())) {
            User user = userMessage.getUser();
            user.setLangCode("en");
            user.setLanguage(LanguageSwitcher.setLanguageMap("en"));
            userService.addUser(user);
            userMessage.setUser(user);
        }

        InlineKeyboardMarkup menu = new LanguageMenu().createMenu(userMessage);
        getTelegramService().sendMessage(userMessage.getChatId(),
            userMessage.getUser().getLanguage().get("OPTIONS_LANGUAGE"),
            menu);
    }
}
