package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.egressPesosBoxByCommissionPayment;

public interface EgressPesosBoxByCommissionPayment {
    boolean execute(Float sellerCommissionQuantity);
}
