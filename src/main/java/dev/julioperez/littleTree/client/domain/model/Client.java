package dev.julioperez.littleTree.client.domain.model;


import java.util.Date;

public final class Client {

    private final ClientId id;
    private final ClientName name;
    private final ClientPhone phone;
    private final ClientAddress address;
    private final ClientDescription description;
    private final ClientCreatedAt createdAt;

    public Client(String id, String name, String phone, String address, String description, Date createdAt) {
        this.id = new ClientId(id);
        this.name = new ClientName(name);
        this.phone = new ClientPhone(phone);
        this.address = new ClientAddress(address);
        this.description = new ClientDescription(description);
        this.createdAt = new ClientCreatedAt(createdAt);
    }

    public String getId() {
        return id.value();
    }

    public String getName() {
        return name.value();
    }

    public String getPhone() {
        return phone.value();
    }

    public String getAddress() {
        return address.value();
    }

    public String getDescription() {
        return description.value();
    }

    public Date getCreatedAt() {
        return createdAt.value();
    }
}
