package org.example.telegrambots.currency.commands.options;

import static org.example.telegrambots.currency.commands.Commands.NUMBERS_2;
import static org.example.telegrambots.currency.commands.Commands.NUMBERS_3;
import static org.example.telegrambots.currency.commands.Commands.NUMBERS_4;

import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.example.telegrambots.currency.menus.ChoiceNumberSymbolMenu;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.example.users.UserService;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class OptionsNumberSimbolsCommand extends BotCommand {

    public OptionsNumberSimbolsCommand() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {
        UserService userService = new UserService();
        if (NUMBERS_2.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(userMessage.getUser(), 2);
        } else if (NUMBERS_3.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(userMessage.getUser(), 3);
        } else if (NUMBERS_4.toString().equals(userMessage.getCallBack())) {
            userService.updateUser(userMessage.getUser(), 4);
        }

        InlineKeyboardMarkup menu = new ChoiceNumberSymbolMenu().createMenu(userMessage);

        getTelegramService().sendMessage(userMessage.getChatId(),
            Commands.HEADSIGN_COMMASYMBOLS.getButtonText(userMessage),
            menu);
    }
}
