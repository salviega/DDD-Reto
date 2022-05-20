package co.com.alimentosybebidas.restaurante.comedor.values;

import co.com.sofka.domain.generic.Identity;

public class ComedorId extends Identity {

    public ComedorId(String id){
        super(id);
    }
    public static ComedorId of(String id) {
        return new ComedorId(id);
    }
}
