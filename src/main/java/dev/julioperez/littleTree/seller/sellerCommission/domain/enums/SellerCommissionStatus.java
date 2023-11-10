package dev.julioperez.littleTree.seller.sellerCommission.domain.enums;

import java.util.Arrays;
import java.util.List;

public enum SellerCommissionStatus {

    PENDING("pendiente"),
    DONE("pagado"),
    CANCELED("cancelado");

    private final String value;

    SellerCommissionStatus(String value) {
        this.value = value;
    }

    public String value(){
        return this.value;
    }
    public static SellerCommissionStatus returnSellerCommissionStatusByDescription(String externalValue){
        List<SellerCommissionStatus> sellerCommissionStatuses = Arrays.stream(SellerCommissionStatus.values())
                .filter(particular -> particular.value.equalsIgnoreCase(externalValue)).toList();
        if(sellerCommissionStatuses.isEmpty()) throw new IllegalArgumentException(String.format(" %s dont exist on SellerCommissionStatus ", externalValue));
        if(sellerCommissionStatuses.size() != 1) throw new IllegalArgumentException(String.format(" %s cant match with more of one SellerCommissionStatus ", externalValue));
        return sellerCommissionStatuses.get(0);
    }
}
