package dev.julioperez.littleTree.repository;

import dev.julioperez.littleTree.model.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationTypeRepository extends JpaRepository<OperationType,String> {
}
