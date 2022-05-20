package co.com.alimentosybebidas.restaurante.recepcion;

import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.recepcion.events.RecepcionCreado;
import co.com.alimentosybebidas.restaurante.recepcion.values.RecepcionId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Recepcion extends AggregateEvent<RecepcionId> {

    protected Nombre nombre;
    protected Manager manager;
    protected Caja caja;

    public Recepcion(RecepcionId recepcionId, Nombre nombre, Manager manager, Caja caja) {
        super(recepcionId);
        appendChange(new RecepcionCreado(nombre)).apply();
        subscribe(new RecepcionEventChange(this));
    }
}
