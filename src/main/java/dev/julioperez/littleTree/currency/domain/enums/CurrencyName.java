package dev.julioperez.littleTree.currency.domain.enums;

import dev.julioperez.littleTree.client.domain.enums.DifferenceStatus;

import java.util.Arrays;
import java.util.List;

public enum CurrencyName {
    USD_BIG("Dolar Grande"),
    USD_SMALL("Dolar Chico y Cambio"),
    EURO("Euro"),
    REAL("Real");

    private final String value;

    CurrencyName(String description) {
        this.value = description;
    }

    public String value(){
        return this.value;
    }
    public static CurrencyName returnCurrencyNameByDescription(String externalValue){
        List<CurrencyName> currencyNames = Arrays.stream(CurrencyName.values())
                .filter(particular -> particular.value.equalsIgnoreCase(externalValue)).toList();
        if(currencyNames.isEmpty()) throw new IllegalArgumentException(String.format(" %s dont exist on CurrencyName ", externalValue));
        if(currencyNames.size() != 1) throw new IllegalArgumentException(String.format(" %s cant match with more of one CurrencyName ", externalValue));
        return currencyNames.get(0);
    }
}
