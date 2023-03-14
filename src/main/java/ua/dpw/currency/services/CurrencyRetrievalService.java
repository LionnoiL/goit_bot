package ua.dpw.currency.services;

import java.util.List;
import ua.dpw.currency.rates.CurrencyRate;

public interface CurrencyRetrievalService {

    public List<CurrencyRate> getCurrencyRates();
}
