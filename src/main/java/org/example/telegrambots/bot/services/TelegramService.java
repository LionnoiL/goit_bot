package org.example.telegrambots.bot.services;

import org.example.telegrambots.bot.sender.BotSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class TelegramService {
  private static final Logger log = LoggerFactory.getLogger(TelegramService.class);
  private final BotSender botSender;

  public TelegramService(BotSender botSender) {
    this.botSender = botSender;
  }

  public void sendMessage(Long chatId, String text, ReplyKeyboard replyKeyboard) {
    SendMessage sendMessage = SendMessage
        .builder()
        .text(text)
        .chatId(chatId.toString())
        .parseMode(ParseMode.HTML)
        .replyMarkup(replyKeyboard)
        .build();
    execute(sendMessage);
  }

  public void sendMessage(Long chatId, String text, InlineKeyboardMarkup keyboardMarkup) {
    SendMessage sendMessage = SendMessage
        .builder()
        .text(text)
        .chatId(chatId.toString())
        .parseMode(ParseMode.HTML)
        .replyMarkup(keyboardMarkup)
        .build();
    execute(sendMessage);
  }

  public void sendMessage(Long chatId, String text) {
    SendMessage sendMessage = SendMessage
        .builder()
        .text(text)
        .chatId(chatId.toString())
        .parseMode(ParseMode.HTML)
        .build();
    execute(sendMessage);
  }

  private void execute(BotApiMethod botApiMethod) {
    try {
      botSender.execute(botApiMethod);
    } catch (Exception e) {
      log.error("Exception: ", e);
    }
  }
}
