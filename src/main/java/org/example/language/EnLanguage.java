package org.example.language;

public class EnLanguage implements Language {
    @Override
    public String getTranslation(String inputText) {
        return inputText;
    }
}
