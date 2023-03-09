package org.example.notifications;

import com.google.gson.*;

import java.io.File;
import java.util.*;

public class Scheduler {

    private static final File RESOURCES_PATH = new File("src/main/resources/");
    private static final File FILE_NAME = new File(RESOURCES_PATH, "users.json");
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

        String json = jsonReader(FILE_NAME).toLowerCase();

        new JsonParser().parse(json).getAsJsonArray().asList().stream()
                .filter(el -> el.getAsJsonObject().get("alerttime").getAsInt() == currentTime)
                .map(el -> el.getAsJsonObject().get("userid").getAsLong())
                .forEach(el -> System.out.println(el + " " + currentTime)); //TODO відправити повідомлення

    }

    public static String jsonReader(File file) {

        StringJoiner result = new StringJoiner("\n");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result.toString();
    }
}
