package dev.julioperez.littleTree.operation.shared.domain.enums;

import java.util.Arrays;
import java.util.List;

public enum OperationType {

    BUY("comprar"),
    SELL("vender"),
    CASH_INCOME("ingreso efectivo"),
    CASH_EGRESS("egreso efectivo"),
    DEBT_PAYMENT("pago deuda"),
    BALANCE_PROFIT("ganancia final"),
    ASSIGN_BOX("asignar caja"),
    COMMISSION_PAYMENT("pago comision");


    private final String value;

    OperationType(String value) {
        this.value = value;
    }

    public String value(){
        return this.value;
    }
    public boolean isBuyOperation(){
        return BUY.value.equals(this.value);
    }
    public boolean isSellOperation(){
        return SELL.value.equals(this.value);
    }
    public static boolean isCashIncomeOperation(String operationType){
        return CASH_INCOME.value.equals(operationType);
    }
    public static boolean isCashEgressOperation(String operationType){
        return CASH_EGRESS.value.equals(operationType);
    }
    public static boolean isManualOperation(String operationType){
        return CASH_INCOME.value.equals(operationType) || CASH_EGRESS.value.equals(operationType);
    }
    public static boolean hasOnlyBuyOperations(List<String> externalValues){
        return externalValues.stream().allMatch(OperationType.BUY.value::equals);
    }
    public static boolean hasOnlySellOperation(List<String> externalValues){
        return externalValues.stream().allMatch(OperationType.SELL.value::equals);
    }
    public static OperationType returnOperationTypeByDescription(String externalValue){
        List<OperationType> operationTypes = Arrays.stream(OperationType.values())
                .filter(particular -> particular.value.equalsIgnoreCase(externalValue)).toList();
        if(operationTypes.isEmpty()) throw new IllegalArgumentException(String.format(" %s dont exist on OperationType ", externalValue));
        if(operationTypes.size() != 1) throw new IllegalArgumentException(String.format(" %s cant match with more of one OperationType ", externalValue));
        return operationTypes.get(0);
    }
}
