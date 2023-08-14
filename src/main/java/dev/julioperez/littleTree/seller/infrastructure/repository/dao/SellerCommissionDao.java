package dev.julioperez.littleTree.seller.infrastructure.repository.dao;

import dev.julioperez.littleTree.seller.infrastructure.repository.entity.SellerCommissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerCommissionDao extends JpaRepository<SellerCommissionEntity, String> {
}
