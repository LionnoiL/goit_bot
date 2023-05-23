package ua.dpw.telegrambots.bot.menus;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MenuUtils {

    public static List<InlineKeyboardButton> createMenuRow(String buttonText, String callBackText) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton(buttonText);
        button.setCallbackData(callBackText);
        row.add(button);
        return row;
    }

    public static List<InlineKeyboardButton> createMenuRow(String buttonText,
        String callBackText, String button2Text, String callBack2Text) {
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton(buttonText);
        button1.setCallbackData(callBackText);
        row.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton(button2Text);
        button2.setCallbackData(callBack2Text);
        row.add(button2);

        return row;
    }

    public static InlineKeyboardButton createButton(String buttonText, String callBackText) {
        InlineKeyboardButton button = new InlineKeyboardButton(buttonText);
        button.setCallbackData(callBackText);
        return button;
    }
}
