package dev.julioperez.littleTree.domain.enums;

import java.util.Arrays;

public enum SellerCommissionStatus {

    PENDING("pendiente"),
    PAYED("pagado");

    private final String description;

    SellerCommissionStatus(String description) {
        this.description = description;
    }

    public boolean isValidSellerCommissionStatus(){
        return Arrays.stream(SellerCommissionStatus.values())
                .anyMatch(particular -> particular.description.equalsIgnoreCase(description));
    }
}
