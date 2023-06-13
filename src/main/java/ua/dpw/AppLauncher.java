package ua.dpw;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ua.dpw.notifications.Scheduler;
import ua.dpw.properties.ApplicationProperties;
import ua.dpw.telegrambots.currencybot.CurrencyBot;
import ua.dpw.utils.LoggingConfiguration;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppLauncher {

    public static final ApplicationProperties APPLICATION_PROPERTIES = new ApplicationProperties();

    public static void main(String[] args) {
        new LoggingConfiguration().setup();

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new CurrencyBot());
        } catch (TelegramApiException e) {
            log.error("Error register bots");
        }
        Scheduler.setTimeReceived();
    }
}
