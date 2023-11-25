package dev.julioperez.littleTree.box.shared.infrastructure.delivery;

import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.shared.domain.dto.SummaryBoxResponse;
import dev.julioperez.littleTree.box.shared.domain.port.getSummaryBox.GetSummaryBoxInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/box/shared")
@Slf4j
@CrossOrigin(origins = "*")
public class BoxSharedController {
    private final GetSummaryBoxInputPort getSummaryBoxInputPort;


    public BoxSharedController(GetSummaryBoxInputPort getSummaryBoxInputPort) {
        this.getSummaryBoxInputPort = getSummaryBoxInputPort;
    }

    @PutMapping("/summary")
    public ResponseEntity<SummaryBoxResponse> getSummaryBox(){
        SummaryBoxResponse response = getSummaryBoxInputPort.execute();
        HttpStatus httpStatus = Objects.isNull(response)
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(response, httpStatus);
    }
}
