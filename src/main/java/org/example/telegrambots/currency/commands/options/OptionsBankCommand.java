package org.example.telegrambots.currency.commands.options;

import org.example.currency.bank.Bank;
import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.example.telegrambots.currency.menus.BankMenu;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.example.users.User;
import org.example.users.UserService;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import static org.example.telegrambots.currency.commands.Commands.*;

public class OptionsBankCommand extends BotCommand {
    public OptionsBankCommand() { super(new TelegramService(new CurrencySender()));}

    @Override
    public void execute(UserMessage userMessage) {
        if (BANK_PRIVATBANK.toString().equals(userMessage.getCallBack())) {
            User user = userMessage.getUser();
            UserService userService = new UserService();
            userService.updateUser(user, Bank.PRIVATBANK);
        } else if (BANK_MONOBANK.toString().equals(userMessage.getCallBack())) {
                User user = userMessage.getUser();
                UserService userService = new UserService();
                userService.updateUser(user, Bank.MONOBANK);
        } else if (BANK_NBU.toString().equals(userMessage.getCallBack())) {
                User user = userMessage.getUser();
                UserService userService = new UserService();
                userService.updateUser(user, Bank.NBU);
        } else if (BANK_OSCHADBANK.toString().equals(userMessage.getCallBack())) {
            User user = userMessage.getUser();
            UserService userService = new UserService();
            userService.updateUser(user, Bank.OSCHADBANK);
        }

        InlineKeyboardMarkup menu = new BankMenu().createMenu(userMessage);

        getTelegramService().sendMessage(userMessage.getChatId(), Commands.HEADSIGN_BANKSMENU.getButtonText(),
                menu);
    }
}
