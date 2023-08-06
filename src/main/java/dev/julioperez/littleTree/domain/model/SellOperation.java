package dev.julioperez.littleTree.domain.model;


import java.util.Date;
import java.util.UUID;

public class SellOperation {

    private UUID uuid;
    private Date createdAt;
    private UUID clientId;
    private String phone;
    private String description;
    private UUID currencyMultiBoxId;
    private Float price;
    private Float quantity;
    private Float subProfit;
    private Float profit;
    private Float total;
    private UUID sellerId;
    private UUID operationId;
}
