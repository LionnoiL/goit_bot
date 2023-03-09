package org.example.telegrambots.bot.menus;

import org.example.telegrambots.bot.services.UserMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public interface TelegramMenu {

  ReplyKeyboard createMenu(UserMessage userMessage);
}
