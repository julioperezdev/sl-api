package dev.julioperez.littleTree.seller.domain.model;

import java.util.Date;

public final class Seller {
    private final SellerId id;
    private final SellerName name;
    private final SellerPhone phone;
    private final SellerDescription description;
    private final SellerCreatedAt createdAt;

    public Seller(String id, String name, String phone, String description, Date createdAt) {
        this.id = new SellerId(id);
        this.name = new SellerName(name);
        this.phone = new SellerPhone(phone);
        this.description = new SellerDescription(description);
        this.createdAt = new SellerCreatedAt(createdAt);
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
    public String getDescription() {
        return description.value();
    }
    public Date getCreatedAt() {
        return createdAt.value();
    }
}
