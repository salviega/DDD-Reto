package co.com.alimentosybebidas.restaurante.recepcion.events;

import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.recepcion.Manager;
import co.com.alimentosybebidas.restaurante.recepcion.Recepcion;
import co.com.sofka.domain.generic.DomainEvent;

public class RecepcionCreado extends DomainEvent {

    private Nombre nombre;
    public RecepcionCreado(Nombre nombre) {
        super("co.com.alimentosybebidas.restaurante.recepcion.RecepcionCreado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
