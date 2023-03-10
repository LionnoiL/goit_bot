package org.example.notifications;

import org.example.users.User;

import java.time.LocalDateTime;
import java.util.*;

import static org.example.AppLauncher.APPLICATION_PROPERTIES;

public class Scheduler {
    public static void setTimeReceived() {

        int initialTime = getCurrentTime() + 1;

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, initialTime);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 1);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                int currentTime = getCurrentTime();
                sendUsersNotifications(currentTime);
            }
        };

        Timer timer = new Timer();
        timer.schedule(
                timerTask,
                calendar.getTime(),
                3600000
        );
    }

    private static int getCurrentTime(){
        
        return LocalDateTime.now().getHour();
    }

    private static void sendUsersNotifications(int currentTime) {

        Map<Long, User> users = APPLICATION_PROPERTIES.getUsers();

        users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(el -> el.getAlertTime() == currentTime)
                .forEach(el -> System.out.println(el.getUserId() + " " + currentTime)); //TODO викликати метод відправки повідомлення та передати йому el.getUserId()
    }
}
