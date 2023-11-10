package dev.julioperez.littleTree.seller.sellerCommission.domain.port.mapper;

import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.UpdateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.infrastructure.repository.entity.SellerCommissionEntity;

import java.util.List;

public interface SellerCommissionMapper {
    SellerCommission toSellerCommissionModel(CreateSellerCommissionRequest createSellerCommissionRequest);
    SellerCommission toSellerCommissionModel(SellerCommission sellerCommission, UpdateSellerCommissionRequest updateSellerCommissionRequest);
    SellerCommission toSellerCommissionModel(SellerCommissionEntity sellerCommissionEntity);
    List<SellerCommission> toSellerCommissionsModel(List<SellerCommissionEntity> sellerCommissionEntities);
    SellerCommissionEntity toSellerCommissionEntity(SellerCommission sellerCommission);
}
