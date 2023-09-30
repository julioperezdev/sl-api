package dev.julioperez.littleTree.currency.infrastructure.delivery;

import dev.julioperez.littleTree.currency.domain.dto.UpdateCurrencyRequest;
import dev.julioperez.littleTree.currency.domain.model.Currency;
import dev.julioperez.littleTree.currency.domain.port.getCurrency.GetCurrencyInputPort;
import dev.julioperez.littleTree.currency.domain.port.updateCurrency.UpdateCurrencyInputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/currency")
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3001")
public class CurrencyController {
    private final GetCurrencyInputPort getCurrencyInputPort;
    private final UpdateCurrencyInputPort updateCurrencyInputPort;

    @PutMapping("/get")
    ResponseEntity<List<Currency>> getHistoricalCurrencies(){
        List<Currency> historicalCurrencies = getCurrencyInputPort.getHistoricalCurrencies();
        HttpStatus httpStatus = historicalCurrencies.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(historicalCurrencies, httpStatus);
    }

    @PutMapping("/get/last-updated")
    ResponseEntity<List<Currency>> getLastUpdatedCurrencies(){
        List<Currency> historicalCurrencies = getCurrencyInputPort.getLastUpdateOfCurrencies();
        HttpStatus httpStatus = historicalCurrencies.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(historicalCurrencies, httpStatus);
    }

    @PutMapping("/get/name/usd")
    ResponseEntity<Currency> getUsdCurrency(){
        Currency dollarHighUpdated = getCurrencyInputPort.getLastUpdatedByName("Dolar grande");
        return new ResponseEntity<>(dollarHighUpdated, HttpStatus.FOUND);
    }

    @PutMapping("/update")
    ResponseEntity<List<Currency>> updateCurrency(@RequestBody UpdateCurrencyRequest updateCurrencyRequest){
        List<Currency> currenciesUpdated = updateCurrencyInputPort.updateCurrency(updateCurrencyRequest);
        return new ResponseEntity<>(currenciesUpdated, HttpStatus.OK);
    }
}
