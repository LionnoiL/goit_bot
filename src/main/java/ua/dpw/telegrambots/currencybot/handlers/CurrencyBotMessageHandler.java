package ua.dpw.telegrambots.currencybot.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;
import ua.dpw.telegrambots.currencybot.commands.mainmenu.GetInfoCommand;
import ua.dpw.telegrambots.currencybot.commands.mainmenu.HelpInfoCommand;
import ua.dpw.telegrambots.currencybot.commands.mainmenu.MainMenuCommand;
import ua.dpw.telegrambots.currencybot.commands.mainmenu.OptionsMenuCommand;
import ua.dpw.telegrambots.currencybot.commands.options.OptionsBankCommand;
import ua.dpw.telegrambots.currencybot.commands.options.OptionsCurrencyCommand;
import ua.dpw.telegrambots.currencybot.commands.options.OptionsLanguageCommand;
import ua.dpw.telegrambots.currencybot.commands.options.OptionsNotificationCommand;
import ua.dpw.telegrambots.currencybot.commands.options.OptionsNumberSimbolsCommand;
import ua.dpw.telegrambots.currencybot.commands.options.OptionsUserTimeCommand;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;
import ua.dpw.users.User;

public final class CurrencyBotMessageHandler {

    private static boolean isProcessed = false;

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
        isProcessed = false;
        processCallbackMainInfo(userMessage);
        processCallbackMainOptions(userMessage);
        processCallbackHelp(userMessage);
        processCallbackSymbolAfterComma(userMessage);
        processCallbackBank(userMessage);
        processCallbackCurrency(userMessage);
        processCallbackNotification(userMessage);
        processCallbackLanguage(userMessage);
        processCallbackTime(userMessage);

        if (!isProcessed) {
            new MainMenuCommand().execute(userMessage);
        }
    }

    private static void processCallbackMainInfo(UserMessage userMessage) {
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case MAIN_GET_INFO:
                new GetInfoCommand().execute(userMessage);
                isProcessed = true;
                break;
            default:
        }
    }

    private static void processCallbackMainOptions(UserMessage userMessage) {
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case MAIN_OPTIONS:
                new OptionsMenuCommand().execute(userMessage);
                isProcessed = true;
                break;
            default:
        }
    }

    private static void processCallbackHelp(UserMessage userMessage) {
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case HELP:
                new HelpInfoCommand().execute(userMessage);
                isProcessed = true;
                break;
            default:
        }
    }

    private static void processCallbackSymbolAfterComma(UserMessage userMessage) {
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case OPTIONS_NUMBER_SYMBOL_AFTER_COMMA, NUMBERS_2, NUMBERS_3, NUMBERS_4:
                new OptionsNumberSimbolsCommand().execute(userMessage);
                isProcessed = true;
                break;
            default:
        }
    }

    private static void processCallbackBank(UserMessage userMessage) {
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case OPTIONS_BANK, BANK_PRIVATBANK, BANK_MONOBANK, BANK_OSCHADBANK, BANK_NBU:
                new OptionsBankCommand().execute(userMessage);
                isProcessed = true;
                break;
            default:
        }
    }

    private static void processCallbackCurrency(UserMessage userMessage) {
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case OPTIONS_CURRENCY, CURRENCY_EUR, CURRENCY_USD, CURRENCY_BITCOIN, CURRENCY_ETHEREUM:
                new OptionsCurrencyCommand().execute(userMessage);
                isProcessed = true;
                break;
            default:
        }
    }

    private static void processCallbackNotification(UserMessage userMessage) {
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case OPTIONS_NOTIFICATIONS, ALERT_9, ALERT_10, ALERT_11, ALERT_12, ALERT_13, ALERT_14,
                ALERT_15, ALERT_16, ALERT_17, ALERT_18, ALERT_AFTER_CHANGE, ALERT_OFF:
                new OptionsNotificationCommand().execute(userMessage);
                isProcessed = true;
                break;
            default:
        }
    }

    private static void processCallbackLanguage(UserMessage userMessage) {
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case OPTIONS_LANGUAGE, EN_BUTTON, UA_BUTTON, PL_BUTTON:
                new OptionsLanguageCommand().execute(userMessage);
                isProcessed = true;
                break;
            default:
        }
    }

    private static void processCallbackTime(UserMessage userMessage) {
        switch (Commands.valueOf(userMessage.getCallBack())) {
            case OPTIONS_USERTIME, TIME_0, TIME_1, TIME_2, TIME_3, TIME_4, TIME_5, TIME_6, TIME_7,
                TIME_8, TIME_9, TIME_10, TIME_11, TIME_12, TIME_13, TIME_14, TIME_15, TIME_16,
                TIME_17, TIME_18, TIME_19, TIME_20, TIME_21, TIME_22, TIME_23:
                new OptionsUserTimeCommand().execute(userMessage);
                isProcessed = true;
                break;
            default:
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
                user.getTranslate("START_MESSAGE"));
            new MainMenuCommand().execute(userMessage);
            return true;
        }
        return false;
    }
}
