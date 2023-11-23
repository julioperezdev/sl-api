package dev.julioperez.littleTree.box.sellerbox.application.getSellerBox.service;

import dev.julioperez.littleTree.box.sellerbox.domain.enums.SellerBoxNames;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.getSellerBox.GetSellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.getSellerBox.GetSellerBoxOutputPort;

import java.util.Comparator;
import java.util.List;

public class GetSellerBoxService implements GetSellerBox {
    private final GetSellerBoxOutputPort getSellerBoxOutputPort;

    public GetSellerBoxService(GetSellerBoxOutputPort getSellerBoxOutputPort) {
        this.getSellerBoxOutputPort = getSellerBoxOutputPort;
    }

    @Override
    public List<SellerBox> getSellerBox() {
        return getSellerBoxOutputPort.getSellerBox();
    }

    @Override
    public SellerBox getLastSellerBoxByName(String name) {
        SellerBoxNames sellerBoxNames = SellerBoxNames.returnSellerBoxNamesByValue(name);
        return getSellerBoxOutputPort.getLastSellerBoxByName(sellerBoxNames);
    }

    @Override
    public List<SellerBox> getSellerBoxByNameOrdered(String name) {
        return getSellerBoxOutputPort.getSellerBox()
                .stream()
                .filter(particular -> particular.getName().equals(name))
                .sorted(Comparator.comparing(SellerBox::getUpdatedAt).reversed())
                .toList();
    }
}
