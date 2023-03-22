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
        updateUserNotificationsTime(userMessage);

        InlineKeyboardMarkup notificationMenu = new NotificationMenu().createMenu(userMessage);
        getTelegramService().sendEditedMenu(userMessage.getChatId(), userMessage.getMessageId(),
            userMessage.getUser().getLanguage().get("HEADSIGN_NOTIFICATIONTIME"),
            notificationMenu);
    }

    private void updateUserNotificationsTime(UserMessage userMessage) {
        if (UserMessage.isBlankCallback(userMessage)) {
            return;
        }
        UserService userService = new UserService();
        User user = userMessage.getUser();

        switch (Commands.valueOf(userMessage.getCallBack())) {
            case ALERT_9:
                userService.updateUserAlertTime(user, 9);
                break;
            case ALERT_10:
                userService.updateUserAlertTime(user, 10);
                break;
            case ALERT_11:
                userService.updateUserAlertTime(user, 11);
                break;
            case ALERT_12:
                userService.updateUserAlertTime(user, 12);
                break;
            case ALERT_13:
                userService.updateUserAlertTime(user, 13);
                break;
            case ALERT_14:
                userService.updateUserAlertTime(user, 14);
                break;
            case ALERT_15:
                userService.updateUserAlertTime(user, 15);
                break;
            case ALERT_16:
                userService.updateUserAlertTime(user, 16);
                break;
            case ALERT_17:
                userService.updateUserAlertTime(user, 17);
                break;
            case ALERT_18:
                userService.updateUserAlertTime(user, 18);
                break;
            case ALERT_OFF:
                userService.updateUserAlertTime(user, 100);
                break;
            default:
                break;
        }
    }
}
