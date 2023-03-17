package ua.dpw.currency.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class CurrencyRateCryptoService {
    private static final String URL_BTC = "https://ru.investing.com/crypto/bitcoin/btc-usd";
    private static final String URL_ETH = "https://ru.investing.com/crypto/ethereum/eth-usd";

    public String cryptoInfo() {

        StringBuilder result = new StringBuilder();

        try {
            Document documentBIT = Jsoup.connect(URL_BTC)
                    .get();
            Element elementBTC = documentBIT.selectFirst("span.text-2xl");
            result.append("Bitcoin       " + elementBTC.text() + " USD\n");

            Document documentETH = Jsoup.connect(URL_ETH)
                    .get();
            Element elementETH = documentETH.selectFirst("span.text-2xl");
            result.append("Ethereum " + elementETH.text() + " USD\n");

        } catch (IOException e) {
            return "";
        }
        return  result.toString();
    }
}
