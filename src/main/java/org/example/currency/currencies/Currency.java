package org.example.currency.currencies;

import lombok.Getter;

@Getter
public enum Currency {
    UAN(980, "Гривня", "Hryvnia", "₴"),
    USD(840, "Долар", "Dollar", "$"),
    EUR(978, "Євро", "Euro", "€");
    private int id;
    private String nameUKR;
    private String nameENG;
    private String symbol;

    Currency(int id, String nameUKR, String nameENG, String symbol) {
        this.id = id;
        this.nameUKR = nameUKR;
        this.nameENG = nameENG;
        this.symbol = symbol;
    }
}