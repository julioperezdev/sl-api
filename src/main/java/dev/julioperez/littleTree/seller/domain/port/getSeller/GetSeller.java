package dev.julioperez.littleTree.seller.domain.port.getSeller;

import dev.julioperez.littleTree.seller.domain.model.Seller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GetSeller {
    List<Seller> getSellers();
    Optional<Seller> getSellerById(String id);
    Optional<Seller> getSellerByName(String name);

    Map<String, String> getSellerNamesById(List<String> ids);
}
