package org.example.language;

import java.util.HashMap;
import java.util.Map;

public class UaLanguage implements Language{
    private Map<String, String> values = new HashMap<>();

    public UaLanguage() {
        values.put("How can I help you? ⤵", "Чим Вам допомогти?");
        values.put("Settings", "Налаштування");
    }


    @Override
    public String getTranslation(String inputText) {
        String res = inputText;
        if(values.containsKey(inputText)){
            res = values.get(inputText);
        }
        return res;
    }
}
