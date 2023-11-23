package dev.julioperez.littleTree.box.sellerbox.application.assignSellerBox.service;

import dev.julioperez.littleTree.box.balance.domain.dto.AssignSellerBoxRequest;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.assignSellerBox.AssignSellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.getSellerBox.GetSellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.saveSellerBox.SaveSellerBox;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.time.Instant;
import java.util.Comparator;
import java.util.Optional;
import java.util.UUID;

public class AssignSellerBoxService implements AssignSellerBox {
    private final GetSellerBox getSellerBox;
    private final SaveSellerBox saveSellerBox;

    public AssignSellerBoxService(GetSellerBox getSellerBox, SaveSellerBox saveSellerBox) {
        this.getSellerBox = getSellerBox;
        this.saveSellerBox = saveSellerBox;
    }

    @Override
    public boolean execute(AssignSellerBoxRequest assignSellerBoxRequest) {
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
        saveSellerBox.execute(newSellerBox);
        //validate if saved
        //manage balance to egress amount assigned of seller box
        //todo: think how manage the state of each step to finalize ok, otherwise need return money
        return true;
    }

    private Optional<SellerBox> getLastSellerBoxByName(AssignSellerBoxRequest assignSellerBoxRequest){
        return Optional.ofNullable(getSellerBox.getLastSellerBoxByName(assignSellerBoxRequest.sellerBoxName()));

    }
}
