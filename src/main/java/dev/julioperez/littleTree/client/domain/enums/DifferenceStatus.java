package dev.julioperez.littleTree.client.domain.enums;


import java.util.Arrays;
import java.util.List;

public enum DifferenceStatus {

    PENDING("pendiente"),
    DONE("resuelto");

    private final String value;

    DifferenceStatus(String description) {
        this.value = description;
    }

    public boolean isPending(){
        return this.value.equalsIgnoreCase(PENDING.value);
    }

    public String value(){
        return this.value;
    }
    public static DifferenceStatus returnDifferenceStatusByDescription(String externalValue){
        List<DifferenceStatus> differenceStatuses = Arrays.stream(DifferenceStatus.values())
                .filter(particular -> particular.value.equalsIgnoreCase(externalValue)).toList();
        if(differenceStatuses.isEmpty()) throw new IllegalArgumentException(String.format(" %s dont exist on DifferenceStatus ", externalValue));
        if(differenceStatuses.size() != 1) throw new IllegalArgumentException(String.format(" %s cant match with more of one DifferenceStatus ", externalValue));
        return differenceStatuses.get(0);
    }
}
