package dev.julioperez.littleTree.seller.application.modelMapper;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.dto.UpdateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerCommissionMapper;
import dev.julioperez.littleTree.seller.infrastructure.repository.entity.SellerCommissionEntity;

import java.util.List;
import java.util.UUID;

public class SellerCommissionModelMapper implements SellerCommissionMapper {

    @Override
    public SellerCommission toSellerCommissionModel(CreateSellerCommissionRequest createSellerCommissionRequest) {
        return new SellerCommission(
                UUID.randomUUID().toString(),
                createSellerCommissionRequest.pesos(),
                createSellerCommissionRequest.quantity(),
                createSellerCommissionRequest.profit(),
                createSellerCommissionRequest.sellerId(),
                createSellerCommissionRequest.sellerCommissionStatus());
    }

    @Override
    public SellerCommission toSellerCommissionModel(SellerCommission sellerCommission, UpdateSellerCommissionRequest updateSellerCommissionRequest) {
        return new SellerCommission(
                sellerCommission.getId(),
                sellerCommission.getPesos(),
                sellerCommission.getQuantity(),
                sellerCommission.getProfit(),
                sellerCommission.getSellerId(),
                updateSellerCommissionRequest.sellerCommissionStatus());
    }

    @Override
    public SellerCommission toSellerCommissionModel(SellerCommissionEntity sellerCommissionEntity) {
        return new SellerCommission(
                sellerCommissionEntity.getId(),
                sellerCommissionEntity.getPesos(),
                sellerCommissionEntity.getQuantity(),
                sellerCommissionEntity.getProfit(),
                sellerCommissionEntity.getSellerId(),
                sellerCommissionEntity.getSellerCommissionStatus());
    }

    @Override
    public List<SellerCommission> toSellerCommissionsModel(List<SellerCommissionEntity> sellerCommissionEntities) {
        return sellerCommissionEntities.stream().map(this::toSellerCommissionModel).toList();
    }

    @Override
    public SellerCommissionEntity toSellerCommissionEntity(SellerCommission sellerCommission) {
        return new SellerCommissionEntity(
                sellerCommission.getId(),
                sellerCommission.getSellerId(),
                sellerCommission.getSellerCommissionStatus(),
                sellerCommission.getPesos(),
                sellerCommission.getQuantity(),
                sellerCommission.getProfit());
    }
}
