package dev.julioperez.littleTree.seller.application.modelMapper;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.dto.UpdateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerCommissionMapper;
import dev.julioperez.littleTree.seller.infrastructure.repository.entity.SellerCommissionEntity;

import java.util.List;

public class SellerCommissionModelMapper implements SellerCommissionMapper {

    @Override
    public SellerCommission toSellerCommissionModel(CreateSellerCommissionRequest createSellerCommissionRequest) {
        return null;
    }

    @Override
    public SellerCommission toSellerCommissionModel(SellerCommission sellerCommission, UpdateSellerCommissionRequest updateSellerCommissionRequest) {
        return null;
    }

    @Override
    public SellerCommission toSellerCommissionModel(SellerCommissionEntity sellerCommissionEntity) {
        return null;
    }

    @Override
    public List<SellerCommission> toSellerCommissionsModel(List<SellerCommissionEntity> sellerCommissionEntities) {
        return null;
    }

    @Override
    public SellerCommissionEntity toSellerCommissionEntity(SellerCommission sellerCommission) {
        return null;
    }
}
