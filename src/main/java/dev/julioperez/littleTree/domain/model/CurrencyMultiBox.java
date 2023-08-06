package dev.julioperez.littleTree.domain.model;

import dev.julioperez.littleTree.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.domain.enums.MultiBoxStatus;

import java.util.Date;
import java.util.UUID;

public class CurrencyMultiBox {


    private UUID uuid;
    private Date createdAt;
    private Date updatedAt;
    private CurrencyBox currencyBox;
    private UUID operationId;
    private Float quantity;
    private Float priceOperation;
    private MultiBoxStatus multiBoxStatus;

}
