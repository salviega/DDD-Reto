package co.com.alimentosybebidas.restaurante.cocina.events;

import co.com.alimentosybebidas.restaurante.cocina.values.ChefId;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.generic.values.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class ChefCreado extends DomainEvent {

    private final ChefId chefId;
    private final Nombre nombre;
    private final Telefono telefono;

    public ChefCreado(ChefId chefId, Nombre nombre, Telefono telefono) {
        super("co.com.alimentosybebidas.restaurante.cocina.events.ChefCreado");
        this.chefId = chefId;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public ChefId getChefId() {
        return chefId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
