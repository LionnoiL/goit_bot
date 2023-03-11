package org.example.language;

import java.util.HashMap;
import java.util.Map;

public class UaLanguage implements Language {

    private Map<String, String> values = new HashMap<>();

    public UaLanguage() {
        values.put("How can I help you? ⤵", "Чим Вам допомогти?");
        values.put("Settings", "Налаштування");
        values.put("Options", "Налаштування");
        values.put("Main menu", "Головне меню");
        values.put("Get info", "Отримати курс");
        values.put("Choose your bank", "Який банк Вас цікавить?");
        values.put("Privatbank", "Приватбанк");
        values.put("Monobank", "Монобанк");
        values.put("Oschadbank", "Ощадбанк");
        values.put("NBU", "НБУ");
        values.put("Bank", "Банк");
        values.put("Currency", "Валюта");
        values.put("USD", "Доллар");
        values.put("EUR", "Євро");
        values.put("Switch Off", "Виключити");
        values.put("Notification time", "Час сповіщення");
        values.put("Symbols after comma", "Кількість знаків після коми");
        values.put("A number of symbols after comma", "Кількість знаків після коми");
        values.put("Choose your currency", "Оберіть валюту");
        values.put("Select notification time", "Оберіть час сповіщення");
        values.put("⬅ Back", "⬅ Назад");
        values.put("Rate in ", "Курс в ");
        values.put("Information about exchange rates by bank", "Інформація про курси валют по банку ");
        values.put(" missing!", " відсутня!");
        values.put("Purchase", "Купівля");
        values.put("Selling", "Продаж");
    }


    @Override
    public String getTranslation(String inputText) {
        String res = inputText;
        if (values.containsKey(inputText)) {
            res = values.get(inputText);
        }
        return res;
    }
}
