package ua.dpw.telegrambots.bot.menus;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import ua.dpw.telegrambots.bot.services.UserMessage;

import java.io.IOException;

public interface TelegramMenu {

    ReplyKeyboard createMenu(UserMessage userMessage) throws IOException;
}
