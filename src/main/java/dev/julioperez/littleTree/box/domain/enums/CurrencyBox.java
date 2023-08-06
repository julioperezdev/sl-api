package dev.julioperez.littleTree.box.domain.enums;


import java.util.Arrays;

public enum CurrencyBox {
    USD_HIGH("USD HIGH"),
    USD_LOW("USD LOW"),
    EURO("EURO"),
    REAL("REAL"),
    PESO("PESO");

    private final String description;

    CurrencyBox(String description) {
        this.description = description;
    }

    public boolean isPesos(){
        return this.description.equalsIgnoreCase(PESO.description);
    }

    public boolean isValidCurrencyBox(){
        return Arrays.stream(CurrencyBox.values())
                .anyMatch(particular -> particular.description.equalsIgnoreCase(description));
    }
}
