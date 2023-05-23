package ua.dpw.currency.currencies;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "currency_name")
    private String name;
    @Column(name = "code")
    private int code;
    @Column(name = "crypto")
    private boolean crypto;

    public Currency(int pId, String pName) {
        this.id = pId;
        this.name = pName;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Currency currency = (Currency) o;
        if (code != currency.code) {
            return false;
        }
        if (crypto != currency.crypto) {
            return false;
        }
        return name.equals(currency.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + code;
        result = 31 * result + (crypto ? 1 : 0);
        return result;
    }
}
