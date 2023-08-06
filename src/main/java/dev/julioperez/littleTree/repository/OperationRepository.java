package dev.julioperez.littleTree.repository;

import dev.julioperez.littleTree.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation,String> {
}
