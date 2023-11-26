package dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.dao;

import dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.entity.CurrencyMultiBoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyMultiBoxDao extends JpaRepository<CurrencyMultiBoxEntity,String> {
    @Query(value = "SELECT DISTINCT ON (CURRENCY_BOX) * from SL.MULTIBOX where CURRENCY_BOX in(:currencyBoxParam) order by CURRENCY_BOX, UPDATED_AT DESC ;", nativeQuery = true)
    Optional<List<CurrencyMultiBoxEntity>> getDistinctByCurrencyBoxInOrderByUpdatedAtDesc(@Param("currencyBoxParam") Collection<String> currencyBoxParam);
    @Query(value = "SELECT DISTINCT ON (operation_id) * FROM SL.MULTIBOX WHERE currency_box = :currencyBoxParam ORDER BY operation_id , UPDATED_AT desc;", nativeQuery = true)
    Optional<List<CurrencyMultiBoxEntity>> getCurrencyMultiBoxByLastStatus(@Param("currencyBoxParam") String currencyBoxParam);
    Optional<List<CurrencyMultiBoxEntity>> getCurrencyMultiBoxEntitiesByCurrencyBoxOrderByUpdatedAtDesc(String currencyBox);
    Optional<List<CurrencyMultiBoxEntity>> getByOperationId(String operationId);
    Optional<CurrencyMultiBoxEntity> getFirstByCurrencyBoxOrderByUpdatedAtDesc(String currencyBox);
    Optional<CurrencyMultiBoxEntity> getFirstByCurrencyBoxAndMultiBoxStatusOrderByUpdatedAtDesc(String currencyBox, String multiboxStatus);
}
