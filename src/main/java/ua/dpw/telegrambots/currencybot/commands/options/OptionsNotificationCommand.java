package ua.dpw.telegrambots.currencybot.commands.options;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.telegrambots.bot.commands.BotCommand;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;
import ua.dpw.telegrambots.currencybot.menus.NotificationMenu;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;
import ua.dpw.users.User;
import ua.dpw.users.UserService;

public class OptionsNotificationCommand extends BotCommand {

    public OptionsNotificationCommand() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {
        User user = userMessage.getUser();
        UserService userService = new UserService();
        Commands userCallBack = Commands.valueOf(userMessage.getCallBack());

        switch (userCallBack) {
            case ALERT_9:
                userService.updateUser(user, 9);
                break;
            case ALERT_10:
                userService.updateUser(user, 10);
                break;
            case ALERT_11:
                userService.updateUser(user, 11);
                break;
            case ALERT_12:
                userService.updateUser(user, 12);
                break;
            case ALERT_13:
                userService.updateUser(user, 13);
                break;
            case ALERT_14:
                userService.updateUser(user, 14);
                break;
            case ALERT_15:
                userService.updateUser(user, 15);
                break;
            case ALERT_16:
                userService.updateUser(user, 16);
                break;
            case ALERT_17:
                userService.updateUser(user, 17);
                break;
            case ALERT_18:
                userService.updateUser(user, 18);
                break;
            case ALERT_OFF:
                userService.updateUser(user, 100);
                break;
            default:
                break;
        }
        InlineKeyboardMarkup notificationMenu = new NotificationMenu().createMenu(userMessage);
        getTelegramService().sendMessage(userMessage.getChatId(),
            userMessage.getUser().getLanguage().get("HEADSIGN_NOTIFICATIONTIME"),
            notificationMenu);
    }
}
