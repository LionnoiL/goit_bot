package ua.dpw.currency.services;

import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.users.User;

public class CurrencyRateCryptoService {

    private static final String URL_BTC = "https://ru.investing.com/crypto/bitcoin/btc-usd";
    private static final String URL_ETH = "https://ru.investing.com/crypto/ethereum/eth-usd";

    public String cryptoInfo(User user) {
        List<Currency> userCurrencies = user.getCurrencies();
        StringBuilder result = new StringBuilder();
        try {
            if (userCurrencies.contains(Currency.BITCOIN)) {
                Element elementBTC = getElement(URL_BTC);
                result.append("Bitcoin       " + elementBTC.text() + " USD\n");
            }
            if (userCurrencies.contains(Currency.ETHEREUM)) {
                Element elementETH = getElement(URL_ETH);
                result.append("Ethereum " + elementETH.text() + " USD\n");
            }
        } catch (IOException e) {
            return "";
        }
        return result.toString();
    }

    private static Element getElement(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        return document.selectFirst("span.text-2xl");
    }
}
