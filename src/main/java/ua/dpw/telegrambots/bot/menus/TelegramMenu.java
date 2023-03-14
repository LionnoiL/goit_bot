package ua.dpw.telegrambots.bot.menus;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import ua.dpw.telegrambots.bot.services.UserMessage;

public interface TelegramMenu {

    ReplyKeyboard createMenu(UserMessage userMessage);
}
