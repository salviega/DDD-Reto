package co.com.alimentosybebidas.restaurante.cocina;

import co.com.alimentosybebidas.restaurante.cocina.values.ChefId;
import co.com.alimentosybebidas.restaurante.cocina.values.Comida;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.generic.values.Telefono;
import co.com.sofka.domain.generic.Entity;

import java.util.HashSet;
import java.util.Set;

public class Chef extends Entity<ChefId> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected Set<Comida> comidas;

    public Chef(ChefId chefId, Nombre nombre, Telefono telefono) {
        super(chefId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.comidas = new HashSet<>();
    }

    //comportamientos
}
