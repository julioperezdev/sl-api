package dev.julioperez.littleTree.currency.domain.model;


public final class Currency {

    private final CurrencyId id;
    private final CurrencyName name;
    private final CurrencyBuyPrice buyPrice;
    private final CurrencySellPrice sellPrice;
    private final CurrencyUpdateAt updateAt;

    public Currency(CurrencyId id, CurrencyName name, CurrencyBuyPrice buyPrice, CurrencySellPrice sellPrice, CurrencyUpdateAt updateAt) {
        this.id = id;
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.updateAt = updateAt;
    }
}
