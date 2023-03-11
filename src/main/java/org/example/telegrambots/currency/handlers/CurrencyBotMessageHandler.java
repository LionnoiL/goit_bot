package org.example.telegrambots.currency.handlers;

import org.example.language.LanguageSwitcher;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.example.telegrambots.currency.commands.mainmenu.GetInfoCommand;
import org.example.telegrambots.currency.commands.mainmenu.MainMenuCommand;
import org.example.telegrambots.currency.commands.mainmenu.OptionsMenuCommand;
import org.example.telegrambots.currency.commands.options.OptionsBankCommand;
import org.example.telegrambots.currency.commands.options.OptionsCurrencyCommand;
import org.example.telegrambots.currency.commands.options.OptionsNotificationCommand;
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
      String callBack = userMessage.getCallBack();
      if(callBack==null){
        new MainMenuCommand().execute(userMessage);
        return;
      }
      Commands userCallBack = Commands.valueOf(callBack);

      switch(userCallBack) {
        case MAIN_OPTIONS:
          new OptionsMenuCommand().execute(userMessage);
        break;
        case OPTIONS_NUMBER_SYMBOL_AFTER_COMMA:
        case NUMBERS_2:
        case NUMBERS_3:
        case NUMBERS_4:
          new OptionsNumberSimbolsCommand().execute(userMessage);
        break;
        case OPTIONS_BANK:
        case BANK_PRIVATBANK:
        case BANK_MONOBANK:
        case BANK_OSCHADBANK:
        case BANK_NBU:
          new OptionsBankCommand().execute(userMessage);
        break;
        case OPTIONS_CURRENCY:
        case CURRENCY_EUR:
        case CURRENCY_USD:
          new OptionsCurrencyCommand().execute(userMessage);
        break;
        case OPTIONS_NOTIFICATIONS:
        case ALERT_9:
        case ALERT_10:
        case ALERT_11:
        case ALERT_12:
        case ALERT_13:
        case ALERT_14:
        case ALERT_15:
        case ALERT_16:
        case ALERT_17:
        case ALERT_18:
        case ALERT_OFF:
          new OptionsNotificationCommand().execute(userMessage);
          break;
        default:
          new GetInfoCommand().execute(userMessage);
          break;
        }
      }
    }
  }
