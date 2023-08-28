package dev.julioperez.littleTree.box.domain.enums;


import java.util.Arrays;
import java.util.List;

public enum CurrencyBox {
    USD_HIGH("USD HIGH"),
    USD_LOW("USD LOW"),
    EURO("EURO"),
    REAL("REAL"),
    PESO("PESO"),
    PESO_OFFICE("PESO_OFFICE");

    private final String value;

    CurrencyBox(String value) {
        this.value = value;
    }

    public boolean isPesos(){
        return this.value.equalsIgnoreCase(PESO.value);
    }

    public String value(){
        return this.value;
    }
    public boolean isValidCurrencyBox(){
        return Arrays.stream(CurrencyBox.values())
                .anyMatch(particular -> particular.value.equalsIgnoreCase(value));
    }
    public static CurrencyBox returnCurrencyBoxByDescription(String externalValue){
        List<CurrencyBox> currencyBoxes = Arrays.stream(CurrencyBox.values())
                .filter(particular -> particular.value.equalsIgnoreCase(externalValue)).toList();
        if(currencyBoxes.isEmpty()) throw new IllegalArgumentException(String.format(" %s dont exist on CurrencyBox ", externalValue));
        if(currencyBoxes.size() != 1) throw new IllegalArgumentException(String.format(" %s cant match with more of one CurrencyBox ", externalValue));
        return currencyBoxes.get(0);
    }


}
