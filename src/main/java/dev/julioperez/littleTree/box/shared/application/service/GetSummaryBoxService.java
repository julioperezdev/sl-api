package dev.julioperez.littleTree.box.shared.application.service;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.box.balance.domain.port.getBalance.GetBalance;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.sellerbox.domain.enums.SellerBoxNames;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.getSellerBox.GetSellerBox;
import dev.julioperez.littleTree.box.shared.domain.dto.SummaryBoxResponse;
import dev.julioperez.littleTree.box.shared.domain.port.getSummaryBox.GetSummaryBox;

import java.util.Objects;
import java.util.Optional;

public class GetSummaryBoxService implements GetSummaryBox {
    private final GetBalance getBalance;
    private final GetCurrencyMultibox getCurrencyMultibox;
    private final GetSellerBox getSellerBox;

    public GetSummaryBoxService(GetBalance getBalance, GetCurrencyMultibox getCurrencyMultibox, GetSellerBox getSellerBox) {
        this.getBalance = getBalance;
        this.getCurrencyMultibox = getCurrencyMultibox;
        this.getSellerBox = getSellerBox;
    }

    @Override
    public SummaryBoxResponse execute() {
        Float pesosBox = getCurrencyMultibox.getTotalByCurrencyBox(CurrencyBox.PESO);
        Float usdHighBox = getCurrencyMultibox.getTotalByCurrencyBox(CurrencyBox.USD_HIGH);
        Float usdLowBox = getCurrencyMultibox.getTotalByCurrencyBox(CurrencyBox.USD_LOW);
        Float euroBox = getCurrencyMultibox.getTotalByCurrencyBox(CurrencyBox.EURO);
        Float realBox = getCurrencyMultibox.getTotalByCurrencyBox(CurrencyBox.REAL);
        Float officeBox = getCurrencyMultibox.getTotalByCurrencyBox(CurrencyBox.PESO_OFFICE);
        Balance balance = getBalance.getLastBalance();
        Float balanceValue = Objects.isNull(balance) ? 0 : balance.getProfit();
        SellerBox seller1Box = getSellerBox.getLastSellerBoxByName(SellerBoxNames.BOX_1.value());
        Float seller1Value = Objects.isNull(seller1Box) ? 0 : seller1Box.getQuantity();
        SellerBox seller2Box = getSellerBox.getLastSellerBoxByName(SellerBoxNames.BOX_2.value());
        Float seller2Value = Objects.isNull(seller2Box) ? 0 : seller2Box.getQuantity();
        return new SummaryBoxResponse(pesosBox,officeBox,usdHighBox,usdLowBox, euroBox,realBox,balanceValue,seller1Value,seller2Value);
    }
}
