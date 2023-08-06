package dev.julioperez.littleTree.client.domain.model;


public final class Client {

    private final ClientId id;
    private final ClientName name;
    private final ClientPhone phone;
    private final ClientAddress address;
    private final ClientDescription description;
    private final ClientCreatedAt createdAt;

    public Client(ClientId id, ClientName name, ClientPhone phone, ClientAddress address, ClientDescription description, ClientCreatedAt createdAt) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.description = description;
        this.createdAt = createdAt;
    }
}
