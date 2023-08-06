package dev.julioperez.littleTree.box.domain.model;


public final class SellerBox {

    private final SellerBoxId id;
    private final BalanceId balanceId;

    public SellerBox(SellerBoxId id, BalanceId balanceId) {
        this.id = id;
        this.balanceId = balanceId;
    }
}
