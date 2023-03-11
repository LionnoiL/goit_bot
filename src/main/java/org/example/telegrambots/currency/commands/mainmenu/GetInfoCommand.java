package org.example.telegrambots.currency.commands.mainmenu;

import org.example.language.LanguageSwitcher;
import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.example.telegrambots.currency.menus.MainMenu;
import org.example.telegrambots.currency.messages.MessageService;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.Map;

public class GetInfoCommand extends BotCommand {

  public GetInfoCommand() {
    super(new TelegramService(new CurrencySender()));
  }
  @Override
  public void execute(UserMessage userMessage) {
    getTelegramService().sendMessage(userMessage.getChatId(), MessageService.getInformationMessageByUserId(userMessage.getChatId()));

    InlineKeyboardMarkup mainMenu = new MainMenu().createMenu(userMessage);
    getTelegramService().sendMessage(userMessage.getChatId(), userMessage.getUser().getLanguage().get("HEADSIGN_MAINMENU"),
        mainMenu);
  }
}
