package org.example.language;

import org.example.users.User;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

public class LanguageSwitcher {
    public static Map<String, String> setLanguageMap(Message message) {

        String langCode = message.getFrom().getLanguageCode().toLowerCase();

        switch (langCode) {
            case "uk":
                return createUaLanguageMap();
            case "en":
                return createEngLanguageMap();
            default:
                return createEngLanguageMap();
        }
    }

    private static Map<String, String> createUaLanguageMap() {
        Map<String, String> uaMap = new HashMap<>();

        for (CommandsUa commandsUa : CommandsUa.values()) {
            uaMap.put(commandsUa.toString(), commandsUa.getButtonText());
        }
        return uaMap;
    }
    private static Map<String, String> createEngLanguageMap() {
        Map<String, String> engMap = new HashMap<>();

        for (CommandsEng commandsEng : CommandsEng.values()) {
            engMap.put(commandsEng.toString(), commandsEng.getButtonText());
        }
        return engMap;
    }
}

