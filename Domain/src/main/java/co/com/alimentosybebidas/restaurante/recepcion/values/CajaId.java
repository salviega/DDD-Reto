package co.com.alimentosybebidas.restaurante.recepcion.values;

import co.com.sofka.domain.generic.Identity;

public class CajaId extends Identity {

    public CajaId(String id) {
        super(id);
    }
    public CajaId(){

    }

    public static CajaId of(String id) {
        return new CajaId(id);
    }
}