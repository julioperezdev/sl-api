package dev.julioperez.littleTree.box.currencyBox.pesos.infrastructure.delivery;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.ManualTransactionRequest;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.manualTransaction.ManualTransactionInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/box/pesos")
@Slf4j
@CrossOrigin(origins = "*")
public class PesosBoxController {
    private final ManualTransactionInputPort manualTransactionInputPort;

    public PesosBoxController(ManualTransactionInputPort manualTransactionInputPort) {
        this.manualTransactionInputPort = manualTransactionInputPort;
    }

    @PutMapping("/auxiliar")
    public ResponseEntity<?> auxiliarPesos(@RequestBody ManualTransactionRequest manualTransactionRequest){
        HttpStatus httpStatus = manualTransactionInputPort.execute(manualTransactionRequest)
                ? HttpStatus.NOT_IMPLEMENTED
                : HttpStatus.ACCEPTED;
        return new ResponseEntity<>(true, httpStatus);
    }
}
