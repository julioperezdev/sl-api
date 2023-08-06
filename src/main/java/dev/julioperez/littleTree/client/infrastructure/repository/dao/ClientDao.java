package dev.julioperez.littleTree.client.infrastructure.repository.dao;

import dev.julioperez.littleTree.client.infrastructure.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity,String> {
    Optional<ClientEntity> getClientByPhone(String phone);
}
