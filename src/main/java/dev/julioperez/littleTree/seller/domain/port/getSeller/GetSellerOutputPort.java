package dev.julioperez.littleTree.seller.domain.port.getSeller;

import dev.julioperez.littleTree.seller.domain.model.Seller;

import java.util.List;

public interface GetSellerOutputPort {
    List<Seller> getSellers();
}
