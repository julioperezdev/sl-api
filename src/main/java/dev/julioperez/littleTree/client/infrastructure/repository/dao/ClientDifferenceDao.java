package dev.julioperez.littleTree.client.infrastructure.repository.dao;

import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.infrastructure.repository.entity.ClientDifferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDifferenceDao extends JpaRepository<ClientDifferenceEntity, String> {
}
