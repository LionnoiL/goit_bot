package ua.dpw.telegrambots.bot.services;

import static java.lang.Math.toIntExact;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import ua.dpw.telegrambots.bot.sender.BotSender;

@Slf4j
public class TelegramService {

    private final BotSender botSender;

    public TelegramService(BotSender pBotSender) {
        this.botSender = pBotSender;
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

    public void sendEditedMenu(long chatId, long messageId, String text,
        InlineKeyboardMarkup keyboardMarkup) {
        EditMessageText message = EditMessageText.builder()
            .chatId(chatId)
            .messageId(toIntExact(messageId))
            .text(text)
            .replyMarkup(keyboardMarkup)
            .build();
        execute(message);
    }

    private void execute(BotApiMethod botApiMethod) {
        try {
            botSender.execute(botApiMethod);
        } catch (Exception e) {
            log.error("Exception: {}", e.toString());
        }
    }
}
