package dev.julioperez.littleTree.currency.domain.model;


import dev.julioperez.littleTree.currency.domain.enums.CurrencyName;

import java.util.Date;

public final class Currency {

    private final CurrencyId id;
    private final CurrencyName name;
    private final CurrencyBuyPrice buyPrice;
    private final CurrencySellPrice sellPrice;
    private final CurrencyUpdatedAt updatedAt;

    public Currency(String id, String name, Float buyPrice, Float sellPrice, Date updatedAt) {
        this.id = new CurrencyId(id);
        this.name = CurrencyName.returnCurrencyNameByDescription(name);
        this.buyPrice = new CurrencyBuyPrice(buyPrice);
        this.sellPrice = new CurrencySellPrice(sellPrice);
        this.updatedAt = new CurrencyUpdatedAt(updatedAt);
    }

    public String getId() {
        return id.value();
    }

    public String getName() {
        return name.value();
    }

    public Float getBuyPrice() {
        return buyPrice.value();
    }

    public Float getSellPrice() {
        return sellPrice.value();
    }

    public Date getUpdatedAt() {
        return updatedAt.value();
    }
}
