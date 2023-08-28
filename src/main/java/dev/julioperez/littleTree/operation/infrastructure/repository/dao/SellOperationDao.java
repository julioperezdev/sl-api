package dev.julioperez.littleTree.operation.infrastructure.repository.dao;

import dev.julioperez.littleTree.operation.infrastructure.repository.entity.SellOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellOperationDao extends JpaRepository<SellOperationEntity, String> {
}
