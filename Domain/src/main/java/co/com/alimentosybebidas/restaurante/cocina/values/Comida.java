package co.com.alimentosybebidas.restaurante.cocina.values;

import co.com.sofka.domain.generic.ValueObject;

public class Comida implements ValueObject<String> {

    private final String description;

    public Comida(String description) { this.description = description; }


    @Override
    public String value() {
        return this.description;
    }
}
