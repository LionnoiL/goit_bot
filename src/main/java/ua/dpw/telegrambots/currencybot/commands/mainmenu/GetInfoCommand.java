package ua.dpw.telegrambots.currencybot.commands.mainmenu;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.telegrambots.bot.commands.BotCommand;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.menus.MainMenu;
import ua.dpw.telegrambots.currencybot.messages.MessageService;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;


public class GetInfoCommand extends BotCommand {

    public GetInfoCommand() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {
        sendRatesInfo(userMessage);
        sendMainMenu(userMessage);
    }

    private void sendMainMenu(UserMessage userMessage) {
        InlineKeyboardMarkup mainMenu = new MainMenu().createMenu(userMessage);
        getTelegramService().sendMessage(userMessage.getChatId(),
            userMessage.getUser().getTranslate("HEADSIGN_MAINMENU"),
            mainMenu);
    }

    private void sendRatesInfo(UserMessage userMessage) {
        getTelegramService().sendMessage(userMessage.getChatId(),
            MessageService.getInformationMessageByUser(userMessage.getUser(), false));
    }
}
