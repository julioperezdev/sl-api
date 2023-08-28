package dev.julioperez.littleTree.operation.domain.enums;

import dev.julioperez.littleTree.client.domain.enums.DifferenceStatus;

import java.util.Arrays;
import java.util.List;

public enum OperationStatus {
    PENDING("pendiente"),
    DONE("resuelto"),
    CANCELLED("cancelado");

    private final String value;
    OperationStatus(String value) {
        this.value = value;
    }
    public boolean isPending(){
        return this.value.equalsIgnoreCase(PENDING.value);
    }

    public String value(){
        return this.value;
    }
    public static OperationStatus returnOperationStatusByDescription(String externalValue){
        List<OperationStatus> operationStatuses = Arrays.stream(OperationStatus.values())
                .filter(particular -> particular.value.equalsIgnoreCase(externalValue)).toList();
        if(operationStatuses.isEmpty()) throw new IllegalArgumentException(String.format(" %s dont exist on OperationStatus ", externalValue));
        if(operationStatuses.size() != 1) throw new IllegalArgumentException(String.format(" %s cant match with more of one OperationStatus ", externalValue));
        return operationStatuses.get(0);
    }

}
