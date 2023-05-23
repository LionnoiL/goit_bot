package ua.dpw.notifications;

import static ua.dpw.database.Service.USER_SERVICE;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ua.dpw.currency.services.CurrencyRateCollector;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.menus.MainMenu;
import ua.dpw.telegrambots.currencybot.messages.MessageService;
import ua.dpw.telegrambots.currencybot.sender.CurrencySender;
import ua.dpw.users.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Scheduler {

    public static void setTimeReceived() {
        CurrencyRateCollector currencyRateCollector = new CurrencyRateCollector();
        currencyRateCollector.collectAllRates();
        int initialHour = getCurrentHour() + 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, initialHour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 1);

        TimerTask timerTaskSendNotification = new TimerTask() {
            @Override
            public void run() {
                sendUsersNotifications();
            }
        };

        TimerTask timerTaskRateCollect = new TimerTask() {
            @Override
            public void run() {
                currencyRateCollector.collectAllRates();
                sendUsersNotificationsAfterChangeRate();
            }
        };

        Timer timer = new Timer();
        timer.schedule(
            timerTaskSendNotification,
            calendar.getTime(),
            3600000
        );

        timer.schedule(
            timerTaskRateCollect,
            calendar.getTime(),
            100000
        );
    }

    public static int getCurrentHour() {
        return LocalDateTime.now().getHour();
    }

    public static void sendUsersNotifications() {
        int currentHour = getCurrentHour();
        List<User> users = USER_SERVICE.getAllByAlertTime(currentHour);
        for (User user : users) {
            sendMessageWithRatesToUser(user, false);
        }
    }

    public static void sendUsersNotificationsAfterChangeRate() {
        List<User> users = USER_SERVICE.getUsersFromCurrencyChanges();
        for (User user : users) {
            sendMessageWithRatesToUser(user, true);
        }
        USER_SERVICE.deleteCurrencyChanges();
    }

    private static void sendMessageWithRatesToUser(User user, boolean rateWithDelta) {
        TelegramService telegramService = new TelegramService(new CurrencySender());
        telegramService.sendMessage(user.getUserId(),
            MessageService.getInformationMessageByUser(user, rateWithDelta));

        UserMessage userMessage = new UserMessage();
        userMessage.setUser(user);
        InlineKeyboardMarkup mainMenu = new MainMenu().createMenu(userMessage);
        telegramService.sendMessage(user.getUserId(),
            user.getTranslate("HEADSIGN_MAINMENU"),
            mainMenu);
    }
}
