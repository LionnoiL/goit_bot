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

    public OptionsUserTimeCommand() {super (new TelegramService(new CurrencySender()));
    }

    @Override
    public void execute(UserMessage userMessage) {
        User user = userMessage.getUser();
        UserService userService = new UserService();
        Commands userCallBack = Commands.valueOf(userMessage.getCallBack());

        switch (userCallBack) {
            case TIME_0:
                userService.updateUser(user, 200);
                break;
            case TIME_1:
                userService.updateUser(user, 201);
                break;
            case TIME_2:
                userService.updateUser(user, 202);
                break;
            case TIME_3:
                userService.updateUser(user,203);
                break;
            case TIME_4:
                userService.updateUser(user, 204);
                break;
            case TIME_5:
                userService.updateUser(user, 205);
                break;
            case TIME_6:
                userService.updateUser(user, 206);
                break;
            case TIME_7:
                userService.updateUser(user, 207);
                break;
            case TIME_8:
                userService.updateUser(user, 208);
                break;
            case TIME_9:
                userService.updateUser(user, 209);
                break;
            case TIME_10:
                userService.updateUser(user, 210);
                break;
            case TIME_11:
                userService.updateUser(user, 211);
                break;
            case TIME_12:
                userService.updateUser(user, 212);
                break;
            case TIME_13:
                userService.updateUser(user, 213);
                break;
            case TIME_14:
                userService.updateUser(user, 214);
                break;
            case TIME_15:
                userService.updateUser(user, 215);
                break;
            case TIME_16:
                userService.updateUser(user, 216);
                break;
            case TIME_17:
                userService.updateUser(user, 217);
                break;
            case TIME_18:
                userService.updateUser(user, 218);
                break;
            case TIME_19:
                userService.updateUser(user, 219);
                break;
            case TIME_20:
                userService.updateUser(user, 220);
                break;
            case TIME_21:
                userService.updateUser(user, 221);
                break;
            case TIME_22:
                userService.updateUser(user, 222);
                break;
            case TIME_23:
                userService.updateUser(user, 223);
                break;
            default:
                break;
        }
        InlineKeyboardMarkup notificationMenu = new UserTimeMenu().createMenu(userMessage);
        getTelegramService().sendMessage(userMessage.getChatId(),
                userMessage.getUser().getLanguage().get("HEADSIGN_USERTIME"),
                notificationMenu);
    }
}