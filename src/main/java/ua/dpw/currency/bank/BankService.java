package ua.dpw.currency.bank;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.dpw.database.HibernateUtil;

public class BankService {

    public Bank getById(int id) {
        try (Session session = HibernateUtil.openSession()) {
            String hql = """
                FROM Bank WHERE id = :id
                """;
            Query<Bank> query = session.createQuery(hql, Bank.class);
            query.setParameter("id", id);
            return query.stream().findFirst().orElse(null);
        }
    }

    public Bank getByName(String name) {
        try (Session session = HibernateUtil.openSession()) {
            String hql = """
                FROM Bank WHERE name = :name
                """;
            Query<Bank> query = session.createQuery(hql, Bank.class);
            query.setParameter("name", name);
            return query.stream().findFirst().orElse(null);
        }
    }
}
