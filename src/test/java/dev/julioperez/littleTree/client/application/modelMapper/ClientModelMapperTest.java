package dev.julioperez.littleTree.client.application.modelMapper;

import dev.julioperez.littleTree.client.client.application.modelMapper.ClientModelMapper;
import dev.julioperez.littleTree.client.client.domain.dto.CreateClientRequest;
import dev.julioperez.littleTree.client.client.domain.dto.UpdateClientRequest;
import dev.julioperez.littleTree.client.client.domain.model.Client;
import dev.julioperez.littleTree.client.client.infrastructure.repository.entity.ClientEntity;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientModelMapperTest {
    @InjectMocks
    ClientModelMapper clientMapper;

    @Nested
    public class toClientModelCases{
        @Test
        void itShouldMapToClientModelByCreateClientRequestHappyCase(){
            //given
            CreateClientRequest input = new CreateClientRequest(
                    "Pedro",
                    "1159232222",
                    "Corrientes 72, CABA",
                    "Suele venir solo",
                    "description");
            //when
            Client client = clientMapper.toClientModel(input);
            //then
            assertNotNull(client);
            assertNotNull(client.getId());
            assertNotNull(client.getCreatedAt());
            assertEquals(input.name(), client.getName());
            assertEquals(input.address(), client.getAddress());
            assertEquals(input.phone(), client.getPhone());
            assertEquals(input.description(), client.getDescription());
        }
        @Test
        void itShouldMapToClientModelByUpdateClientRequestHappyCase(){
            //given
            String id = UUID.randomUUID().toString();
            UpdateClientRequest updateClient = new UpdateClientRequest(
                    id,
                    "1159232222",
                    "Rivadavia 22000, Moron",
                    "Viene con mucha gente");
            Client oldClient = new Client(
                    id,
                    "Pedro",
                    "1159232222",
                    "Corrientes 72, CABA",
                    "Suele venir solo",
                    Date.from(Instant.now()),
                    Date.from(Instant.now()));
            //when
            Client client = clientMapper.toClientModel(oldClient, updateClient);
            //then
            assertNotNull(client);
            assertNotNull(client.getId());
            assertNotNull(client.getCreatedAt());

            assertNotEquals(updateClient.address(),oldClient.getAddress());
            assertNotEquals(updateClient.description(),oldClient.getDescription());

            assertEquals(updateClient.id(), client.getId());
            assertEquals(updateClient.phone(), client.getPhone());
            assertNotNull(client.getAddress());
            assertEquals(updateClient.address(),client.getAddress());
            assertNotNull(client.getDescription());
        }
        @Test
        void itShouldMapToClientModelListByClientEntityListHappyCase(){
            //given
            ClientEntity clientEntityA = new ClientEntity(
                    UUID.randomUUID().toString(),
                    "Pedro",
                    "1159232222",
                    "Rivadavia 22000, Moron",
                    "Viene con mucha gente",
                    Date.from(Instant.now()),
                    Date.from(Instant.now()));
            ClientEntity clientEntityB = new ClientEntity(
                    UUID.randomUUID().toString(),
                    "Pedro",
                    "1187747711",
                    "Corrientes 444, CABA",
                    "Esta solo",
                    Date.from(Instant.now()),
                    Date.from(Instant.now()));
            List<ClientEntity> clientEntities = List.of(clientEntityA, clientEntityB);
            //when
            List<Client> clients = clientMapper.toClientsModel(clientEntities);
            //then
            assertNotNull(clients);
            assertFalse(clients.isEmpty());
            assertEquals(2, clients.size());

            assertEquals(clients.get(0).getId(), clientEntityA.getId());
            assertEquals(clients.get(1).getId(), clientEntityB.getId());
        }
        @Test
        void itShouldNotMapToClientModelByCreateClientRequestBecauseNameWithNumber(){
            //given
            CreateClientRequest input = new CreateClientRequest(
                    "Pedro1",
                    "1159232222",
                    "Corrientes 72, CABA",
                    "Suele venir solo",
                    "description");
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> clientMapper.toClientModel(input));
        }
        @Test
        void itShouldNotMapToClientModelByCreateClientRequestBecausePhoneWithSpace(){
            //given
            CreateClientRequest input = new CreateClientRequest(
                    "Pedro",
                    "11 59232222",
                    "Corrientes 72, CABA",
                    "Suele venir solo",
                    "description");
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> clientMapper.toClientModel(input));
        }
        @Test
        void itShouldNotMapToClientModelByCreateClientRequestBecausePhoneWithLetter(){
            //given
            CreateClientRequest input = new CreateClientRequest(
                    "Pedro",
                    "a1159232222",
                    "Corrientes 72, CABA",
                    "Suele venir solo",
                    "description");
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> clientMapper.toClientModel(input));
        }
    }

    @Nested
    public class toClientEntityCases{
        @Test
        void itShouldMapToClientEntityByClientModelHappyCase(){
            //given
            Client client = new Client(
                    UUID.randomUUID().toString(),
                    "Pedro",
                    "1159232222",
                    "Corrientes 72, CABA",
                    "Suele venir solo",
                    Date.from(Instant.now()),
                    Date.from(Instant.now()));
            //when
            ClientEntity clientEntity = clientMapper.toClientEntity(client);
            //then
            assertNotNull(clientEntity);
            assertEquals(client.getId(), clientEntity.getId());
            assertEquals(client.getName(), clientEntity.getName());
            assertEquals(client.getPhone(), clientEntity.getPhone());
            assertEquals(client.getAddress(), clientEntity.getAddress());
            assertEquals(client.getDescription(), clientEntity.getDescription());
            assertEquals(client.getCreatedAt(), clientEntity.getCreatedAt());
        }
    }
}