package dev.julioperez.littleTree.provider.domain.model;


public final class Provider {

    private final ProviderId id;
    private final ProviderName name;
    private final ProviderPhone phone;
    private final ProviderAddress address;
    private final ProviderCreatedAt createdAt;

    public Provider(ProviderId id, ProviderName name, ProviderPhone phone, ProviderAddress address, ProviderCreatedAt createdAt) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
    }
}
