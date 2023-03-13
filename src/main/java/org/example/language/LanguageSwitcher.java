package org.example.language;

import java.util.HashMap;
import java.util.Map;

public class LanguageSwitcher {
    private LanguageSwitcher() {
        throw new IllegalStateException("Utility class");
    }
    public static Map<String, String> setLanguageMap(String langCode) {

        switch (langCode.toLowerCase()) {
            case "uk":
                return createUaLanguageMap();
            case "pl":
                return createPlLanguageMap();
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

    private static Map<String, String> createPlLanguageMap() {
        Map<String, String> plMap = new HashMap<>();

        for (CommandsPl commandsPl : CommandsPl.values()) {
            plMap.put(commandsPl.toString(), commandsPl.getText());
        }
        return plMap;
    }

    private static Map<String, String> createEngLanguageMap() {
        Map<String, String> engMap = new HashMap<>();

        for (CommandsEng commandsEng : CommandsEng.values()) {
            engMap.put(commandsEng.toString(), commandsEng.getText());
        }
        return engMap;
    }
}

