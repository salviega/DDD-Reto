package co.com.alimentosybebidas.restaurante.comedor.command;

import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.alimentosybebidas.restaurante.comedor.values.Plato;
import co.com.sofka.domain.generic.Command;

public class AgregarPlatoDeMenu extends Command {

    private final MenuId menuId;
    private final Plato plato;

    public  AgregarPlatoDeMenu(MenuId menuId, Plato plato) {
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
