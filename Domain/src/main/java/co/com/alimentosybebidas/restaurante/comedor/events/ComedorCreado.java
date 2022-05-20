package co.com.alimentosybebidas.restaurante.comedor.events;

import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class ComedorCreado extends DomainEvent {

    private final Nombre nombre;

    public ComedorCreado(Nombre nombre) {
        super("co.com.alimentosybebidas.restaurante.comedor.events.ComedorCreado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
