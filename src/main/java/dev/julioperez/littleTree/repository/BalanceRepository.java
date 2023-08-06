package dev.julioperez.littleTree.repository;

import dev.julioperez.littleTree.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance,String> {
}
