package ua.dpw.telegrambots.currencybot.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;
import ua.dpw.telegrambots.currencybot.commands.mainmenu.GetInfoCommand;
import ua.dpw.telegrambots.currencybot.commands.mainmenu.GetInfoCrypto;
import ua.dpw.telegrambots.currencybot.commands.mainmenu.MainMenuCommand;
import ua.dpw.telegrambots.currencybot.commands.mainmenu.OptionsMenuCommand;
import ua.dpw.telegrambots.currencybot.commands.options.*;
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

            if (processNewUser(userMessage)) {
                return;
            }

            if (processNoCallback(userMessage)) {
                return;
            }

            processCallback(userMessage);
        }
    }

    private static void processCallback(UserMessage userMessage) {
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case MAIN_OPTIONS:
                new OptionsMenuCommand().execute(userMessage);
                break;
            case OPTIONS_NUMBER_SYMBOL_AFTER_COMMA:
            case NUMBERS_2:
            case NUMBERS_3:
            case NUMBERS_4:
                new OptionsNumberSimbolsCommand().execute(userMessage);
                break;
            case CURRYNCY_CRYPTO:
                new GetInfoCrypto().execute(userMessage);;
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
            case OPTIONS_USERTIME:
            case TIME_0:
            case TIME_1:
            case TIME_2:
            case TIME_3:
            case TIME_4:
            case TIME_5:
            case TIME_6:
            case TIME_7:
            case TIME_8:
            case TIME_9:
            case TIME_10:
            case TIME_11:
            case TIME_12:
            case TIME_13:
            case TIME_14:
            case TIME_15:
            case TIME_16:
            case TIME_17:
            case TIME_18:
            case TIME_19:
            case TIME_20:
            case TIME_21:
            case TIME_22:
            case TIME_23:
                new OptionsUserTimeCommand().execute(userMessage);
                break;
            default:
                new GetInfoCommand().execute(userMessage);
                break;
        }
    }

    private static boolean processNoCallback(UserMessage userMessage) {
        if (userMessage == null) {
            return true;
        }
        String callBack = userMessage.getCallBack();
        if (callBack == null) {
            new MainMenuCommand().execute(userMessage);
            return true;
        }
        return false;
    }

    private static boolean processNewUser(UserMessage userMessage) {
        if (userMessage == null || userMessage.getUser() == null) {
            return true;
        }
        User user = userMessage.getUser();
        if (user.isNewUser()) {
            user.setNewUser(false);
            TelegramService telegramService = new TelegramService(new CurrencySender());
            telegramService.sendMessage(user.getUserId(),
                user.getLanguage().get("START_MESSAGE"));
            new MainMenuCommand().execute(userMessage);
            return true;
        }
        return false;
    }
}
