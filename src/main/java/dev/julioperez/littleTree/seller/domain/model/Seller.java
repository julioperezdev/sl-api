package dev.julioperez.littleTree.seller.domain.model;

public final class Seller {
    private final SellerId id;
    private final SellerName name;
    private final SellerPhone phone;

    public Seller(SellerId id, SellerName name, SellerPhone phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
