package org.example.telegrambots.currency.commands.options;

import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.example.telegrambots.currency.menus.ChoiceNumberSymbolMenu;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class OptionsNumberSimbolsCommand extends BotCommand {

  public OptionsNumberSimbolsCommand() {
    super(new TelegramService(new CurrencySender()));
  }

  @Override
  public void execute(UserMessage userMessage) {

    InlineKeyboardMarkup menu = new ChoiceNumberSymbolMenu().createMenu(userMessage);

    getTelegramService().sendMessage(userMessage.getChatId(), Commands.HEADSIGN_COMMASYMBOLS.getButtonText(),
        menu);
  }
}
