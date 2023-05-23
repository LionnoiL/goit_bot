package ua.dpw.currency.rates;

import static ua.dpw.database.Service.BANK_SERVICE;
import static ua.dpw.database.Service.CURRENCY_SERVICE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.database.HibernateUtil;
import ua.dpw.users.User;

public class CurrencyRateService {

    public void saveRateToDataBase(List<CurrencyRate> currencyRates) {
        if (!currencyRates.isEmpty()) {
            try (Session session = HibernateUtil.openSession()) {
                Transaction transaction = session.beginTransaction();
                for (CurrencyRate rate : currencyRates) {
                    CurrencyRate lastByBank = getLastRatesByBankAndCurrency(rate.getBank(),
                        rate.getCurrency());
                    if (lastByBank == null
                        || lastByBank.getBuyingRate().compareTo(rate.getBuyingRate()) != 0
                        || lastByBank.getSellingRate().compareTo(rate.getSellingRate()) != 0) {

                        if (lastByBank != null) {
                            rate.setAmountSaleChange(
                                rate.getSellingRate().subtract(lastByBank.getSellingRate()));
                            rate.setAmountBuyChange(
                                rate.getBuyingRate().subtract(lastByBank.getBuyingRate()));
                        }
                        session.persist(rate);

                        if (lastByBank != null) {
                            CurrencyRateChanges currencyRateChanges = new CurrencyRateChanges(rate);
                            session.persist(currencyRateChanges);
                        }
                    }
                }
                transaction.commit();
            }
        }
    }

    public CurrencyRate getLastRatesByBankAndCurrency(Bank bank, Currency currency) {
        try (Session session = HibernateUtil.openSession()) {
            String hql = """
                    FROM CurrencyRate WHERE bank = :bank AND currency = :currency ORDER BY id DESC
                """;
            Query<CurrencyRate> query = session.createQuery(hql, CurrencyRate.class);
            query.setParameter("bank", bank);
            query.setParameter("currency", currency);
            return query.stream().findFirst().orElse(null);
        }
    }

    public List<CurrencyRate> getLastRatesByUser(User user) {
        List<CurrencyRate> result = new ArrayList<>();
        try (Session session = HibernateUtil.openSession()) {

            String sql = """
                SELECT * FROM RATES WHERE id IN (
                SELECT MAX(id) AS id  FROM RATES WHERE bank_id = :bank_id AND currency_id IN
                (SELECT currency_id  FROM USERS_CURRENCIES WHERE user_id = :user_id)
                GROUP BY currency_id)
                """;
            Query<Object[]> query = session.createNativeQuery(sql, Object[].class);
            query.setParameter("bank_id", user.getBank().getId());
            query.setParameter("user_id", user.getUserId());
            List<Object[]> list = query.getResultList();

            for (Object[] row : list) {
                CurrencyRate rate = new CurrencyRate(
                    BANK_SERVICE.getById((Integer) row[2]),
                    CURRENCY_SERVICE.getById((Integer) row[3]),
                    (BigDecimal) row[4],
                    (BigDecimal) row[5]
                );
                rate.setAmountSaleChange((BigDecimal) row[6]);
                rate.setAmountBuyChange((BigDecimal) row[7]);
                result.add(rate);
            }
        }

        return result;
    }
}
