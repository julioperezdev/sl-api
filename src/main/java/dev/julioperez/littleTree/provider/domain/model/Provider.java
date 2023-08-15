package dev.julioperez.littleTree.provider.domain.model;


import java.util.Date;

public final class Provider {

    private final ProviderId id;
    private final ProviderName name;
    private final ProviderPhone phone;
    private final ProviderAddress address;
    private final ProviderCreatedAt createdAt;

    public Provider(String id, String name, String phone, String address, Date createdAt) {
        this.id = new ProviderId(id);
        this.name = new ProviderName(name);
        this.phone = new ProviderPhone(phone);
        this.address = new ProviderAddress(address);
        this.createdAt = new ProviderCreatedAt(createdAt);
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
}
