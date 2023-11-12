package dev.julioperez.littleTree.seller.seller.infrastructure.delivery;

import dev.julioperez.littleTree.seller.seller.domain.dto.CreateSellerRequest;
import dev.julioperez.littleTree.seller.seller.domain.dto.UpdateSellerRequest;
import dev.julioperez.littleTree.seller.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.seller.domain.port.createSeller.CreateSellerInputPort;
import dev.julioperez.littleTree.seller.seller.domain.port.getSeller.GetSellerInputPort;
import dev.julioperez.littleTree.seller.seller.domain.port.updateSeller.UpdateSellerInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/seller")
@Slf4j
@CrossOrigin(origins = "*")
public class SellerController {
    private final CreateSellerInputPort createSellerInputPort;
    private final GetSellerInputPort getSellerInputPort;
    private final UpdateSellerInputPort updateSellerInputPort;

    public SellerController(CreateSellerInputPort createSellerInputPort, GetSellerInputPort getSellerInputPort, UpdateSellerInputPort updateSellerInputPort) {
        this.createSellerInputPort = createSellerInputPort;
        this.getSellerInputPort = getSellerInputPort;
        this.updateSellerInputPort = updateSellerInputPort;
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

    @PutMapping("/get/{id}")
    public ResponseEntity<Optional<Seller>> getSellerById(@PathVariable String id){
        Optional<Seller> sellers = getSellerInputPort.getSellerById(id);
        HttpStatus httpStatus = sellers.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(sellers, httpStatus);
    }

    @PutMapping("/get/name/{name}")
    public ResponseEntity<Optional<Seller>> getSellerByName(@PathVariable String name){
        Optional<Seller> sellerByName = getSellerInputPort.getSellerByName(name);
        HttpStatus httpStatus = sellerByName.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(sellerByName, httpStatus);
    }
    @PutMapping("/get/names")
    public ResponseEntity<List<String>> getSellersNames(){
        List<String> sellersNames = getSellerInputPort.getSellersNames();
        HttpStatus httpStatus = sellersNames.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(sellersNames, httpStatus);
    }

    @PutMapping("/update")
    public ResponseEntity<Seller> updateSeller(@RequestBody UpdateSellerRequest updateSellerRequest){
        Seller seller = updateSellerInputPort.updateSeller(updateSellerRequest);
        return new ResponseEntity<>(seller, HttpStatus.OK);
    }
}
