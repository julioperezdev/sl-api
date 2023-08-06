package dev.julioperez.littleTree.seller.domain.enums;

import dev.julioperez.littleTree.operation.domain.enums.OperationType;

import java.util.Arrays;

public enum SellerCommissionStatus {

    PENDING("pendiente"),
    DONE("pagado");

    private final String description;

    SellerCommissionStatus(String description) {
        this.description = description;
    }

    public boolean isValidSellerCommissionStatus(){
        return Arrays.stream(SellerCommissionStatus.values())
                .anyMatch(particular -> particular.description.equalsIgnoreCase(description));
    }
}
