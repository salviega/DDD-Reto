package co.com.alimentosybebidas.restaurante.comedor.values;

import co.com.sofka.domain.generic.ValueObject;

public class Cuenta implements ValueObject<Integer> {

    private final Integer value;

    public Cuenta (Integer cuenta) {
        if (!(cuenta instanceof Integer)) {
            throw new IllegalArgumentException("No es un tipo de cuenta adecuada");
        }
        this.value = cuenta;
    }

    @Override
    public Integer value() {
        return value;
    }
}
