package co.com.alimentosybebidas.restaurante.comedor.values;

import co.com.sofka.domain.generic.Identity;

public class ComensalId extends Identity {

    public ComensalId(String id) {super(id);}

    public static ComensalId of(String id) {
        return new ComensalId(id);
    }
}
