package dev.julioperez.littleTree.box.sellerbox.infrastructure.delivery;

import dev.julioperez.littleTree.box.sellerbox.domain.dto.ManualTransactionSellerBoxRequest;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.manageSellerBox.ManageSellerBoxInputPort;
import dev.julioperez.littleTree.box.sellerbox.domain.port.manualTransactionSellerBox.ManualTransactionSellerBoxInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/box/seller-box")
@Slf4j
@CrossOrigin(origins = "*")
public class SellerBoxController {

    private final ManageSellerBoxInputPort manageSellerBoxInputPort;
    private final ManualTransactionSellerBoxInputPort manualTransactionSellerBoxInputPort;

    public SellerBoxController(ManageSellerBoxInputPort manageSellerBoxInputPort, ManualTransactionSellerBoxInputPort manualTransactionSellerBoxInputPort) {
        this.manageSellerBoxInputPort = manageSellerBoxInputPort;
        this.manualTransactionSellerBoxInputPort = manualTransactionSellerBoxInputPort;
    }

    @PutMapping("/get/{name}")
    public ResponseEntity<List<SellerBox>> getSellerBoxByNameResponse(@PathVariable String name){
        List<SellerBox> sellerBoxByNameOrdered = manageSellerBoxInputPort.getSellerBoxByNameOrdered(name);
        HttpStatus httpStatus = sellerBoxByNameOrdered.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(sellerBoxByNameOrdered, httpStatus);
    }
    @PutMapping("/auxiliar")
    public ResponseEntity<?> auxiliarSellerBox(@RequestBody ManualTransactionSellerBoxRequest manualTransactionSellerBoxRequest){
        boolean result = manualTransactionSellerBoxInputPort.manualTransactionSellerBox(manualTransactionSellerBoxRequest);
        HttpStatus httpStatus = !result
                ? HttpStatus.NOT_IMPLEMENTED
                : HttpStatus.ACCEPTED;
        return new ResponseEntity<>(result, httpStatus);
    }
}
