package dev.julioperez.littleTree.box.currencyBox.officeDebt.infrastructure.delivery;

import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.dto.PayDebtRequest;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.getOfficeDebt.GetOfficeDebtInputPort;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.payDebt.PayDebtInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/box/office-debt")
@Slf4j
@CrossOrigin(origins = "*")
public class OfficeDebtBoxController {
    private final PayDebtInputPort payDebtInputPort;
    private final GetOfficeDebtInputPort getOfficeDebtInputPort;

    public OfficeDebtBoxController(PayDebtInputPort payDebtInputPort, GetOfficeDebtInputPort getOfficeDebtInputPort) {
        this.payDebtInputPort = payDebtInputPort;
        this.getOfficeDebtInputPort = getOfficeDebtInputPort;
    }

    @PutMapping("/auxiliar")
    public ResponseEntity<Boolean> auxiliarOfficeDebt(@RequestBody PayDebtRequest payDebtRequest){
        boolean response = payDebtInputPort.execute(payDebtRequest);
        HttpStatus httpStatus = !response
                ? HttpStatus.NOT_IMPLEMENTED
                : HttpStatus.ACCEPTED;
        return new ResponseEntity<>(response, httpStatus);
    }

    @PutMapping("/last-debt")
    public ResponseEntity<Float> getLastDebt(){
        Float lastDebt = getOfficeDebtInputPort.getLastDebt();
        return new ResponseEntity<>(lastDebt, HttpStatus.ACCEPTED);
    }
}
