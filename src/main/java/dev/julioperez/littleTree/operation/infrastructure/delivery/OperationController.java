package dev.julioperez.littleTree.operation.infrastructure.delivery;

import dev.julioperez.littleTree.operation.domain.dto.BuyOperationRequest;
import dev.julioperez.littleTree.operation.domain.dto.ChangePendingOperationRequest;
import dev.julioperez.littleTree.operation.domain.dto.SellOperationRequest;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.port.cancelOperation.CancelOperationInputPort;
import dev.julioperez.littleTree.operation.domain.port.createOperation.CreateOperationInputPort;
import dev.julioperez.littleTree.operation.domain.port.getOperations.GetOperationsInputPort;
import dev.julioperez.littleTree.operation.domain.port.pendingOperation.PendingOperationInputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/operation")
@CrossOrigin(origins = "*")
public class OperationController {
    private final GetOperationsInputPort getOperationsInputPort;
    private final CreateOperationInputPort createOperationInputPort;
    private final PendingOperationInputPort pendingOperationInputPort;
    private final CancelOperationInputPort cancelOperationInputPort;

    public OperationController(GetOperationsInputPort getOperationsInputPort, CreateOperationInputPort createOperationInputPort, PendingOperationInputPort pendingOperationInputPort, CancelOperationInputPort cancelOperationInputPort) {
        this.getOperationsInputPort = getOperationsInputPort;
        this.createOperationInputPort = createOperationInputPort;
        this.pendingOperationInputPort = pendingOperationInputPort;
        this.cancelOperationInputPort = cancelOperationInputPort;
    }

    @PutMapping("/get")
    public ResponseEntity<List<BuyOperation>> getOperations(){
        List<BuyOperation> buyOperations = getOperationsInputPort.getPendingBuyOperations();
        HttpStatus httpStatus = buyOperations.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(buyOperations, httpStatus);
    }

    @PutMapping("/create/buy")
    public ResponseEntity<Boolean> createBuyOperation(@RequestBody BuyOperationRequest buyOperationRequest){
        boolean buyOperation = createOperationInputPort.createBuyOperation(buyOperationRequest);
        return new ResponseEntity<>(buyOperation, HttpStatus.CREATED);
    }
    @PutMapping("/create/sell")
    public ResponseEntity<Boolean> createSellOperation(@RequestBody SellOperationRequest sellOperationRequest){
        boolean sellOperation = createOperationInputPort.createSellOperation(sellOperationRequest);
        return new ResponseEntity<>(sellOperation, HttpStatus.CREATED);
    }
    @PostMapping("/pending")
    public ResponseEntity<Boolean> pendingOperation(@RequestBody ChangePendingOperationRequest changePendingOperationRequest){
        boolean response = pendingOperationInputPort.changePendingToExecuteOperation(changePendingOperationRequest);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
    @PostMapping("/cancel")
    public ResponseEntity<Boolean> cancelOperation(@RequestBody ChangePendingOperationRequest changePendingOperationRequest){
        boolean response = cancelOperationInputPort.changePendingToCancelOperation(changePendingOperationRequest);
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
