package dev.julioperez.littleTree.box.application.manageSellerBox.service;

import dev.julioperez.littleTree.box.application.manageSellerBox.adapter.ManageSellerBoxAdapterRepository;
import dev.julioperez.littleTree.box.domain.model.BalanceId;
import dev.julioperez.littleTree.box.domain.model.SellerBox;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class ManageSellerBoxService {
    private final ManageSellerBoxAdapterRepository manageSellerBoxAdapterRepository;

    public ManageSellerBoxService(ManageSellerBoxAdapterRepository manageSellerBoxAdapterRepository) {
        this.manageSellerBoxAdapterRepository = manageSellerBoxAdapterRepository;
    }

    public SellerBox asignSellerBox(BalanceId balanceId){
        //aca falta a cual de las cajas corresponde la ganancia
        //hay que agregarlo en el entity, model, en everything
        SellerBox sellerBox = new SellerBox(UUID.randomUUID().toString(), balanceId.value(),"", "", Date.from(Instant.now()), Date.from(Instant.now()));
        return manageSellerBoxAdapterRepository.saveOrUpdateSellerBox(sellerBox);
    }
}
