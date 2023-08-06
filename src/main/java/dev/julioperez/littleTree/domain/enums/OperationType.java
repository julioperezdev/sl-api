package dev.julioperez.littleTree.domain.enums;

import java.util.Arrays;

public enum OperationType {

    BUY("comprar"),
    SELL("vender");

    private final String description;

    OperationType(String description) {
        this.description = description;
    }

    public boolean isValidOperationType(){
        return Arrays.stream(OperationType.values())
                .anyMatch(particular -> particular.description.equalsIgnoreCase(description));
    }
}
