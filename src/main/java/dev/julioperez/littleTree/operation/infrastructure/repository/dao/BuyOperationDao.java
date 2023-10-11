package dev.julioperez.littleTree.operation.infrastructure.repository.dao;

import dev.julioperez.littleTree.operation.infrastructure.repository.entity.BuyOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyOperationDao extends JpaRepository<BuyOperationEntity, String> {

    List<BuyOperationEntity> getAllByOperationStatus(String operationStatus);
}
