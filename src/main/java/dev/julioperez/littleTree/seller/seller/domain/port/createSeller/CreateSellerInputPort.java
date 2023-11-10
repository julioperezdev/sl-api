package dev.julioperez.littleTree.seller.seller.domain.port.createSeller;

import dev.julioperez.littleTree.seller.seller.domain.dto.CreateSellerRequest;
import dev.julioperez.littleTree.seller.seller.domain.model.Seller;

public interface CreateSellerInputPort {

    Seller createSeller(CreateSellerRequest createSellerRequest) throws Exception;
}
