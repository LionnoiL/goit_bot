package org.example.telegrambots.bot.services;

import lombok.Getter;
import lombok.Setter;
import org.example.language.LanguageSwitcher;
import org.example.telegrambots.currency.CurrencyBot;
import org.example.users.User;
import org.example.users.UserService;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
@Setter
public class UserMessage {

  private Long chatId;
  private String userFirstName;
  private String textFromUser;
  private String callBack;
  private User user;

  public static UserMessage fromTelegramUpdate(Update update){
    UserService userService = new UserService();
    Message message;
    if (update.hasMessage()) {
      message = update.getMessage();
    } else if (update.hasCallbackQuery()) {
      message = update.getCallbackQuery().getMessage();
    } else {
      CurrencyBot.LOG.info("Unexpected update from user");
      return null;
    }

    UserMessage userMessage =  new UserMessage();
    userMessage.setChatId(message.getChatId());
    userMessage.setUserFirstName(message.getFrom().getFirstName());

    if (message.hasText()) {
      userMessage.setTextFromUser(message.getText());
    }

    if (update.hasCallbackQuery()) {
      userMessage.setCallBack(update.getCallbackQuery().getData());
    }

    Long userId = message.getChatId();
    User user = userService.getUserById(userId);
    String langCode = message.getFrom().getLanguageCode();
    if (langCode == null) {
      langCode = "en";
    }
    if (user==null){
      user = userService.createUser(userId, message.getChat().getFirstName(), message.getChat().getLastName(),
              langCode.toLowerCase(), LanguageSwitcher.setLanguageMap(langCode));
      userService.addUser(user);
    }

    userMessage.setUser(user);

    CurrencyBot.LOG.info(
        "[" + userMessage.getChatId() + ", " + userMessage.getUserFirstName() + "] : "
            + userMessage.getTextFromUser() + ", callback[" + userMessage.getCallBack()
            + "]");


    return userMessage;
  }
}
