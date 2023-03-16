package ua.dpw.notifications;

import static ua.dpw.AppLauncher.APPLICATION_PROPERTIES;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.currency.services.CurrencyRateCollector;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.menus.MainMenu;
import ua.dpw.telegrambots.currencybot.messages.MessageService;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;
import ua.dpw.users.User;
import ua.dpw.users.UserService;

public class Scheduler {

    private Scheduler() {
        throw new IllegalStateException("Scheduler is utility class");
    }

    public static void setTimeReceived() {
        CurrencyRateCollector currencyRateCollector = new CurrencyRateCollector();
        currencyRateCollector.collectAllRates();
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
                currencyRateCollector.collectAllRates();
            }
        };

        Timer timer = new Timer();
        timer.schedule(
                timerTask,
                calendar.getTime(),
                3600000
        );
    }

    public static int getCurrentHour() {
        return LocalDateTime.now().getHour();
    }

    private static void sendUsersNotifications(int currentHour) {
        Map<Long, User> users = APPLICATION_PROPERTIES.getUsers();
        TelegramService telegramService = new TelegramService(new CurrencySender());
        UserService userService = new UserService();
        users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(el -> el.getAlertTime() == currentHour + el.getDeltaHours())
                .forEach(el -> {
                    telegramService.sendMessage(el.getUserId(),
                            MessageService.getInformationMessageByUser(el));

                    User user = userService.getUserById(el.getUserId());
                    UserMessage userMessage = new UserMessage();
                    userMessage.setUser(user);
                    InlineKeyboardMarkup mainMenu = new MainMenu().createMenu(userMessage);
                    telegramService.sendMessage(el.getUserId(),
                            user.getLanguage().get("HEADSIGN_MAINMENU"),
                            mainMenu);
                });
    }
}
