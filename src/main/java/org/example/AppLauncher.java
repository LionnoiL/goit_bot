package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.notifications.Scheduler;
import org.example.properties.ApplicationProperties;
import org.example.telegrambots.currency.CurrencyBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class AppLauncher {

    public static final ApplicationProperties APPLICATION_PROPERTIES = new ApplicationProperties();
    private static final Logger LOG = LogManager.getLogger(AppLauncher.class);

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new CurrencyBot());
            //botsApi.registerBot(new WeatherBot());
        } catch (TelegramApiException e) {
            LOG.warn("Error register bots");
        }
        Scheduler.setTimeReceived();
    }
}