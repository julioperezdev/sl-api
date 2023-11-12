package dev.julioperez.littleTree.seller.seller.application.getSeller.service;

import dev.julioperez.littleTree.seller.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.seller.domain.port.getSeller.GetSeller;
import dev.julioperez.littleTree.seller.seller.domain.port.getSeller.GetSellerOutputPort;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GetSellerService implements GetSeller {
    private final GetSellerOutputPort getSellerOutputPort;

    public GetSellerService(GetSellerOutputPort getSellerOutputPort) {
        this.getSellerOutputPort = getSellerOutputPort;
    }

    @Override
    public List<Seller> getSellers() {
        return getSellerOutputPort.getSellers();
    }

    @Override
    public List<String> getSellersNames() {
        return getSellers().stream().map(Seller::getName).toList();
    }

    @Override
    public Optional<Seller> getSellerById(String id) {
        return getSellers().stream()
                .filter(seller -> seller.getId().equals(id))
                .findFirst();
    }


    public Map<String, String> getSellerNamesById(List<String> ids) {
        List<Seller> sellersByIds = getSellerOutputPort.getSellersByIds(ids);
        return sellersByIds.stream().collect(Collectors.toMap(Seller::getId, Seller::getName));
    }

    @Override
    public Optional<Seller> getSellerByName(String name) {
        List<Seller> allSellers = getSellers();
        return allSellers.stream()
                .filter(seller -> seller.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
