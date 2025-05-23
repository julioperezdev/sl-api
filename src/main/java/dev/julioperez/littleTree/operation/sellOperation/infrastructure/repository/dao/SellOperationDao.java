package dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.dao;

import dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.entity.SellOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellOperationDao extends JpaRepository<SellOperationEntity, String> {

    List<SellOperationEntity> getAllByOperationStatus(String operationStatus);
}
