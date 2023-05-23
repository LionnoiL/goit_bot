package ua.dpw.notifications;

import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import ua.dpw.TestUtil;
import ua.dpw.telegrambots.bot.services.TelegramService;
import ua.dpw.users.UserService;

class SchedulerTest {

    @Test
    void sendUsersNotificationsTelegramSenMessage() throws Exception {
        int userAlertTime = TestUtil.getUserAlertTime();

        UserService userService = Mockito.mock(UserService.class);
        when(userService.getAllByAlertTime(userAlertTime)).thenReturn(TestUtil.getUsersList());

        BotApiMethod botApiMethod = Mockito.mock(BotApiMethod.class);
        TelegramService telegramService = Mockito.mock(TelegramService.class);

        Scheduler.sendUsersNotifications();

        verifyPrivate(telegramService).invoke("execute", botApiMethod);
    }

    @Test
    void sendUsersNotificationsAfterChangeRateTelegramSenMessage() throws Exception {
        UserService userService = Mockito.mock(UserService.class);
        when(userService.getUsersFromCurrencyChanges()).thenReturn(TestUtil.getUsersList());

        BotApiMethod botApiMethod = Mockito.mock(BotApiMethod.class);
        TelegramService telegramService = Mockito.mock(TelegramService.class);

        Scheduler.sendUsersNotifications();

        verifyPrivate(telegramService).invoke("execute", botApiMethod);
    }
}
