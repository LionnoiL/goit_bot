package org.example.language;

import org.example.users.User;
import static org.example.AppLauncher.APPLICATION_PROPERTIES;

import java.util.Map;

public class LanguageSwitcher {
    public static Map<String, String> currentLanguage;
    public static void setLanguageMap() {

        Map<Long, User> users = APPLICATION_PROPERTIES.getUsers();
        users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .forEach(el -> setLanguage(el.getLanguage()));
    }

    private static void setLanguage(String lenguage){

        switch (lenguage) {
            case "uk": {
                currentLanguage = APPLICATION_PROPERTIES.getCommandsLanguageUa();
            } break;
            case "en": {
                currentLanguage = APPLICATION_PROPERTIES.getCommandsLanguageEng();
            } break;
            default: {
                currentLanguage = APPLICATION_PROPERTIES.getCommandsLanguageEng();
            }
        }
    }
}

