package dev.julioperez.littleTree.seller.seller.domain.port.getSeller;

import dev.julioperez.littleTree.seller.seller.domain.model.Seller;

import java.util.List;
import java.util.Optional;

public interface GetSellerInputPort {
    List<Seller> getSellers();
    List<String> getSellersNames();
    Optional<Seller> getSellerById(String id);
    Optional<Seller> getSellerByName(String name);
}
