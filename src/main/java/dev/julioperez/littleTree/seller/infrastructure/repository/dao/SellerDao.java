package dev.julioperez.littleTree.seller.infrastructure.repository.dao;

import dev.julioperez.littleTree.seller.infrastructure.repository.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerDao extends JpaRepository<SellerEntity, String> {
}
