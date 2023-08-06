package dev.julioperez.littleTree.domain.enums;

import java.util.Arrays;

public enum DifferenceType {
    LACK("falta"),
    SPARE("sobra");

    private final String description;

    DifferenceType(String description) {
        this.description = description;
    }

    public boolean isLack(){
        return this.description.equalsIgnoreCase(LACK.description);
    }

    public boolean isValidDifferenceType(){
        return Arrays.stream(DifferenceType.values())
                .anyMatch(particular -> particular.description.equalsIgnoreCase(description));
    }
}
