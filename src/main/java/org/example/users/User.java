package org.example.users;

import lombok.Getter;
import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User implements Serializable {
    private long userId;
    private String userName;
    private String lastName;
    private int symbolsAfterComma;
    private List<Currency> currencies = new ArrayList<>();
    private Bank bank;
    private int userHours;
    private int alertTime;
    private String langCode;
    private transient Map<String, String> language;
}
