package dev.julioperez.littleTree.box.shared.application.delivery;

import dev.julioperez.littleTree.box.shared.domain.dto.SummaryBoxResponse;
import dev.julioperez.littleTree.box.shared.domain.port.getSummaryBox.GetSummaryBox;
import dev.julioperez.littleTree.box.shared.domain.port.getSummaryBox.GetSummaryBoxInputPort;

public class GetSummaryBoxDelivery implements GetSummaryBoxInputPort {

    private final GetSummaryBox getSummaryBox;

    public GetSummaryBoxDelivery(GetSummaryBox getSummaryBox) {
        this.getSummaryBox = getSummaryBox;
    }

    @Override
    public SummaryBoxResponse execute() {
        return getSummaryBox.execute();
    }
}
