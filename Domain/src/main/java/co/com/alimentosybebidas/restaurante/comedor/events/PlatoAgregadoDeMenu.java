package co.com.alimentosybebidas.restaurante.comedor.events;

import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.alimentosybebidas.restaurante.comedor.values.Plato;
import co.com.sofka.domain.generic.DomainEvent;

public class PlatoAgregadoDeMenu extends DomainEvent {

    private final MenuId menuId;
    private final Plato plato;

    public  PlatoAgregadoDeMenu(MenuId menuId, Plato plato) {
        super("co.com.alimentosybebidas.restaurante.comedor.events.PlatoAgregadoDeMenu");
        this.menuId = menuId;
        this.plato = plato;
    }

    public MenuId getMenuId() {
        return menuId;
    }

    public Plato getPlato() {
        return plato;
    }
}
