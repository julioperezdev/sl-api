package dev.julioperez.littleTree.infrastructure.repository.dao;

import dev.julioperez.littleTree.infrastructure.repository.entity.CurrencyMultiBoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyMultiBoxDao extends JpaRepository<CurrencyMultiBoxEntity,String> {
}
