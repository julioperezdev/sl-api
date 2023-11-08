package dev.julioperez.littleTree.box.sellerbox.application.manageSellerBox.service;

import dev.julioperez.littleTree.box.balance.domain.dto.AssignSellerBoxRequest;
import dev.julioperez.littleTree.box.balance.domain.model.BalanceId;
import dev.julioperez.littleTree.box.sellerbox.domain.enums.SellerBoxNames;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.manageSellerBox.ManageSellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.manageSellerBox.ManageSellerBoxOutputPort;
import dev.julioperez.littleTree.operation.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ManageSellerBoxService implements ManageSellerBox {
    private final ManageSellerBoxOutputPort manageSellerBoxOutputPort;

    public ManageSellerBoxService(ManageSellerBoxOutputPort manageSellerBoxOutputPort) {
        this.manageSellerBoxOutputPort = manageSellerBoxOutputPort;
    }

    @Override
    public SellerBox saveSellerBox(SellerBox newSellerBox){
        return manageSellerBoxOutputPort.saveOrUpdateSellerBox(newSellerBox);
    }

    @Override
    public SellerBox getLastSellerBoxByName(String name) {
        SellerBoxNames sellerBoxNames = SellerBoxNames.returnSellerBoxNamesByValue(name);
        return manageSellerBoxOutputPort.getLastSellerBoxByName(sellerBoxNames);
    }

    @Override
    public List<SellerBox> getSellerBoxByNameOrdered(String name) {
        return manageSellerBoxOutputPort.getSellerBox()
                .stream()
                .filter(particular -> particular.getName().equals(name))
                .sorted(Comparator.comparing(SellerBox::getUpdatedAt).reversed())
                .toList();
    }

    private Optional<SellerBox> getLastSellerBoxByName(AssignSellerBoxRequest assignSellerBoxRequest){
        return manageSellerBoxOutputPort.getSellerBox()
                .stream()
                .filter(particular -> particular.getName().equals(assignSellerBoxRequest.sellerBoxName()))
                .max(Comparator.comparing(SellerBox::getUpdatedAt));
    }
    @Override
    public Boolean assignSellerBox(AssignSellerBoxRequest assignSellerBoxRequest) {
        Optional<SellerBox> lastSellerBoxByName = getLastSellerBoxByName(assignSellerBoxRequest);
        boolean isPresent = lastSellerBoxByName.isPresent();
        Float actualQuantity = isPresent ? lastSellerBoxByName.get().getQuantity() : 0f;
        Float newQuantity = actualQuantity + assignSellerBoxRequest.quantity();
        SellerBox newSellerBox = new SellerBox(
                UUID.randomUUID().toString(),
                newQuantity,
                assignSellerBoxRequest.quantity(),
                assignSellerBoxRequest.sellerBoxName(),
                OperationType.ASSIGN_BOX.value(),
                java.util.Date.from(Instant.now()),
                java.util.Date.from(Instant.now()));
        manageSellerBoxOutputPort.saveOrUpdateSellerBox(newSellerBox);
        //validate if saved
        //manage balance to egress amount assigned of seller box
        //todo: think how manage the state of each step to finalize ok, otherwise need return money
        return true;
    }
}
