package dev.julioperez.littleTree.provider.domain.model;

import dev.julioperez.littleTree.shared.domain.model.DateValueObject;

import java.util.Date;

public final class ProviderCreatedAt extends DateValueObject {
    public ProviderCreatedAt(Date value) {
        super(value);
    }
}
