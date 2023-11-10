package dev.julioperez.littleTree.seller.sellerCommission.application.paySellerCommission.delivery;

import dev.julioperez.littleTree.seller.sellerCommission.domain.port.paySellerCommission.PaySellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.paySellerCommission.PaySellerCommissionInputPort;

public class PaySellerCommissionDelivery implements PaySellerCommissionInputPort {
    private final PaySellerCommission paySellerCommission;

    public PaySellerCommissionDelivery(PaySellerCommission paySellerCommission) {
        this.paySellerCommission = paySellerCommission;
    }

    @Override
    public boolean paySellerCommission(String sellerCommissionId) {
        return paySellerCommission.execute(sellerCommissionId);
    }
}
