package co.com.alimentosybebidas.restaurante.cocina.values;

import co.com.sofka.domain.generic.ValueObject;

public class Espacio implements ValueObject<Integer> {

    private final Integer area;

    public Espacio(Integer area) {
        this.area = area;
    }

    @Override
    public Integer value() {
        return area;
    }
}
