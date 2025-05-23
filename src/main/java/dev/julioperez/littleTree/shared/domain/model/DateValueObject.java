package dev.julioperez.littleTree.shared.domain.model;

import java.util.Date;
import java.util.Objects;

public abstract class DateValueObject {

    private final Date value;

    public DateValueObject(Date value) {
        this.value = value;
    }

    public Date value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateValueObject that = (DateValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
