package org.example.language;

import java.util.HashMap;
import java.util.Map;

public class LanguageSwitcher {
    public static Map<String, String> setLanguageMap(String langCode) {

        switch (langCode.toLowerCase()) {
            case "uk":
                return createUaLanguageMap();
            default:
                return createEngLanguageMap();
        }
    }

    private static Map<String, String> createUaLanguageMap() {
        Map<String, String> uaMap = new HashMap<>();

        for (CommandsUa commandsUa : CommandsUa.values()) {
            uaMap.put(commandsUa.toString(), commandsUa.getText());
        }
        return uaMap;
    }
    private static Map<String, String> createEngLanguageMap() {
        Map<String, String> engMap = new HashMap<>();

        for (CommandsEng commandsEng : CommandsEng.values()) {
            engMap.put(commandsEng.toString(), commandsEng.getText());
        }
        return engMap;
    }
}

