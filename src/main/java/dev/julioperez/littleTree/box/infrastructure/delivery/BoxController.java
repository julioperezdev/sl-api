package dev.julioperez.littleTree.box.infrastructure.delivery;

import dev.julioperez.littleTree.box.domain.dto.CurrencyMultiboxToList;
import dev.julioperez.littleTree.box.domain.port.getCurrencyMultibox.GetCurrencyMultiboxInputPort;
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

    public BoxController(GetCurrencyMultiboxInputPort getCurrencyMultiboxInputPort) {
        this.getCurrencyMultiboxInputPort = getCurrencyMultiboxInputPort;
    }

    @PutMapping("/get/{name}")
    public ResponseEntity<List<CurrencyMultiboxToList>> getBoxByName(@PathVariable String name){
        List<CurrencyMultiboxToList> currencyMultiboxToListByName = getCurrencyMultiboxInputPort.getCurrencyMultiboxToListByName(name);
        HttpStatus httpStatus = currencyMultiboxToListByName.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(currencyMultiboxToListByName, httpStatus);
    }
}
