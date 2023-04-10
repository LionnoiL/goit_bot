package ua.dpw.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.database.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private long userId;
    @Column(name = "user_first_name", length = 50)
    private String userName;
    @Column(name = "user_last_name", length = 50)
    private String lastName;
    @Column(name = "after_comma_symbols")
    private int symbolsAfterComma;
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;
    @Column(name = "delta_hours")
    private int deltaHours;
    @Column(name = "alert_time")
    private int alertTime;
    @Column(name = "lang_code")
    private String langCode;
    @Transient
    private boolean newUser;
    @Column(name = "created")
    private LocalDate createdDate;
    @Column(name = "last_update")
    private LocalDate updatedDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_currencies",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "currency_id")}
    )
    private List<Currency> currencies;

    public void setLangCode(String pLangCode) {
        if (pLangCode == null) {
            pLangCode = "en";
        }
        this.langCode = pLangCode;
    }

    public String getTranslate(String key) {
        String translate = Service.LANGUAGE_SERVICE.getTranslate(langCode, key);
        if (translate.isEmpty() && !"en".equals(langCode)) {
            translate = Service.LANGUAGE_SERVICE.getTranslate("en", key);
        }
        return translate;
    }
}
