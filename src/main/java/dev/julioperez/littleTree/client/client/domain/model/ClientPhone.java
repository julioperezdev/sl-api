package dev.julioperez.littleTree.client.client.domain.model;

import dev.julioperez.littleTree.shared.domain.model.StringValueObject;
import org.apache.commons.lang3.StringUtils;

public final class ClientPhone extends StringValueObject {
    public ClientPhone(String value) {
        super(value);
        this.ensureValueIsValid(value);
    }

    private void ensureValueIsValid(String valueToValid){
        if(valueToValid == null || valueToValid.isEmpty() || valueToValid.isBlank()) throw new IllegalArgumentException(String.format("%s value must be define", valueToValid));
        if(!StringUtils.isNumeric(valueToValid)) throw new IllegalArgumentException(String.format("%s value must contain only alphabetic characters",valueToValid));
    }
}
