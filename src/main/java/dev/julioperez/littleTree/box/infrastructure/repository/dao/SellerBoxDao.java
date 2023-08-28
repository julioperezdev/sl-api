package dev.julioperez.littleTree.box.infrastructure.repository.dao;

import dev.julioperez.littleTree.box.domain.model.SellerBox;
import dev.julioperez.littleTree.box.infrastructure.repository.entity.SellerBoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerBoxDao extends JpaRepository<SellerBoxEntity, String> {
}
