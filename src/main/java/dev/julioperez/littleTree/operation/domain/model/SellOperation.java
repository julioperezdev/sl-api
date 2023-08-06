package dev.julioperez.littleTree.operation.domain.model;


import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBoxId;
import dev.julioperez.littleTree.client.domain.model.ClientId;
import dev.julioperez.littleTree.seller.domain.model.SellerId;

import java.util.Date;
import java.util.UUID;

public final class SellOperation {

    private SellOperationId id;
    private SellOperationCreatedAt createdAt;
    private ClientId clientId;
    private SellOperationPhone phone;
    private SellOperationDescription description;
    private CurrencyMultiBoxId currencyMultiBoxId;
    private SellOperationPrice price;
    private SellOperationQuantity quantity;
    private SellOperationSubProfit subProfit;
    private SellOperationProfit profit;
    private SellOperationTotal total;
    private SellerId sellerId;
    private OperationId operationId;
}
