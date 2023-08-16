package dev.julioperez.littleTree.currency.infrastructure.delivery;

import dev.julioperez.littleTree.currency.domain.dto.UpdateCurrencyRequest;
import dev.julioperez.littleTree.currency.domain.model.Currency;
import dev.julioperez.littleTree.currency.domain.port.getCurrency.GetCurrencyInputPort;
import dev.julioperez.littleTree.currency.domain.port.updateCurrency.UpdateCurrencyInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/currency")
@AllArgsConstructor
public class CurrencyController {
    private final GetCurrencyInputPort getCurrencyInputPort;
    private final UpdateCurrencyInputPort updateCurrencyInputPort;

    @PostMapping("/get")
    ResponseEntity<List<Currency>> getHistoricalCurrencies(){
        List<Currency> historicalCurrencies = getCurrencyInputPort.getHistoricalCurrencies();
        HttpStatus httpStatus = historicalCurrencies.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(historicalCurrencies, httpStatus);
    }

    @PutMapping("/update")
    ResponseEntity<List<Currency>> updateCurrency(@RequestBody UpdateCurrencyRequest updateCurrencyRequest){
        List<Currency> currenciesUpdated = updateCurrencyInputPort.updateCurrency(updateCurrencyRequest);
        return new ResponseEntity<>(currenciesUpdated, HttpStatus.OK);
    }
}
