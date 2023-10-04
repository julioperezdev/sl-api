package dev.julioperez.littleTree.currency.domain.model;

import dev.julioperez.littleTree.shared.domain.model.DateValueObject;

import java.util.Date;

public final class CurrencyUpdatedAt extends DateValueObject {
    public CurrencyUpdatedAt(Date value) {
        super(value);
    }
}
