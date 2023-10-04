package dev.julioperez.littleTree.seller.infrastructure.delivery;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.dto.UpdateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.domain.port.createSellerCommission.CreateSellerCommissionInputPort;
import dev.julioperez.littleTree.seller.domain.port.getSellerCommission.GetSellerCommissionInputPort;
import dev.julioperez.littleTree.seller.domain.port.updateSellerCommission.UpdateSellerCommissionInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seller/commission")
@Slf4j
@CrossOrigin(origins = "*")
public class SellerCommissionController {
    private final GetSellerCommissionInputPort getSellerCommissionInputPort;
    private final CreateSellerCommissionInputPort createSellerCommissionInputPort;
    private final UpdateSellerCommissionInputPort updateSellerCommissionInputPort;

    public SellerCommissionController(GetSellerCommissionInputPort getSellerCommissionInputPort, CreateSellerCommissionInputPort createSellerCommissionInputPort, UpdateSellerCommissionInputPort updateSellerCommissionInputPort) {
        this.getSellerCommissionInputPort = getSellerCommissionInputPort;
        this.createSellerCommissionInputPort = createSellerCommissionInputPort;
        this.updateSellerCommissionInputPort = updateSellerCommissionInputPort;
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
        SellerCommission sellerCommission = createSellerCommissionInputPort.createSellerCommission(createSellerCommissionRequest);
        return new ResponseEntity<>(sellerCommission, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<SellerCommission> updateSellerCommission(@RequestBody UpdateSellerCommissionRequest updateSellerCommissionRequest){
        SellerCommission sellerCommission = updateSellerCommissionInputPort.updateSellerCommission(updateSellerCommissionRequest);
        return new ResponseEntity<>(sellerCommission, HttpStatus.CREATED);
    }
}
