package co.com.alimentosybebidas.restaurante.generic.values;

import co.com.sofka.domain.generic.ValueObject;

public class Telefono implements ValueObject<String> {
    private final String value;

    public Telefono(String value) {
        if (value.length() != 10) {
            throw new IllegalArgumentException("La cantidad de numeros es erronea");
        }
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}

