package co.com.alimentosybebidas.restaurante.cocina.values;

import co.com.sofka.domain.generic.ValueObject;

public class Insumo implements ValueObject<String> {

    private final String description;

    public  Insumo(String description) {
        this.description = description;
    }
    @Override
    public String value() {
        return this.description;
    }
}
