package dk.via.money.business;

import dk.via.money.db.ExchangeRateDAO;
import dk.via.money.model.ExchangeRate;
import dk.via.money.model.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;

public class CurrencyExchangeService {
    private final ExchangeRateDAO dao;

    public CurrencyExchangeService() throws SQLException {
        this.dao = new ExchangeRateDAO();
    }

    public Money exchange(Money money, String toCurrency) throws SQLException {
        ExchangeRate rate = dao.getExchangeRate(money.getCurrency(), toCurrency);
        return new Money(money.getAmount().multiply(rate.getRate()).divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP), toCurrency);
    }
}
