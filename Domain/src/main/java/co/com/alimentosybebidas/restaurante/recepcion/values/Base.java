package co.com.alimentosybebidas.restaurante.recepcion.values;

import co.com.sofka.domain.generic.ValueObject;

public class Base implements ValueObject<String> {

    private final String value;

    public Base(String value) {

        this.value = value();
    }

    @Override
    public String value() {
        return value;
    }
}
