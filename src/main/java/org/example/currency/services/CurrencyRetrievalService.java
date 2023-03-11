package org.example.currency.services;

import org.example.currency.rates.CurrencyRate;

import java.util.List;

public interface CurrencyRetrievalService {
    public List<CurrencyRate> getCurrencyRates();
}
