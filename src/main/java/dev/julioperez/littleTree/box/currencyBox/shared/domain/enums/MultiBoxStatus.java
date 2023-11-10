package dev.julioperez.littleTree.box.currencyBox.shared.domain.enums;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;

import java.util.Arrays;
import java.util.List;

public enum MultiBoxStatus {

    PENDING("pendiente"),
    DONE("resuelto"),
    CANCELLED("cancelado");

    private final String value;

    MultiBoxStatus(String value) {
        this.value = value;
    }

    public boolean isPending(){
        return this.value.equalsIgnoreCase(PENDING.value);
    }

    public String value(){
        return this.value;
    }
    public boolean isValidMultiBoxStatus(){
        return Arrays.stream(MultiBoxStatus.values())
                .anyMatch(particular -> particular.value.equalsIgnoreCase(value));
    }

    public static MultiBoxStatus returnMultiBoxStatusByDescription(String externalValue){
        List<MultiBoxStatus> multiBoxStatuses = Arrays.stream(MultiBoxStatus.values())
                .filter(particular -> particular.value.equalsIgnoreCase(externalValue)).toList();
        if(multiBoxStatuses.isEmpty()) throw new IllegalArgumentException(String.format(" %s dont exist on MultiBoxStatus ", externalValue));
        if(multiBoxStatuses.size() != 1) throw new IllegalArgumentException(String.format(" %s cant match with more of one MultiBoxStatus ", externalValue));
        return multiBoxStatuses.get(0);
    }
}
