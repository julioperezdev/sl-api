package dev.julioperez.littleTree.repository;

import dev.julioperez.littleTree.model.CurrencyMultiBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultiBoxRepository extends JpaRepository<CurrencyMultiBox,String> {
}
