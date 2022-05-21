package co.com.alimentosybebidas.restaurante.comedor.values;

import co.com.alimentosybebidas.restaurante.comedor.Mesero;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;

public class MeseroId extends Identity {

    public MeseroId(String id){
        super(id);
    }
    public MeseroId(){}
    public static MeseroId of(String id) {
        return new MeseroId(id);
    }
}
