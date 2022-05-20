package co.com.alimentosybebidas.restaurante.cocina.values;

import co.com.sofka.domain.generic.Identity;

public class CocinaId extends Identity {
    public CocinaId(String id){
        super(id);
    }
    public static CocinaId of(String id) {
        return new CocinaId(id);
    }
}
