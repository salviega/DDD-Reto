package co.com.alimentosybebidas.restaurante.comedor.command;

import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class AgregarMenu extends Command {

    private  final MenuId menuId;
    private final Nombre nombre;

    public AgregarMenu(MenuId menuId, Nombre nombre) {
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
