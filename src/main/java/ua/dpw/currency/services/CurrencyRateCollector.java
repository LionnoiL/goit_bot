package ua.dpw.currency.services;

import java.util.List;
import ua.dpw.currency.rates.CurrencyRate;
import ua.dpw.currency.storage.CurrencyRateStorage;

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