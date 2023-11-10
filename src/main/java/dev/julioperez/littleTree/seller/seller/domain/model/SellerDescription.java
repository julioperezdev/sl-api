package dev.julioperez.littleTree.seller.seller.domain.model;

import dev.julioperez.littleTree.shared.domain.model.StringValueObject;

public class SellerDescription extends StringValueObject {
    public SellerDescription(String value) {
        super(value);
        this.ensureValueIsValid(value);
    }

    private void ensureValueIsValid(String valueToValid){
        if(valueToValid == null || valueToValid.isEmpty() || valueToValid.isBlank()) throw new IllegalArgumentException(String.format("%s value must be define", valueToValid));
        //if(!valueToValid.matches("^[a-zA-Z ]*$")) throw new IllegalArgumentException(String.format("%s value must contain only alphabetic characters",valueToValid));
    }
}
