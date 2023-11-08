package dev.julioperez.littleTree.box.balance.infrastructure.repository.dao;

import dev.julioperez.littleTree.box.balance.infrastructure.repository.entity.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BalanceDao extends JpaRepository<BalanceEntity,String> {
    @Query(value = "SELECT * FROM SL.balance ORDER BY updated_at DESC limit 1", nativeQuery = true)
    Optional<BalanceEntity> getLastBalance();
}
