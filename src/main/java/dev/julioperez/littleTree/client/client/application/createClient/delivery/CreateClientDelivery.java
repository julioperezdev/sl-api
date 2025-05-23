package dev.julioperez.littleTree.client.client.application.createClient.delivery;

import dev.julioperez.littleTree.client.client.domain.dto.CreateClientRequest;
import dev.julioperez.littleTree.client.client.domain.port.createClient.CreateClient;
import dev.julioperez.littleTree.client.client.domain.port.createClient.CreateClientInputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CreateClientDelivery implements CreateClientInputPort {

    private final CreateClient createClient;

    @Override
    public boolean createClient(CreateClientRequest createClientRequest) throws Exception{
        return createClient.createClient(createClientRequest);
    }
}
