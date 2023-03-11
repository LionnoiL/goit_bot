package org.example.notifications;

import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.currency.messages.MessageService;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.example.users.User;

import java.time.LocalDateTime;
import java.util.*;

import static org.example.AppLauncher.APPLICATION_PROPERTIES;

public class Scheduler {
    public static void setTimeReceived() {

        int initialHour = getCurrentHour() + 1;

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, initialHour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 1);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                int currentHour = getCurrentHour();
                sendUsersNotifications(currentHour);
            }
        };

        Timer timer = new Timer();
        timer.schedule(
                timerTask,
                calendar.getTime(),
                3600000
        );
    }

    private static int getCurrentHour() {

        return LocalDateTime.now().getHour();
    }

    private static void sendUsersNotifications(int currentHour) {

        Map<Long, User> users = APPLICATION_PROPERTIES.getUsers();
        TelegramService telegramService = new TelegramService(new CurrencySender());

        users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(el -> el.getAlertTime() == currentHour)
                .forEach(el -> telegramService.sendMessage(el.getUserId(), MessageService.getInformationMessageByUserId(el.getUserId())));
    }
}
