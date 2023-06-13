package ua.dpw.currency.services;

import static ua.dpw.database.Service.RATES_SERVICE;

import java.util.List;
import ua.dpw.currency.rates.CurrencyRate;

public class CurrencyRateCollector {

    private List<CurrencyRetrievalService> retrievalServices = List.of(
       // new CurrencyRetrievalOschadService(),
        new CurrencyRetrievalMonoService(),
        new CurrencyRetrievalNbuService(),
        new CurrencyRetrievalPrivatService()
    );

    public void collectAllRates() {
        for (CurrencyRetrievalService retrievalService : retrievalServices) {
            List<CurrencyRate> listRates = retrievalService.getCurrencyRates();
            RATES_SERVICE.saveRateToDataBase(listRates);
        }
    }
}
