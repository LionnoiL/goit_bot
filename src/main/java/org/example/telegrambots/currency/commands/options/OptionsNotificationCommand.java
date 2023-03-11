package org.example.telegrambots.currency.commands.options;

import org.example.currency.bank.Bank;
import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.example.telegrambots.currency.menus.NotificationMenu;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.example.users.User;
import org.example.users.UserService;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import static org.example.telegrambots.currency.commands.Commands.NUMBERS_2;

public class OptionsNotificationCommand extends BotCommand {
    public OptionsNotificationCommand() {super (new TelegramService(new CurrencySender()));}

    @Override
    public void execute(UserMessage userMessage) {
            User user = userMessage.getUser();
            UserService userService = new UserService();
        Commands userCallBack = Commands.valueOf(userMessage.getCallBack());

        switch (userCallBack) {
            case ALERT_10: userService.updateUser(user, 10); break;
            case ALERT_11: userService.updateUser(user, 11); break;
            case ALERT_12: userService.updateUser(user, 12); break;
            case ALERT_13: userService.updateUser(user, 13); break;
            case ALERT_14: userService.updateUser(user, 14); break;
            case ALERT_15: userService.updateUser(user, 15); break;
            case ALERT_16: userService.updateUser(user, 16); break;
            case ALERT_17: userService.updateUser(user, 17); break;
            case ALERT_18: userService.updateUser(user, 18); break;
            case ALERT_OFF: userService.updateUser(user, 100); break;
            default: userService.updateUser(user, 9); break;
        }
        InlineKeyboardMarkup notificationMenu = new NotificationMenu().createMenu(userMessage);

        getTelegramService().sendMessage(userMessage.getChatId(), Commands.HEADSIGN_NOTIFICATIONTIME.getButtonText(),
                notificationMenu);
    }
}
