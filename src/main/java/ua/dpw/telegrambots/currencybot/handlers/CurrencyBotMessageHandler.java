package ua.dpw.telegrambots.currencybot.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;
import ua.dpw.telegrambots.currencybot.commands.mainmenu.GetInfoCommand;
import ua.dpw.telegrambots.currencybot.commands.mainmenu.MainMenuCommand;
import ua.dpw.telegrambots.currencybot.commands.mainmenu.OptionsMenuCommand;
import ua.dpw.telegrambots.currencybot.commands.options.OptionsBankCommand;
import ua.dpw.telegrambots.currencybot.commands.options.OptionsCurrencyCommand;
import ua.dpw.telegrambots.currencybot.commands.options.OptionsLanguageCommand;
import ua.dpw.telegrambots.currencybot.commands.options.OptionsNotificationCommand;
import ua.dpw.telegrambots.currencybot.commands.options.OptionsNumberSimbolsCommand;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;
import ua.dpw.users.User;

public class CurrencyBotMessageHandler {

    private CurrencyBotMessageHandler() {
    }

    public static void resolveMessage(Update update) {
        if (update.hasMessage() || update.hasCallbackQuery()) {
            UserMessage userMessage = UserMessage.fromTelegramUpdate(update);
            if (userMessage == null) {
                return;
            }

            User user = userMessage.getUser();
            if (user.isNewUser()) {
                user.setNewUser(false);
                TelegramService telegramService = new TelegramService(new CurrencySender());
                telegramService.sendMessage(user.getUserId(),
                    user.getLanguage().get("START_MESSAGE"));
                new MainMenuCommand().execute(userMessage);
                return;
            }

            String callBack = userMessage.getCallBack();
            if (callBack == null) {
                new MainMenuCommand().execute(userMessage);
                return;
            }

            Commands userCallBack = Commands.valueOf(callBack);
            switch (userCallBack) {
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
                case OPTIONS_LANGUAGE:
                case EN_BUTTON:
                case UA_BUTTON:
                case PL_BUTTON:
                    new OptionsLanguageCommand().execute(userMessage);
                    break;
                default:
                    new GetInfoCommand().execute(userMessage);
                    break;
            }
        }
    }
}
