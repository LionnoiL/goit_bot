package org.example.telegrambots.currency.commands.mainmenu;

import org.example.telegrambots.bot.commands.BotCommand;
import org.example.telegrambots.bot.services.TelegramService;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.example.telegrambots.currency.menus.MainMenu;
import org.example.telegrambots.currency.sender.CurrencySender;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class GetInfoCommand extends BotCommand {

  public GetInfoCommand() {
    super(new TelegramService(new CurrencySender()));
  }
  @Override
  public void execute(UserMessage userMessage) {
    getTelegramService().sendMessage(userMessage.getChatId(), Commands.HEADSIGN_INFO.getButtonText()
    +"\nВалюта: "+userMessage.getUser().getCurrency()
            +"\nБанк: "+userMessage.getUser().getBank()
            +"\nКурс: "
            +"\nЧас сповіщення: "+userMessage.getUser().getAlertTime()
            +"\nТочність: "+userMessage.getUser().getSymbolsAfterComma()+" знаки");

    InlineKeyboardMarkup mainMenu = new MainMenu().createMenu(userMessage);
    getTelegramService().sendMessage(userMessage.getChatId(), Commands.HEADSIGN_MAINMENU.getButtonText(),
        mainMenu);
  }
}
