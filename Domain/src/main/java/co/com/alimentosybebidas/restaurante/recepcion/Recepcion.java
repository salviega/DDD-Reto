package co.com.alimentosybebidas.restaurante.recepcion;

import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.generic.values.Telefono;
import co.com.alimentosybebidas.restaurante.recepcion.events.CajaCreada;
import co.com.alimentosybebidas.restaurante.recepcion.events.ManagerCreado;
import co.com.alimentosybebidas.restaurante.recepcion.events.RecepcionCreado;
import co.com.alimentosybebidas.restaurante.recepcion.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;
import java.util.prefs.BackingStoreException;

public class Recepcion extends AggregateEvent<RecepcionId> {

    protected Nombre nombre;
    protected Manager manager;
    protected Caja caja;

    public Recepcion(RecepcionId recepcionId, Nombre nombre) {
        super(recepcionId);
        appendChange(new RecepcionCreado(nombre)).apply();
        subscribe(new RecepcionEventChange(this));
    }

    private Recepcion(RecepcionId recepcionId) {
        super(recepcionId);
        subscribe(new RecepcionEventChange(this));
    }
    public static  Recepcion from(RecepcionId recepcionId, List<DomainEvent> events) {
        var recepcion = new Recepcion(recepcionId);
        events.forEach(recepcion::applyEvent);
        return recepcion;
    }
    public void agregarManager(Nombre nombre, Telefono telefono, Reservacion reservacion) {
        var managerId = new ManagerId();
        appendChange(new ManagerCreado(managerId, nombre, telefono, reservacion)).apply();
    }

    public void agregarCaja(Base base) {
        var cajaId = new CajaId();
        appendChange(new CajaCreada(cajaId, base)).apply();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Manager manager(){
        return manager;
    }

    public Caja caja(){
        return caja;
    }

}
