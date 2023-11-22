package dev.julioperez.littleTree.operation.sellOperation.infrastructure.delivery;

import dev.julioperez.littleTree.operation.sellOperation.domain.dto.SellOperationRequest;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.createSellOperation.CreateSellOperationInputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/operation/sell")
@CrossOrigin(origins = "*")
public class SellOperationController {

    private final CreateSellOperationInputPort createSellOperation;

    public SellOperationController(CreateSellOperationInputPort createSellOperation) {
        this.createSellOperation = createSellOperation;
    }

    @PutMapping("/create")
    public ResponseEntity<Boolean> createSellOperation(@RequestBody SellOperationRequest sellOperationRequest){
        boolean sellOperation = createSellOperation.createSellOperation(sellOperationRequest);
        return new ResponseEntity<>(sellOperation, HttpStatus.CREATED);
    }
}
