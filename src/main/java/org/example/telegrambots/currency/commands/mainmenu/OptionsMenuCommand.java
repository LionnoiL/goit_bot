package org.example.telegrambots.currency.commands.mainmenu;

import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.menus.OptionsMenu;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class OptionsMenuCommand extends BotCommand {

  public OptionsMenuCommand() {super(new TelegramService(new CurrencySender()));
  }
  @Override
  public void execute(UserMessage userMessage) {

    InlineKeyboardMarkup optionsMenu = new OptionsMenu().createMenu(userMessage);
    getTelegramService().sendMessage(userMessage.getChatId(), userMessage.getUser().getLanguage().get("HEADSIGN_OPTIONS"),
        optionsMenu);
  }
}
