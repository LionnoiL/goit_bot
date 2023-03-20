package ua.dpw.currency.currencies;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currency {
    UAH(980, "Гривня", "Hryvnia", "₴"),
    USD(840, "Долар", "Dollar", "$"),
    EUR(978, "Євро", "Euro", "€"),
    BITCOIN(0, "", "", ""),
    ETHEREUM(0, "", "", "");

    private int id;
    private String nameUKR;
    private String nameENG;
    private String symbol;
}