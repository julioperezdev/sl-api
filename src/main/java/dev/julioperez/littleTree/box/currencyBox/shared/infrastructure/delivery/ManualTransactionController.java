package dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.delivery;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.ManualTransactionRequest;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.manualTransaction.ManualTransactionInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/operation/manual")
@Slf4j
@CrossOrigin(origins = "*")
public class ManualTransactionController {
    private final ManualTransactionInputPort manualTransactionInputPort;

    public ManualTransactionController(ManualTransactionInputPort manualTransactionInputPort) {
        this.manualTransactionInputPort = manualTransactionInputPort;
    }

    @PutMapping("/execute")
    public ResponseEntity<Boolean> executeManualOperation(@RequestBody ManualTransactionRequest manualTransactionRequest){
        boolean manualOperation = manualTransactionInputPort.execute(manualTransactionRequest);
        return new ResponseEntity<>(manualOperation, HttpStatus.CREATED);
    }
}
