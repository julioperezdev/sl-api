package dev.julioperez.littleTree.currency.infrastructure.repository.dao;

import dev.julioperez.littleTree.currency.infrastructure.repository.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyDao extends JpaRepository<CurrencyEntity,String> {
}
