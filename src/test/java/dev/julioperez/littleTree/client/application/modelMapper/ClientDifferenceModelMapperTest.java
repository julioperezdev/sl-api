package dev.julioperez.littleTree.client.application.modelMapper;

import dev.julioperez.littleTree.client.clientDifference.application.modelMapper.ClientDifferenceModelMapper;
import dev.julioperez.littleTree.client.clientDifference.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.clientDifference.domain.dto.UpdateClientDifferenceRequest;
import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.clientDifference.infrastructure.repository.entity.ClientDifferenceEntity;
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
class ClientDifferenceModelMapperTest {

    @InjectMocks
    ClientDifferenceModelMapper clientDifferenceMapper;

    @Nested
    public class toClientDifferenceModelCases{
        @Test
        void itShouldMapToClientDifferenceModelByCreateClientDifferenceRequestHappyCase(){
            //given
            CreateClientDifferenceRequest input = new CreateClientDifferenceRequest(
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    5000f,
                    "Se le queda en la casa",
                    "sobra");
            //when
            ClientDifference clientDifference = clientDifferenceMapper.toClientDifferenceModel(input);
            //then
            assertNotNull(clientDifference);
            assertNotNull(clientDifference.getClientId());

            assertEquals(input.clientId(), clientDifference.getClientId());
            assertEquals(input.amount(), clientDifference.getAmount());
            assertEquals(input.description(), clientDifference.getDescription());
            assertEquals(input.differenceType(), clientDifference.getDifferenceType());
        }
        @Test
        void itShouldMapToClientDifferenceModelByUpdateClientDifferenceRequestHappyCase(){
            //given
            String clientDifferenceId = UUID.randomUUID().toString();
            UpdateClientDifferenceRequest updateClientDifference = new UpdateClientDifferenceRequest(
                    clientDifferenceId,
                    3500f,
                    "Se le queda en la casa",
                    "falta",
                    "resuelto");
            ClientDifference clientDifference = new ClientDifference(
                    clientDifferenceId,
                    Date.from(Instant.now()),
                    Date.from(Instant.now()),
                    UUID.randomUUID().toString(),
                    5000f,
                    "Se le queda en la casa",
                    "sobra",
                    "pendiente");
            //when
            ClientDifference clientDifferenceToUpdate = clientDifferenceMapper.toClientDifferenceModel(clientDifference, updateClientDifference);
            //then
            assertNotNull(clientDifferenceToUpdate);
            assertNotNull(clientDifferenceToUpdate.getClientId());

            assertEquals(updateClientDifference.id(), clientDifferenceToUpdate.getId());
            assertEquals(updateClientDifference.amount(), clientDifferenceToUpdate.getAmount());
            assertEquals(updateClientDifference.description(), clientDifferenceToUpdate.getDescription());
            assertEquals(updateClientDifference.differenceType(), clientDifferenceToUpdate.getDifferenceType());
            assertEquals(updateClientDifference.differenceStatus(), clientDifferenceToUpdate.getDifferenceStatus());
        }
        @Test
        void itShouldMapToClientDifferenceModelByClientDifferenceEntityRequestHappyCase(){
            //given
            ClientDifferenceEntity clientDifferenceEntity = new ClientDifferenceEntity(
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    5000f,
                    "Se le queda en la casa",
                    "sobra",
                    "pendiente",
                    Date.from(Instant.now()),
                    Date.from(Instant.now()));
            //when
            ClientDifference clientDifference = clientDifferenceMapper.toClientDifferenceModel(clientDifferenceEntity);
            //then
            assertNotNull(clientDifference);
            assertNotNull(clientDifference.getClientId());

            assertEquals(clientDifferenceEntity.getId(), clientDifference.getId());
            assertEquals(clientDifferenceEntity.getAmount(), clientDifference.getAmount());
            assertEquals(clientDifferenceEntity.getDescription(), clientDifference.getDescription());
            assertEquals(clientDifferenceEntity.getDifferenceType(), clientDifference.getDifferenceType());
            assertEquals(clientDifferenceEntity.getDifferenceStatus(), clientDifference.getDifferenceStatus());
        }
        @Test
        void itShouldMapToClientDifferenceModelListByClientDifferenceEntityListRequestHappyCase(){
            //given
            ClientDifferenceEntity clientDifferenceEntityA = new ClientDifferenceEntity(
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    5000f,
                    "Se le queda en la casa",
                    "sobra",
                    "pendiente",
                    Date.from(Instant.now()),
                    Date.from(Instant.now()));
            ClientDifferenceEntity clientDifferenceEntityB = new ClientDifferenceEntity(
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    1500f,
                    "Se ha equivocado en la operacion",
                    "sobra",
                    "resuelto",
                    Date.from(Instant.now()),
                    Date.from(Instant.now()));
            List<ClientDifferenceEntity> clientDifferenceEntities = List.of(clientDifferenceEntityA, clientDifferenceEntityB);
            //when
            List<ClientDifference> clientDifferences = clientDifferenceMapper.toClientDifferencesModel(clientDifferenceEntities);
            //then
            assertNotNull(clientDifferences);
            assertFalse(clientDifferences.isEmpty());
            assertEquals(2, clientDifferences.size());

            assertEquals(clientDifferences.get(0).getId(), clientDifferenceEntityA.getId());
            assertEquals(clientDifferences.get(1).getId(), clientDifferenceEntityB.getId());
        }

    }
    @Nested
    public class toClientDifferenceEntityCases{
        @Test
        void itShouldMapToClientDifferenceEntityByClientDifferenceModelHappyCase(){
            //given
            ClientDifference clientDifference = new ClientDifference(
                    UUID.randomUUID().toString(),
                    Date.from(Instant.now()),
                    Date.from(Instant.now()),
                    UUID.randomUUID().toString(),
                    5000f,
                    "Se le queda en la casa",
                    "sobra",
                    "pendiente");
            //when
            ClientDifferenceEntity clientDifferenceEntity = clientDifferenceMapper.toClientDifferenceEntity(clientDifference);
            //then
            assertNotNull(clientDifferenceEntity);
            assertNotNull(clientDifferenceEntity.getClientId());

            assertEquals(clientDifference.getId(), clientDifferenceEntity.getId());
            assertEquals(clientDifference.getAmount(), clientDifferenceEntity.getAmount());
            assertEquals(clientDifference.getDescription(), clientDifferenceEntity.getDescription());
            assertEquals(clientDifference.getDifferenceType(), clientDifferenceEntity.getDifferenceType());
            assertEquals(clientDifference.getDifferenceStatus(), clientDifferenceEntity.getDifferenceStatus());
        }
    }

}