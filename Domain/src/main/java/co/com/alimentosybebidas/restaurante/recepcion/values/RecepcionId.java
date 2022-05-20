package co.com.alimentosybebidas.restaurante.recepcion.values;

import co.com.sofka.domain.generic.Identity;

public class RecepcionId  extends Identity {

    public RecepcionId(String id) {
        super(id);
    }

    public static RecepcionId of(String id) {
        return new RecepcionId(id);
    }
}
