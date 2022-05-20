package co.com.alimentosybebidas.restaurante.recepcion.values;

import co.com.sofka.domain.generic.Identity;

public class ManagerId extends Identity {

    public ManagerId(String id) {
        super(id);
    }

    public static ManagerId of(String id) {
        return new ManagerId(id);
    }
}
