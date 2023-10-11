package dev.julioperez.littleTree.box.domain.enums;

import java.util.Arrays;
import java.util.List;

public enum SellerBoxNames {
    BOX_1("Caja 1"),
    BOX_2("Caja 2");
    private final String value;
    SellerBoxNames(String value){
        this.value = value;
    }
    public String value(){
        return this.value;
    }

    public static SellerBoxNames returnSellerBoxNamesByValue(String externalValue){
        List<SellerBoxNames> sellerBoxNames = Arrays.stream(SellerBoxNames.values())
                .filter(particular -> particular.value.equalsIgnoreCase(externalValue)).toList();
        if(sellerBoxNames.isEmpty()) throw new IllegalArgumentException(String.format(" %s dont exist on sellerBoxNames ", externalValue));
        if(sellerBoxNames.size() != 1) throw new IllegalArgumentException(String.format(" %s cant match with more of one sellerBoxNames ", externalValue));
        return sellerBoxNames.get(0);
    }
}
