package ua.dpw.currency.currencies;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.dpw.database.HibernateUtil;

public class CurrencyService {

    public Currency getById(int id) {
        try (Session session = HibernateUtil.openSession()) {
            String hql = """
                FROM Currency WHERE id = :id
                """;
            Query<Currency> query = session.createQuery(hql, Currency.class);
            query.setParameter("id", id);
            return query.stream().findFirst().orElse(null);
        }
    }

    public Currency getByName(String name) {
        try (Session session = HibernateUtil.openSession()) {
            String hql = """
                FROM Currency WHERE name = :name
                """;
            Query<Currency> query = session.createQuery(hql, Currency.class);
            query.setParameter("name", name);
            return query.stream().findFirst().orElse(null);
        }
    }

    public Currency getByCode(int code) {
        try (Session session = HibernateUtil.openSession()) {
            String hql = """
                FROM Currency WHERE code = :code
                """;
            Query<Currency> query = session.createQuery(hql, Currency.class);
            query.setParameter("code", code);
            return query.stream().findFirst().orElse(null);
        }
    }
}
