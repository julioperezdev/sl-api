package dev.julioperez.littleTree.box.shared.application.service;

import dev.julioperez.littleTree.box.balance.domain.port.getBalance.GetBalance;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.sellerbox.domain.enums.SellerBoxNames;
import dev.julioperez.littleTree.box.sellerbox.domain.port.getSellerBox.GetSellerBox;
import dev.julioperez.littleTree.box.shared.domain.dto.SummaryBoxResponse;
import dev.julioperez.littleTree.box.shared.domain.port.getSummaryBox.GetSummaryBox;

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
        getSellerBox.getLastSellerBoxByName(SellerBoxNames.BOX_1.name());
        getSellerBox.getLastSellerBoxByName(SellerBoxNames.BOX_2.name());
        getBalance.getLastBalance();
        getCurrencyMultibox.getLastCurrencyMultiboxByCurrencyBox(CurrencyBox.EURO);
        getCurrencyMultibox.getLastCurrencyMultiboxByCurrencyBox(CurrencyBox.USD_LOW);
        getCurrencyMultibox.getLastCurrencyMultiboxByCurrencyBox(CurrencyBox.USD_HIGH);
        getCurrencyMultibox.getLastCurrencyMultiboxByCurrencyBox(CurrencyBox.REAL);
        getCurrencyMultibox.getLastCurrencyMultiboxByCurrencyBox(CurrencyBox.PESO);
        getCurrencyMultibox.getLastCurrencyMultiboxByCurrencyBox(CurrencyBox.PESO_OFFICE);
        return null;
    }
}
