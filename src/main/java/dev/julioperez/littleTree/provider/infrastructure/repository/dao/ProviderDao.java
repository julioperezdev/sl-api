package dev.julioperez.littleTree.provider.infrastructure.repository.dao;

import dev.julioperez.littleTree.provider.infrastructure.repository.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderDao extends JpaRepository<ProviderEntity, String> {
}
