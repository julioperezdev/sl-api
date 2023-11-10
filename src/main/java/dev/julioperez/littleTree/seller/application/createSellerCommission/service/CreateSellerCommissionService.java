package dev.julioperez.littleTree.seller.application.createSellerCommission.service;

import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;
import dev.julioperez.littleTree.seller.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.enums.SellerCommissionStatus;
import dev.julioperez.littleTree.seller.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.domain.port.createSellerCommission.CreateSellerCommission;
import dev.julioperez.littleTree.seller.domain.port.createSellerCommission.CreateSellerCommissionOutputPort;
import dev.julioperez.littleTree.seller.domain.port.getSellerCommission.GetSellerCommission;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerCommissionMapper;

import java.util.Optional;

public class CreateSellerCommissionService implements CreateSellerCommission {
    private final CreateSellerCommissionOutputPort createSellerCommissionOutputPort;
    private final SellerCommissionMapper sellerCommissionMapper;
    private final GetSellerCommission getSellerCommission;

    public CreateSellerCommissionService(CreateSellerCommissionOutputPort createSellerCommissionOutputPort, SellerCommissionMapper sellerCommissionMapper,GetSellerCommission getSellerCommission) {
        this.createSellerCommissionOutputPort = createSellerCommissionOutputPort;
        this.sellerCommissionMapper = sellerCommissionMapper;
        this.getSellerCommission = getSellerCommission;
    }

    @Override
    public SellerCommission createSellerCommission(SellOperation sellOperation) {
        Optional<SellerCommission> optionalSellerCommission = getSellerCommission.getLastSellerCommissionBySellerId(sellOperation.getSellerId());
        Float oldTotal = optionalSellerCommission.isPresent() ? optionalSellerCommission.get().getTotal() : 0f;
        //validate if exist a previous seller commission by seller if, if not, validate if exist seller, if not, throws
        CreateSellerCommissionRequest sellerCommissionRequest = new CreateSellerCommissionRequest(
                sellOperation.getId(),
                oldTotal + sellOperation.getSellerProfit(),
                sellOperation.getSellerProfit(),
                sellOperation.getSellerProfit() / sellOperation.getQuantity(),
                sellOperation.getQuantity(),
                sellOperation.getSellerId(),
                SellerCommissionStatus.PENDING.value());
        SellerCommission sellerCommission = sellerCommissionMapper.toSellerCommissionModel(sellerCommissionRequest);
        return createSellerCommissionOutputPort.createSellerCommission(sellerCommission);
    }
}
