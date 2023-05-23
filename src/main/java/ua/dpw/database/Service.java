package ua.dpw.database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ua.dpw.currency.bank.BankService;
import ua.dpw.currency.currencies.CurrencyService;
import ua.dpw.currency.rates.CurrencyRateService;
import ua.dpw.language.LanguageService;
import ua.dpw.users.UserService;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Service {

    public static final BankService BANK_SERVICE = new BankService();
    public static final CurrencyService CURRENCY_SERVICE = new CurrencyService();
    public static final UserService USER_SERVICE = new UserService();
    public static final CurrencyRateService RATES_SERVICE = new CurrencyRateService();
    public static final LanguageService LANGUAGE_SERVICE = new LanguageService();
}
