package org.example.users;

import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

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
    private String langCode;
    private Map<String, String> language;
}
