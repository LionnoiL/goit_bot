package ua.dpw.language;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.dpw.database.HibernateUtil;

public class LanguageService {

    public String getTranslate(String langCode, String key) {
        String result = "";
        try (Session session = HibernateUtil.openSession()) {
            String sql = """
                SELECT LANGUAGE_VALUE FROM LANGUAGE_VALUES
                WHERE LANGUAGE_CODE = :lang_code AND LANGUAGE_KEY = :key
                """;
            Query<String> query = session.createNativeQuery(sql, String.class);
            query.setParameter("lang_code", langCode);
            query.setParameter("key", key);

            List<String> list = query.getResultList();
            for (String row : list) {
                result = row;
            }
        }
        result = result.replace("\\n", "\n");
        result = result.replace("\\t", "\t");
        return result;
    }
}
