package dev.julioperez.littleTree.seller.domain.model;

public final class Seller {
    private final SellerId id;
    private final SellerName name;
    private final SellerPhone phone;

    public Seller(String id, String name, String phone) {
        this.id = new SellerId(id);
        this.name = new SellerName(name);
        this.phone = new SellerPhone(phone);
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
}
