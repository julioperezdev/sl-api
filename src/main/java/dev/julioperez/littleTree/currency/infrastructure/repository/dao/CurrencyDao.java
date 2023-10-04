package dev.julioperez.littleTree.currency.infrastructure.repository.dao;

import dev.julioperez.littleTree.currency.infrastructure.repository.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyDao extends JpaRepository<CurrencyEntity,String> {

    @Query(value = "SELECT DISTINCT ON(NAME) NAME, ID, BUY_PRICE, SELL_PRICE, UPDATED_AT FROM SL.CURRENCY WHERE UPDATED_AT IS NOT NULL ORDER BY NAME, UPDATED_AT desc", nativeQuery = true)
    List<CurrencyEntity> findLastUpdatedCurrencies();

    @Query(value = "SELECT DISTINCT ON(NAME) NAME, ID, BUY_PRICE, SELL_PRICE, UPDATED_AT FROM SL.CURRENCY WHERE UPDATED_AT IS NOT NULL AND NAME = :name ORDER BY NAME, UPDATED_AT desc", nativeQuery = true)
    Optional<CurrencyEntity> getLastUpdatedByName(@Param("name") String name);
}
