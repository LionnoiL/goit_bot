package ua.dpw.database;

import java.io.File;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {

    private static final HibernateUtil INSTANCE;

    static {
        INSTANCE = new HibernateUtil();
    }

    @Getter
    private SessionFactory sessionFactory;

    private HibernateUtil() {
        Migrate.migrate("jdbc:h2:./db/currency_bot");
        File f = new File("config/hibernate.cfg.xml");
        sessionFactory = new Configuration().configure(f).buildSessionFactory();
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
