package org.example.notifications;

import org.example.users.User;
import java.util.*;

import static org.example.AppLauncher.APPLICATION_PROPERTIES;

public class Scheduler {
    public static void setTimeReceived() {


        Date initialDate = new Date();
        int initialTime = initialDate.getHours() + 1;

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, initialTime);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 1);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Date currentDate = new Date();
                int currentTime = currentDate.getHours();
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

    public static void sendUsersNotifications(int currentTime) {

        Map<Long, User> users = APPLICATION_PROPERTIES.getUsers();

        users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter( e -> e.getAlertTime() == currentTime)
                .forEach(el -> System.out.println(el.getUserId() + " " + currentTime)); //TODO викликати метод відправки повідомлення та передати йому el.getUserId()
    }
}
