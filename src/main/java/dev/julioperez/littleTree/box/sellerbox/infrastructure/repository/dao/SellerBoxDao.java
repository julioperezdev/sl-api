package dev.julioperez.littleTree.box.sellerbox.infrastructure.repository.dao;

import dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.entity.CurrencyMultiBoxEntity;
import dev.julioperez.littleTree.box.sellerbox.infrastructure.repository.entity.SellerBoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerBoxDao extends JpaRepository<SellerBoxEntity, String> {

    Optional<SellerBoxEntity> getFirstByNameOrderByUpdatedAtDesc(String name);

}
