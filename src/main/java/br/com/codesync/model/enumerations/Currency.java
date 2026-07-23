package br.com.codesync.model.enumerations;

public enum Currency {

    BRL(1, "BRL", "R$", "Brazilian Real"),
    USD(2, "USD", "$", "United States Dollar"),
    EUR(3, "EUR", "€", "Euro"),
    GBP(4, "GBP", "£", "Pound Sterling");

    private final Integer id;
    private final String code;
    private final String symbol;
    private final String description;

    Currency(Integer id, String code, String symbol, String description) {
        this.id = id;
        this.code = code;
        this.symbol = symbol;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getDescription() {
        return this.description;
    }

    public static Currency fromId(Integer id) {
        for (Currency currency : Currency.values()) {
            if (currency.getId().equals(id)) {
                return currency;
            }
        }
        throw new IllegalArgumentException("Currency not found. Id: " + id);
    }

    public static Currency fromCode(String code) {
        if (code == null) return null;
        for (Currency currency : Currency.values()) {
            if (currency.getCode().equalsIgnoreCase(code.trim())) {
                return currency;
            }
        }
        throw new IllegalArgumentException("Currency not found. Code: " + code);
    }
}
