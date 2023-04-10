package ua.dpw.telegrambots.bot.services;

import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ua.dpw.telegrambots.currencybot.CurrencyBot;
import ua.dpw.users.User;
import ua.dpw.users.UserService;

@Getter
@Setter
public class UserMessage {

    private Long chatId;
    private int messageId;
    private String userFirstName;
    private String textFromUser;
    private String callBack;
    private User user;

    public static boolean isBlankCallback(UserMessage userMessage) {
        return (userMessage == null || userMessage.getCallBack().isBlank());
    }

    public static UserMessage fromTelegramUpdate(Update update) {
        Message message = getMessageFromUpdate(update);
        if (message == null) {
            return null;
        }

        UserMessage userMessage = getUserMessageFromMessage(message);
        addCallBackToUserMessage(userMessage, update);
        addUserToUserMessage(userMessage, message);

        CurrencyBot.LOG.info(
            "[" + userMessage.getChatId() + ", " + userMessage.getUserFirstName() + "] : "
                + userMessage.getTextFromUser() + ", callback[" + userMessage.getCallBack()
                + "]");
        return userMessage;
    }

    private static Message getMessageFromUpdate(Update update) {
        if (update.hasMessage()) {
            return update.getMessage();
        } else if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getMessage();
        } else {
            CurrencyBot.LOG.info("Unexpected update from user");
            return null;
        }
    }

    private static UserMessage getUserMessageFromMessage(Message message) {
        UserMessage userMessage = new UserMessage();
        userMessage.setChatId(message.getChatId());
        userMessage.setUserFirstName(message.getFrom().getFirstName());
        if (message.hasText()) {
            userMessage.setTextFromUser(message.getText());
        }
        return userMessage;
    }

    private static void addCallBackToUserMessage(UserMessage userMessage, Update update) {
        if (update.hasCallbackQuery()) {
            userMessage.setCallBack(update.getCallbackQuery().getData());
            userMessage.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        }
    }

    private static void addUserToUserMessage(UserMessage userMessage, Message message) {
        UserService userService = new UserService();
        Long userId = message.getChatId();
        String langCode = message.getFrom().getLanguageCode();

        User user = userService.getUserById(userId);
        if (user == null) {
            user = userService.createUserWithDefaultProperties(userId, message.getChat().getFirstName(),
                message.getChat().getLastName(),
                langCode);
            user.setNewUser(true);
            userService.addUser(user);
        } else {
            if (langCode != null) {
                if (!user.getLangCode().equals(langCode)) {
                    user.setLangCode(langCode);
                    userService.update(user);
                }
            }
        }
        userMessage.setUser(user);
    }
}
