package co.com.alimentosybebidas.restaurante.recepcion.values;

import co.com.sofka.domain.generic.ValueObject;

public class Reservacion implements ValueObject<Boolean> {

    private final Boolean reservado;

    public Reservacion(Boolean reservado) {
        this.reservado = reservado;
    }

    @Override
    public Boolean value() {
        return this.reservado;
    }
}
