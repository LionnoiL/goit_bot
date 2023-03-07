package org.example.telegrambots.currency.handlers;

import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.example.telegrambots.currency.commands.mainmenu.GetInfoCommand;
import org.example.telegrambots.currency.commands.mainmenu.MainMenuCommand;
import org.example.telegrambots.currency.commands.mainmenu.OptionsMenuCommand;
import org.example.telegrambots.currency.commands.options.OptionsNumberSimbolsCommand;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CurrencyBotMessageHandler {

  private CurrencyBotMessageHandler() {
  }

  public static void resolveMessage(Update update) {
    if (update.hasMessage() || update.hasCallbackQuery()) {
      UserMessage userMessage = UserMessage.fromTelegramUpdate(update);
      if (userMessage == null) {
        return;
      }

      if (Commands.MAIN_GET_INFO.toString().equals(userMessage.getCallBack())) {
        new GetInfoCommand().execute(userMessage);
      } else if (Commands.MAIN_OPTIONS.toString()
          .equals(userMessage.getCallBack())) {
        new OptionsMenuCommand().execute(userMessage);
      } else if (Commands.OPTIONS_NUMBER_SIMBOLS_AFTER_COMMA.toString()
          .equals(userMessage.getCallBack())) {
        new OptionsNumberSimbolsCommand().execute(userMessage);
      } else {
        new MainMenuCommand().execute(userMessage);
      }
    }
  }
}
