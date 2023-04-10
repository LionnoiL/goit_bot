package ua.dpw.currency.rates;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.currencies.Currency;

@Entity
@Table(name = "rates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;
    @Column(name = "rate_date")
    private Calendar rateDate;
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
    @Column(name = "rate_sale_value")
    private BigDecimal sellingRate;
    @Column(name = "rate_buy_value")
    private BigDecimal buyingRate;
    @Column(name = "amount_sale_change")
    private BigDecimal amountSaleChange;
    @Column(name = "amount_buy_change")
    private BigDecimal amountBuyChange;
    public CurrencyRate(Bank pBank, Currency pCurrency, BigDecimal pSellingRate,
        BigDecimal pBuyingRate) {
        this.bank = pBank;
        this.currency = pCurrency;
        this.sellingRate = pSellingRate;
        this.buyingRate = pBuyingRate;
        this.rateDate = Calendar.getInstance();
    }

    @Override
    public String toString() {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.ms");

        return "CurrencyRate{" + bank
            + ", " + df.format(rateDate.getTime())
            + ", " + currency
            + ", " + sellingRate
            + ", " + buyingRate
            + '}';
    }
}
