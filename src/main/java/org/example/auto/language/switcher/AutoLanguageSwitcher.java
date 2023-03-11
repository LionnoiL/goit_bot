package org.example.auto.language.switcher;

import org.telegram.telegrambots.meta.api.objects.Update;
import static org.example.AppLauncher.APPLICATION_PROPERTIES;

import java.util.Map;

public class AutoLanguageSwitcher {
    public static Map<String, String> commandsLanguage;
    public static void createVocabularyMap(Update update){

        String money = update.getMessage().getFrom().getLanguageCode().toString().toLowerCase(); // TODO remove
        System.out.println(money);
        switch (money) {
            case "uk":
                commandsLanguage = APPLICATION_PROPERTIES.getCommandsLanguageUa();
                break;
            case "en":
                commandsLanguage = APPLICATION_PROPERTIES.getCommandsLanguageEng();
                break;
            default:
                commandsLanguage = APPLICATION_PROPERTIES.getCommandsLanguageEng();
                break;
        }
    }
}

