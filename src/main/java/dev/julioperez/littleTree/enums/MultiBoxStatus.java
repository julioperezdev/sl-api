package dev.julioperez.littleTree.enums;

import java.util.Arrays;

public enum MultiBoxStatus {

    PENDING("pendiente"),
    DONE("resuelto");

    private final String description;

    MultiBoxStatus(String description) {
        this.description = description;
    }

    public boolean isPending(){
        return this.description.equalsIgnoreCase(PENDING.description);
    }

    public boolean isValidMultiBoxStatus(){
        return Arrays.stream(MultiBoxStatus.values())
                .anyMatch(particular -> particular.description.equalsIgnoreCase(description));
    }
}
