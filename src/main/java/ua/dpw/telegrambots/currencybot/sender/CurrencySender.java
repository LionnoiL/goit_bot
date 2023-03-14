package ua.dpw.telegrambots.currencybot.sender;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import ua.dpw.telegrambots.bot.sender.BotSender;
import ua.dpw.telegrambots.currencybot.CurrencyBot;

public class CurrencySender extends BotSender {

    public CurrencySender() {
        super(new DefaultBotOptions(), CurrencyBot.PROPERTIES.getToken());
    }
}
