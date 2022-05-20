package co.com.alimentosybebidas.restaurante.comedor.values;

import co.com.alimentosybebidas.restaurante.recepcion.Manager;
import co.com.sofka.domain.generic.ValueObject;

public class Mesa implements ValueObject<Boolean> {

    private Boolean disponibilidad;

    public Mesa(Boolean disponibilidad) {
        if (disponibilidad) {
            this.disponibilidad = false;
        }
        this.disponibilidad = true;
    }
    @Override
    public Boolean value() {
        return this.disponibilidad;
    }
}
