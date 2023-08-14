package dev.julioperez.littleTree.seller.infrastructure.delivery;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerRequest;
import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.port.createSeller.CreateSellerInputPort;
import dev.julioperez.littleTree.seller.domain.port.getSeller.GetSellerInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seller")
@Slf4j
public class SellerController {
    private final CreateSellerInputPort createSellerInputPort;
    private final GetSellerInputPort getSellerInputPort;

    public SellerController(CreateSellerInputPort createSellerInputPort, GetSellerInputPort getSellerInputPort) {
        this.createSellerInputPort = createSellerInputPort;
        this.getSellerInputPort = getSellerInputPort;
    }

    @PostMapping("/create")
    public ResponseEntity<Seller> createSeller(@RequestBody CreateSellerRequest createSellerRequest) throws Exception{
        Seller seller = createSellerInputPort.createSeller(createSellerRequest);
        return new ResponseEntity<>(seller, HttpStatus.CREATED);
    }

    @PostMapping("/get")
    public ResponseEntity<List<Seller>> getSeller(){
        List<Seller> sellers = getSellerInputPort.getSellers();
        HttpStatus httpStatus = sellers.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(sellers, httpStatus);
    }
}
