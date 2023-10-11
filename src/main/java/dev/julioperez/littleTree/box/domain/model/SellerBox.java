package dev.julioperez.littleTree.box.domain.model;


import dev.julioperez.littleTree.box.domain.enums.SellerBoxNames;

import java.util.Date;

import static dev.julioperez.littleTree.box.domain.enums.SellerBoxNames.returnSellerBoxNamesByValue;

public final class SellerBox {

    private final SellerBoxId id;
    private final BalanceId balanceId;
    private final SellerBoxNames name;
    private final SellerBoxDescription description;
    private final SellerBoxCreatedAt createdAt;
    private final SellerBoxUpdatedAt updatedAt;

    public SellerBox(String id, String balanceId,String name, String description, Date createdAt, Date updatedAt) {
        this.id = new SellerBoxId(id);
        this.balanceId = new BalanceId(balanceId);
        this.name = returnSellerBoxNamesByValue(name);
        this.description = new SellerBoxDescription(description);
        this.createdAt = new SellerBoxCreatedAt(createdAt);
        this.updatedAt = new SellerBoxUpdatedAt(updatedAt);
    }

    public String getId() {
        return id.value();
    }

    public String getBalanceId() {
        return balanceId.value();
    }
    public String getName(){
        return name.value();
    }
    public String getDescription(){
        return description.value();
    }
    public Date getCreatedAt(){
        return createdAt.value();
    }
    public Date getUpdatedAt(){
        return updatedAt.value();
    }
}
