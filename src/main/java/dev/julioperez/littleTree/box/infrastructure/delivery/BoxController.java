package dev.julioperez.littleTree.box.infrastructure.delivery;

import dev.julioperez.littleTree.box.domain.dto.CurrencyMultiboxToList;
import dev.julioperez.littleTree.box.domain.model.Balance;
import dev.julioperez.littleTree.box.domain.model.SellerBox;
import dev.julioperez.littleTree.box.domain.port.getCurrencyMultibox.GetCurrencyMultiboxInputPort;
import dev.julioperez.littleTree.box.domain.port.manageBalance.ManageBalanceInputPort;
import dev.julioperez.littleTree.box.domain.port.manageSellerBox.ManageSellerBoxInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/box")
@Slf4j
@CrossOrigin(origins = "*")
public class BoxController {

    private final GetCurrencyMultiboxInputPort getCurrencyMultiboxInputPort;
    private final ManageBalanceInputPort manageBalanceInputPort;
    private final ManageSellerBoxInputPort manageSellerBoxInputPort;

    public BoxController(GetCurrencyMultiboxInputPort getCurrencyMultiboxInputPort, ManageBalanceInputPort manageBalanceInputPort, ManageSellerBoxInputPort manageSellerBoxInputPort) {
        this.getCurrencyMultiboxInputPort = getCurrencyMultiboxInputPort;
        this.manageBalanceInputPort = manageBalanceInputPort;
        this.manageSellerBoxInputPort = manageSellerBoxInputPort;
    }

    @PutMapping("/get/{name}")
    public ResponseEntity<List<CurrencyMultiboxToList>> getBoxByName(@PathVariable String name){
        List<CurrencyMultiboxToList> currencyMultiboxToListByName = getCurrencyMultiboxInputPort.getCurrencyMultiboxToListByName(name);
        HttpStatus httpStatus = currencyMultiboxToListByName.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(currencyMultiboxToListByName, httpStatus);
    }

    @PutMapping("/get/balance")
    public ResponseEntity<List<Balance>> getBalanceResponse(){
        List<Balance> balanceOrdered = manageBalanceInputPort.getBalanceOrdered();
        HttpStatus httpStatus = balanceOrdered.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(balanceOrdered, httpStatus);
    }

    @PutMapping("/get/sellerbox/{name}")
    public ResponseEntity<List<SellerBox>> getSellerBoxByNameResponse(@PathVariable String name){
        List<SellerBox> sellerBoxByNameOrdered = manageSellerBoxInputPort.getSellerBoxByNameOrdered(name);
        HttpStatus httpStatus = sellerBoxByNameOrdered.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(sellerBoxByNameOrdered, httpStatus);
    }


}
