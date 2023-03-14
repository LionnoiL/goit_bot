package ua.dpw;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ua.dpw.notifications.Scheduler;
import ua.dpw.properties.ApplicationProperties;
import ua.dpw.telegrambots.currencybot.CurrencyBot;

public class AppLauncher {

    public static final ApplicationProperties APPLICATION_PROPERTIES = new ApplicationProperties();
    private static final Logger LOG = LogManager.getLogger(AppLauncher.class);

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new CurrencyBot());
        } catch (TelegramApiException e) {
            LOG.warn("Error register bots");
        }
        Scheduler.setTimeReceived();
    }
}