package dev.julioperez.littleTree.client.clientDifference.domain.enums;

import java.util.Arrays;
import java.util.List;

public enum DifferenceType {
    LACK("Faltante"),
    SPARE("Sobrante");

    private final String value;

    DifferenceType(String value) {
        this.value = value;
    }

    public boolean isLack(){
        return this.value.equalsIgnoreCase(LACK.value);
    }

    public String value(){
        return this.value;
    }

    public static DifferenceType returnDifferenceTypeByDescription(String externalValue){
        List<DifferenceType> differenceTypes = Arrays.stream(DifferenceType.values())
                .filter(particular -> particular.value.equalsIgnoreCase(externalValue)).toList();
        if(differenceTypes.isEmpty()) throw new IllegalArgumentException(String.format("%s dont exist on DifferenceType ", externalValue));
        if(differenceTypes.size() != 1) throw new IllegalArgumentException(String.format(" %s cant match with more of one DifferenceType ", externalValue));
        return differenceTypes.get(0);
    }

}
