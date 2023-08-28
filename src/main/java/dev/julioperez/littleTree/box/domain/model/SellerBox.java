package dev.julioperez.littleTree.box.domain.model;


public final class SellerBox {

    private final SellerBoxId id;
    private final BalanceId balanceId;

    public SellerBox(String id, String balanceId) {
        this.id = new SellerBoxId(id);
        this.balanceId = new BalanceId(balanceId);
    }

    public String getId() {
        return id.value();
    }

    public String getBalanceId() {
        return balanceId.value();
    }
}
