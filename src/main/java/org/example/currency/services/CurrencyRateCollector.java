package org.example.currency.services;

import org.example.currency.rates.CurrencyRate;
import org.example.currency.storage.CurrencyRateStorage;

import java.util.List;

public class CurrencyRateCollector {
    private List<CurrencyRetrievalService> retrievalServices = List.of(
            new CurrencyRetrievalOschadService(),
            new CurrencyRetrievalMonoService(),
            new CurrencyRetrievalNbuService()
            // TODO: Сюди дописати усі сервіси для завантаження курсів з інших банків
    );

    public void collectAllRates() {
        for (CurrencyRetrievalService retrievalService : retrievalServices) {
            List<CurrencyRate> listRates = retrievalService.getCurrencyRates();
            CurrencyRateStorage.saveRateToCache(listRates);
        }
    }
}