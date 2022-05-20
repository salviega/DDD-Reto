package co.com.alimentosybebidas.restaurante.comedor.events;

import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class MenuCreado extends DomainEvent {

    private  final MenuId menuId;
    private final Nombre nombre;

    public MenuCreado(MenuId menuId, Nombre nombre) {
       super("co.com.alimentosybebidas.restaurante.comedor.events.MenuCreado");
       this.menuId = menuId;
       this.nombre = nombre;
    }

    public MenuId getMenuId() {
        return menuId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
