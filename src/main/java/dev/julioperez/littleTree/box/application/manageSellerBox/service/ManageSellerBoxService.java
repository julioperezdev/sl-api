package dev.julioperez.littleTree.box.application.manageSellerBox.service;

import dev.julioperez.littleTree.box.application.manageSellerBox.adapter.ManageSellerBoxAdapterRepository;
import dev.julioperez.littleTree.box.domain.model.Balance;
import dev.julioperez.littleTree.box.domain.model.BalanceId;
import dev.julioperez.littleTree.box.domain.model.SellerBox;
import dev.julioperez.littleTree.box.domain.port.manageSellerBox.ManageSellerBox;
import dev.julioperez.littleTree.box.domain.port.manageSellerBox.ManageSellerBoxOutputPort;

import java.sql.Date;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class ManageSellerBoxService implements ManageSellerBox {
    private final ManageSellerBoxOutputPort manageSellerBoxOutputPort;

    public ManageSellerBoxService(ManageSellerBoxOutputPort manageSellerBoxOutputPort) {
        this.manageSellerBoxOutputPort = manageSellerBoxOutputPort;
    }


    public SellerBox asignSellerBox(BalanceId balanceId){
        //aca falta a cual de las cajas corresponde la ganancia
        //hay que agregarlo en el entity, model, en everything
        SellerBox sellerBox = new SellerBox(UUID.randomUUID().toString(), balanceId.value(),"", "", Date.from(Instant.now()), Date.from(Instant.now()));
        return manageSellerBoxOutputPort.saveOrUpdateSellerBox(sellerBox);
    }

    @Override
    public List<SellerBox> getSellerBoxByNameOrdered(String name) {
        return manageSellerBoxOutputPort.getSellerBox()
                .stream()
                .filter(particular -> particular.getName().equals(name))
                .sorted(Comparator.comparing(SellerBox::getUpdatedAt).reversed())
                .toList();
    }
}
