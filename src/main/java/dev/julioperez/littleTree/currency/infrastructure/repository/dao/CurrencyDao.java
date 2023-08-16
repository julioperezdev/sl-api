package dev.julioperez.littleTree.currency.infrastructure.repository.dao;

import dev.julioperez.littleTree.currency.infrastructure.repository.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyDao extends JpaRepository<CurrencyEntity,String> {

    @Query(value = "SELECT DISTINCT ON(NAME) NAME, ID, BUY_PRICE, SELL_PRICE, UPDATE_AT FROM CURRENCY WHERE UPDATE_AT IS NOT NULL ORDER BY NAME, UPDATE_AT desc", nativeQuery = true)
    List<CurrencyEntity> findLastUpdatedCurrencies();
}
