package dev.julioperez.littleTree.operation.infrastructure.repository.dao;

import dev.julioperez.littleTree.operation.infrastructure.repository.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationDao extends JpaRepository<OperationEntity,String> {
}
