package dev.julioperez.littleTree.operation.buyOperation.infrastructure.delivery;

import dev.julioperez.littleTree.operation.buyOperation.domain.dto.BuyOperationRequest;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.createBuyOperation.CreateBuyOperationInputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/operation/buy")
@CrossOrigin(origins = "*")
public class BuyOperationController {
    private final CreateBuyOperationInputPort createBuyOperation;

    public BuyOperationController(CreateBuyOperationInputPort createBuyOperation) {
        this.createBuyOperation = createBuyOperation;
    }

    @PutMapping("/create")
    public ResponseEntity<Boolean> createBuyOperation(@RequestBody BuyOperationRequest buyOperationRequest){
        boolean buyOperation = createBuyOperation.createBuyOperation(buyOperationRequest);
        return new ResponseEntity<>(buyOperation, HttpStatus.CREATED);
    }
}
