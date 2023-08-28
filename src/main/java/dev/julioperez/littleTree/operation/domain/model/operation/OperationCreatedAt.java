package dev.julioperez.littleTree.operation.domain.model.operation;

import dev.julioperez.littleTree.shared.domain.model.DateValueObject;

import java.util.Date;

public final class OperationCreatedAt extends DateValueObject {

    public OperationCreatedAt(Date value) {
        super(value);
    }
}
