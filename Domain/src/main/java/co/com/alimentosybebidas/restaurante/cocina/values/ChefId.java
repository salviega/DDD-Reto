package co.com.alimentosybebidas.restaurante.cocina.values;

import co.com.sofka.domain.generic.Identity;

public class ChefId extends Identity {

    public ChefId(String id) {
        super(id);
    }

    public static ChefId of(String id) {
        return  new ChefId(id);
    }

}