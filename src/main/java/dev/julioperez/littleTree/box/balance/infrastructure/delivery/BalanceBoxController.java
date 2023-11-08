package dev.julioperez.littleTree.box.balance.infrastructure.delivery;

import dev.julioperez.littleTree.box.balance.domain.dto.AssignSellerBoxRequest;
import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.box.balance.domain.port.assignToSellerBox.AssignSellerBoxInputPort;
import dev.julioperez.littleTree.box.balance.domain.port.manageBalance.ManageBalanceInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/box/balance")
@Slf4j
@CrossOrigin(origins = "*")
public class BalanceBoxController {
    private final ManageBalanceInputPort manageBalanceInputPort;
    private final AssignSellerBoxInputPort assignSellerBoxInputPort;

    public BalanceBoxController(ManageBalanceInputPort manageBalanceInputPort, AssignSellerBoxInputPort assignSellerBoxInputPort) {
        this.manageBalanceInputPort = manageBalanceInputPort;
        this.assignSellerBoxInputPort = assignSellerBoxInputPort;
    }

    @PutMapping("/get")
    public ResponseEntity<List<Balance>> getBalanceResponse(){
        List<Balance> balanceOrdered = manageBalanceInputPort.getBalanceOrdered();
        HttpStatus httpStatus = balanceOrdered.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(balanceOrdered, httpStatus);
    }

    @PutMapping("/auxiliar")
    public ResponseEntity<Boolean> auxiliarBalance(@RequestBody AssignSellerBoxRequest assignSellerBoxRequest){
        boolean response = assignSellerBoxInputPort.execute(assignSellerBoxRequest);
        HttpStatus httpStatus = !response
                ? HttpStatus.NOT_IMPLEMENTED
                : HttpStatus.ACCEPTED;
        return new ResponseEntity<>(response, httpStatus);
    }
}
