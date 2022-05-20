package co.com.alimentosybebidas.restaurante.recepcion.values;

import co.com.sofka.domain.generic.ValueObject;

public class Base implements ValueObject<Integer> {

    private final Integer value;

    public Base(Integer value) {
        this.value = value();
    }

    @Override
    public Integer value() {
        return value;
    }
}
