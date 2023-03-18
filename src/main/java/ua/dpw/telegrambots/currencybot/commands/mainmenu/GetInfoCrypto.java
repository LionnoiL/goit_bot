package ua.dpw.telegrambots.currencybot.commands.mainmenu;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.currency.services.CurrencyRateCryptoService;
import ua.dpw.telegrambots.bot.commands.BotCommand;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.menus.MainMenu;
import ua.dpw.telegrambots.currencybot.messages.MessageService;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;

public class GetInfoCrypto extends BotCommand {

    public GetInfoCrypto() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {
        getTelegramService().sendMessage(userMessage.getChatId(),
                new CurrencyRateCryptoService().cryptoInfo());

        InlineKeyboardMarkup mainMenu = new MainMenu().createMenu(userMessage);
        getTelegramService().sendMessage(userMessage.getChatId(),
                userMessage.getUser().getLanguage().get("HEADSIGN_MAINMENU"),
                mainMenu);
    }
}
