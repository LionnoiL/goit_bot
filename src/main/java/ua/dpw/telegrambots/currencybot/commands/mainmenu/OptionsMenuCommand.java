package ua.dpw.telegrambots.currencybot.commands.mainmenu;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.telegrambots.bot.commands.BotCommand;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.menus.OptionsMenu;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;

public class OptionsMenuCommand extends BotCommand {

    public OptionsMenuCommand() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {

        InlineKeyboardMarkup optionsMenu = new OptionsMenu().createMenu(userMessage);
        getTelegramService().sendMessage(userMessage.getChatId(),
            userMessage.getUser().getLanguage().get("HEADSIGN_OPTIONS"),
            optionsMenu);
    }
}
