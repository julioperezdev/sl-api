package dev.julioperez.littleTree.box.currencyBox.shared.domain.dto;

import java.util.Date;

public record CurrencyMultiboxToList(
        String id,
        Date createdAt,
        Date updatedAt,
        String operationType,
        Float quantityOperation,
        Float quantity,
        String status
) {
}
