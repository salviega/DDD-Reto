package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.events.*;
import co.com.alimentosybebidas.restaurante.comedor.values.*;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.generic.values.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Comedor extends AggregateEvent<ComedorId> {
    protected Nombre nombre;
    protected Comensal comensal;
    protected Mesero mesero;
    protected Map<MenuId, Menu> menus;

    public Comedor(ComedorId comedorId, Nombre nombre) {
        super(comedorId);
        appendChange(new ComedorCreado(nombre)).apply();
        subscribe(new ComedorEventChange(this));
    }
    private Comedor(ComedorId comedorId) {
        super(comedorId);
        subscribe(new ComedorEventChange(this));
    }

    public static Comedor from(ComedorId comedorId, List<DomainEvent> events) {
        var comedor = new Comedor(comedorId);
        events.forEach(comedor::applyEvent);
        return comedor;
    }
    public void agregarComensal(Nombre nombre, Telefono telefono, Mesa mesa, Cuenta cuenta) {
        var comensalId = new ComensalId();
        appendChange(new ComensalCreado(comensalId, nombre, telefono, mesa, cuenta)).apply();
    }
    public void agregarMesero(Nombre nombre, Mesa mesa, Cuenta cuenta, Turno turno) {
        var meseroId = new MeseroId();
        appendChange(new MeseroCreado(meseroId, nombre, turno, mesa, cuenta)).apply();
    }
    public void agregarMenu(Nombre nombre) {
        var menuId = new MenuId();
        appendChange(new MenuCreado(menuId, nombre)).apply();
    }
    public void platoAgregadoDeMenu(MenuId menuId, Plato plato) {
        appendChange(new PlatoAgregadoDeMenu(menuId, plato)).apply();
    }
    public void licorAgregadoDeMenu(MenuId menuId, Licor licor) {
        appendChange(new LicorAgregadoDeMenu(menuId, licor)).apply();
    }
    public void postreAgregadoDeMenu(MenuId menuId, Postre postre) {
        appendChange(new PostreAgregadoDeMenu(menuId, postre)).apply();
    }
}

