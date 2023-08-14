package dev.julioperez.littleTree.seller.domain.model;

import dev.julioperez.littleTree.shared.domain.model.StringValueObject;
import org.apache.commons.lang3.StringUtils;

public final class SellerPhone extends StringValueObject {
    public SellerPhone(String value) {
        super(value);
        this.ensureValueIsValid(value);
    }

    private void ensureValueIsValid(String valueToValid){
        if(valueToValid == null || valueToValid.isEmpty() || valueToValid.isBlank()) throw new IllegalArgumentException(String.format("%s value must be define", valueToValid));
        if(!StringUtils.isNumeric(valueToValid)) throw new IllegalArgumentException(String.format("%s value must contain only alphabetic characters",valueToValid));
    }
}
