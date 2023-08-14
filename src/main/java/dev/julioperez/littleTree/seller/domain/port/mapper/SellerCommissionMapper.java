package dev.julioperez.littleTree.seller.domain.port.mapper;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.dto.CreateSellerRequest;
import dev.julioperez.littleTree.seller.domain.dto.UpdateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.dto.UpdateSellerRequest;
import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.infrastructure.repository.entity.SellerCommissionEntity;
import dev.julioperez.littleTree.seller.infrastructure.repository.entity.SellerEntity;

import java.util.List;

public interface SellerCommissionMapper {
    SellerCommission toSellerCommissionModel(CreateSellerCommissionRequest createSellerCommissionRequest);
    SellerCommission toSellerCommissionModel(SellerCommission sellerCommission, UpdateSellerCommissionRequest updateSellerCommissionRequest);
    SellerCommission toSellerCommissionModel(SellerCommissionEntity sellerCommissionEntity);
    List<SellerCommission> toSellerCommissionsModel(List<SellerCommissionEntity> sellerCommissionEntities);
    SellerCommissionEntity toSellerCommissionEntity(SellerCommission sellerCommission);
}
