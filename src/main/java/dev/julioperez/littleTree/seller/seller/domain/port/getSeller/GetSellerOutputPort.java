package dev.julioperez.littleTree.seller.seller.domain.port.getSeller;

import dev.julioperez.littleTree.seller.seller.domain.model.Seller;

import java.util.List;

public interface GetSellerOutputPort {
    List<Seller> getSellers();

    List<Seller> getSellersByIds(List<String> id);
}
