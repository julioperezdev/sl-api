package dev.julioperez.littleTree.box.domain.dto;

import java.util.Date;

public record CurrencyMultiboxToList(
        String id,
        Date updatedAt,
        String operationType,
        Float quantityOperation,
        Float quantity
) {
}
