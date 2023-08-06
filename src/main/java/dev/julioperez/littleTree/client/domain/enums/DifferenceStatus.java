package dev.julioperez.littleTree.client.domain.enums;


import java.util.Arrays;

public enum DifferenceStatus {

    PENDING("pendiente"),
    DONE("resuelto");

    private final String description;

    DifferenceStatus(String description) {
        this.description = description;
    }

    public boolean isPending(){
        return this.description.equalsIgnoreCase(PENDING.description);
    }

    public boolean isValidDifferenceStatus(){
        return Arrays.stream(DifferenceStatus.values())
                .anyMatch(particular -> particular.description.equalsIgnoreCase(description));
    }
}
