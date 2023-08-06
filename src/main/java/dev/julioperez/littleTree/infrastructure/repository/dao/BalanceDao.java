package dev.julioperez.littleTree.infrastructure.repository.dao;

import dev.julioperez.littleTree.infrastructure.repository.entity.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceDao extends JpaRepository<BalanceEntity,String> {
}
