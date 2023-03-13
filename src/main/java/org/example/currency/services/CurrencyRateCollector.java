package org.example.currency.services;

import org.example.currency.rates.CurrencyRate;
import org.example.currency.storage.CurrencyRateStorage;

import java.util.List;

public class CurrencyRateCollector {
    private List<CurrencyRetrievalService> retrievalServices = List.of(
            new CurrencyRetrievalOschadService(),
            new CurrencyRetrievalMonoService(),
            new CurrencyRetrievalNbuService(),
            new CurrencyRetrievalPrivatService()
    );

    public void collectAllRates() {
        for (CurrencyRetrievalService retrievalService : retrievalServices) {
            List<CurrencyRate> listRates = retrievalService.getCurrencyRates();
            CurrencyRateStorage.saveRateToCache(listRates);
        }
    }
}