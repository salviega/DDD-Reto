package co.com.alimentosybebidas.restaurante.comedor.values;

import co.com.sofka.domain.generic.ValueObject;

public class Turno implements ValueObject<Boolean> {

    private Boolean activo;

    public Turno(Boolean activo) {

        if (activo) {
            this.activo = false;
        }
        this.activo = true;
    }

    @Override
    public Boolean value() {
        return activo;
    }
}
