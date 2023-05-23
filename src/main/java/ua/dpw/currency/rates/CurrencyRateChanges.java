package ua.dpw.currency.rates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rates_changes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRateChanges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "rate_id")
    private CurrencyRate currencyRate;

    public CurrencyRateChanges(CurrencyRate rate) {
        this.currencyRate = rate;
    }
}
