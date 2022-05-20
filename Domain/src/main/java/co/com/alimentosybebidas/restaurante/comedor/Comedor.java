package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.events.ComedorCreado;
import co.com.alimentosybebidas.restaurante.comedor.events.LicorAgregadoDeMenu;
import co.com.alimentosybebidas.restaurante.comedor.events.PlatoAgregadoDeMenu;
import co.com.alimentosybebidas.restaurante.comedor.events.PostreAgregadoDeMenu;
import co.com.alimentosybebidas.restaurante.comedor.values.*;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;

public class Comedor extends AggregateEvent<ComedorId> {
    protected Nombre nombre;
    protected Comensal comensal;
    protected Mesero mesero;
    protected Map<MenuId, Menu> cartaPlato;
    protected Map<MenuId, Menu> cartaLicor;
    protected Map<MenuId, Menu> cartaPostre;

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

