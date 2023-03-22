package ua.dpw.currency.currencies;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currency {
    UAH(980),
    USD(840),
    EUR(978),
    BITCOIN(0),
    ETHEREUM(0);

    private int id;
}