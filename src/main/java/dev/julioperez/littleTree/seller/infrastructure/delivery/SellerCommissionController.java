package dev.julioperez.littleTree.seller.infrastructure.delivery;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.dto.UpdateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.domain.port.getSellerCommission.GetSellerCommissionInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seller/commission")
@Slf4j
public class SellerCommissionController {
    private final GetSellerCommissionInputPort getSellerCommissionInputPort;

    public SellerCommissionController(GetSellerCommissionInputPort getSellerCommissionInputPort) {
        this.getSellerCommissionInputPort = getSellerCommissionInputPort;
    }

    @PostMapping("/get")
    public ResponseEntity<List<SellerCommission>> getSellerCommission(){
        List<SellerCommission> sellerCommission = getSellerCommissionInputPort.getSellerCommission();
        HttpStatus httpStatus = sellerCommission.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(sellerCommission, httpStatus);
    }
    @PostMapping("/create")
    public ResponseEntity<SellerCommission> createSellerCommission(@RequestBody CreateSellerCommissionRequest createSellerCommissionRequest){
        List<SellerCommission> sellerCommission = getSellerCommissionInputPort.getSellerCommission();
        return new ResponseEntity<>(sellerCommission.get(0), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<SellerCommission> updateSellerCommission(@RequestBody UpdateSellerCommissionRequest updateSellerCommissionRequest){
        List<SellerCommission> sellerCommission = getSellerCommissionInputPort.getSellerCommission();
        return new ResponseEntity<>(sellerCommission.get(0), HttpStatus.CREATED);
    }
}
