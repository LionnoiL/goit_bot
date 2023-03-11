package org.example.currency.currencies;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currency {
    UAN(980, "Гривня", "Hryvnia", "₴"),
    USD(840, "Долар", "Dollar", "$"),
    EUR(978, "Євро", "Euro", "€");

    private int id;
    private String nameUKR;
    private String nameENG;
    private String symbol;
}