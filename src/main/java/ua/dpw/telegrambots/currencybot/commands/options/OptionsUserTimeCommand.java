package ua.dpw.telegrambots.currencybot.commands.options;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.telegrambots.bot.commands.BotCommand;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;
import ua.dpw.telegrambots.currencybot.menus.UserTimeMenu;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;
import ua.dpw.users.User;
import ua.dpw.users.UserService;

public class OptionsUserTimeCommand extends BotCommand {

    public OptionsUserTimeCommand() {
        super(new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {
        updateUserDeltaTime(userMessage);

        InlineKeyboardMarkup notificationMenu = new UserTimeMenu().createMenu(userMessage);
        getTelegramService().sendEditedMenu(userMessage.getChatId(), userMessage.getMessageId(),
            userMessage.getUser().getTranslate("HEADSIGN_USERTIME"),
            notificationMenu);
    }

    private void updateUserDeltaTime(UserMessage userMessage) {
        if (UserMessage.isBlankCallback(userMessage)) {
            return;
        }
        UserService userService = new UserService();
        User user = userMessage.getUser();

        switch (Commands.valueOf(userMessage.getCallBack())) {
            case TIME_0:
                userService.updateUserTime(user, 0);
                break;
            case TIME_1:
                userService.updateUserTime(user, 1);
                break;
            case TIME_2:
                userService.updateUserTime(user, 2);
                break;
            case TIME_3:
                userService.updateUserTime(user, 3);
                break;
            case TIME_4:
                userService.updateUserTime(user, 4);
                break;
            case TIME_5:
                userService.updateUserTime(user, 5);
                break;
            case TIME_6:
                userService.updateUserTime(user, 6);
                break;
            case TIME_7:
                userService.updateUserTime(user, 7);
                break;
            case TIME_8:
                userService.updateUserTime(user, 8);
                break;
            case TIME_9:
                userService.updateUserTime(user, 9);
                break;
            case TIME_10:
                userService.updateUserTime(user, 10);
                break;
            case TIME_11:
                userService.updateUserTime(user, 11);
                break;
            case TIME_12:
                userService.updateUserTime(user, 12);
                break;
            case TIME_13:
                userService.updateUserTime(user, 13);
                break;
            case TIME_14:
                userService.updateUserTime(user, 14);
                break;
            case TIME_15:
                userService.updateUserTime(user, 15);
                break;
            case TIME_16:
                userService.updateUserTime(user, 16);
                break;
            case TIME_17:
                userService.updateUserTime(user, 17);
                break;
            case TIME_18:
                userService.updateUserTime(user, 18);
                break;
            case TIME_19:
                userService.updateUserTime(user, 19);
                break;
            case TIME_20:
                userService.updateUserTime(user, 20);
                break;
            case TIME_21:
                userService.updateUserTime(user, 21);
                break;
            case TIME_22:
                userService.updateUserTime(user, 22);
                break;
            case TIME_23:
                userService.updateUserTime(user, 23);
                break;
            default:
                break;
        }
    }
}
