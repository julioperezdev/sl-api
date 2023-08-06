package dev.julioperez.littleTree.client.domain.model;

import dev.julioperez.littleTree.shared.domain.model.DateValueObject;

import java.util.Date;

public final class ClientCreatedAt extends DateValueObject {
    public ClientCreatedAt(Date value) {
        super(value);
    }
}
