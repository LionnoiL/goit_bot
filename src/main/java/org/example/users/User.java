package org.example.users;

import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private int symbolsAfterComma;
    private Currency currency;
    private Bank bank;
    private int userHours;
    private int alertTime;
}
