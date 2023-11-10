package dev.julioperez.littleTree.seller.sellerCommission.infrastructure.delivery;

import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.SellerCommissionResponseDto;
import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.UpdateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.createSellerCommission.CreateSellerCommissionInputPort;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.getSellerCommission.GetSellerCommissionInputPort;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.paySellerCommission.PaySellerCommissionInputPort;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.updateSellerCommission.UpdateSellerCommissionInputPort;
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
    private final PaySellerCommissionInputPort paySellerCommissionInputPort;

    public SellerCommissionController(GetSellerCommissionInputPort getSellerCommissionInputPort, CreateSellerCommissionInputPort createSellerCommissionInputPort, UpdateSellerCommissionInputPort updateSellerCommissionInputPort, PaySellerCommissionInputPort paySellerCommissionInputPort) {
        this.getSellerCommissionInputPort = getSellerCommissionInputPort;
        this.createSellerCommissionInputPort = createSellerCommissionInputPort;
        this.updateSellerCommissionInputPort = updateSellerCommissionInputPort;
        this.paySellerCommissionInputPort = paySellerCommissionInputPort;
    }

    @PutMapping("/get/pending")
    public ResponseEntity<List<SellerCommissionResponseDto>> getPendingSellerCommission(){
        List<SellerCommissionResponseDto> pendingSellerCommission = getSellerCommissionInputPort.getPendingSellerCommission();
        HttpStatus httpStatus = pendingSellerCommission.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(pendingSellerCommission, httpStatus);
    }

    @PutMapping("/get/done")
    public ResponseEntity<List<SellerCommissionResponseDto>> getDoneSellerCommission(){
        List<SellerCommissionResponseDto> doneSellerCommission = getSellerCommissionInputPort.getDoneSellerCommission();
        HttpStatus httpStatus = doneSellerCommission.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(doneSellerCommission, httpStatus);
    }

    @PutMapping("/pay/{sellerCommissionId}")
    public ResponseEntity<Boolean> paySellerCommission(@PathVariable String sellerCommissionId){
        boolean response = paySellerCommissionInputPort.paySellerCommission(sellerCommissionId);
        HttpStatus httpStatus = !response
                ? HttpStatus.NO_CONTENT
                : HttpStatus.ACCEPTED;
        return new ResponseEntity<>(response, httpStatus);
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
