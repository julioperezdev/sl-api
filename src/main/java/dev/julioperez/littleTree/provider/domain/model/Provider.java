package dev.julioperez.littleTree.provider.domain.model;


import java.util.Date;

public final class Provider {

    private final ProviderId id;
    private final ProviderName name;
    private final ProviderPhone phone;
    private final ProviderAddress address;
    private final ProviderCreatedAt createdAt;
    private final ProviderUpdatedAt updatedAt;

    public Provider(String id, String name, String phone, String address, Date createdAt, Date updatedAt) {
        this.id = new ProviderId(id);
        this.name = new ProviderName(name);
        this.phone = new ProviderPhone(phone);
        this.address = new ProviderAddress(address);
        this.createdAt = new ProviderCreatedAt(createdAt);
        this.updatedAt = new ProviderUpdatedAt(updatedAt);
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

    public Date getCreatedAt() {
        return createdAt.value();
    }
    public Date getUpdatedAt() {
        return updatedAt.value();
    }
}