package org.example.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;
import org.example.language.EnLanguage;
import org.example.language.Language;
import org.example.language.UaLanguage;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long userId;
    private String userName;
    private String lastName;
    private int symbolsAfterComma;
    private Currency currency;
    private Bank bank;
    private int userHours;
    private int alertTime;
    private Language language;

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setLanguage(String languageCode) {
        Language language = new EnLanguage();
        if (languageCode == null) {
            languageCode = "en";
        }
        String langShort = languageCode.toLowerCase();

        if ("ua".equals(langShort)) {
            language = new UaLanguage();
        }

        setLanguage(language);
    }

    public String getTranslation(String text){
        return getLanguage().getTranslation(text);
    }
}
