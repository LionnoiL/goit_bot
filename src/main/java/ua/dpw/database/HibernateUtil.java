package ua.dpw.database;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.currency.rates.CurrencyRate;
import ua.dpw.currency.rates.CurrencyRateChanges;
import ua.dpw.users.User;

public final class HibernateUtil {

    private static final HibernateUtil INSTANCE;

    static {
        INSTANCE = new HibernateUtil();
    }

    @Getter
    private SessionFactory sessionFactory;

    private HibernateUtil() {
        sessionFactory = new Configuration()
            .addAnnotatedClass(User.class)
            .addAnnotatedClass(Bank.class)
            .addAnnotatedClass(Currency.class)
            .addAnnotatedClass(CurrencyRate.class)
            .addAnnotatedClass(CurrencyRateChanges.class)
            .buildSessionFactory();
        Migrate.migrate((String) sessionFactory.getProperties().get("hibernate.connection.url"));
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public static Session openSession() {
        return HibernateUtil.getInstance().getSessionFactory().openSession();
    }

    public void close() {
        sessionFactory.close();
    }
}
