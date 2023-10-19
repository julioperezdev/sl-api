package dev.julioperez.littleTree.operation.infrastructure.delivery;

import dev.julioperez.littleTree.operation.domain.dto.*;
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

    @PutMapping("/get/pending")
    public ResponseEntity<GetBuyAndSellOperationResponseDto> getPendingOperations(){
        GetBuyAndSellOperationResponseDto pendingOperations = getOperationsInputPort.getPendingBuyAndSellOperations();
        HttpStatus httpStatus = pendingOperations.buyOperation() == null && pendingOperations.sellOperation() == null
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(pendingOperations, httpStatus);
    }

    @PutMapping("/get/done")
    public ResponseEntity<GetBuyAndSellOperationResponseDto> getDoneBuyOperations(){
        GetBuyAndSellOperationResponseDto doneOperations = getOperationsInputPort.getDoneBuyAndSellOperations();
        HttpStatus httpStatus = doneOperations.buyOperation() == null && doneOperations.sellOperation() == null
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(doneOperations, httpStatus);
    }
    @PutMapping("/get/done/reserve/{currency}")
    public ResponseEntity<List<GetDoneOperationToShowReserve>> getDoneBuyOperationsByCurrency(@PathVariable String currency){
        List<GetDoneOperationToShowReserve> buyOperations = getOperationsInputPort.getDoneBuyOperationsByCurrency(currency);
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
    @PutMapping("/pending")
    public ResponseEntity<Boolean> pendingOperation(@RequestBody ChangePendingOperationRequest changePendingOperationRequest){
        boolean response = pendingOperationInputPort.changePendingToExecuteOperation(changePendingOperationRequest);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
    @PutMapping("/cancel")
    public ResponseEntity<Boolean> cancelOperation(@RequestBody ChangePendingOperationRequest changePendingOperationRequest){
        boolean response = cancelOperationInputPort.changePendingToCancelOperation(changePendingOperationRequest);
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
