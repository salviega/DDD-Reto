package co.com.alimentosybebidas.restaurante.comedor.command;

import co.com.alimentosybebidas.restaurante.comedor.values.ComedorId;
import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.alimentosybebidas.restaurante.comedor.values.Plato;
import co.com.sofka.domain.generic.Command;

public class AgregarPlatoDeMenu extends Command {

    private final ComedorId comedorId;
    private final MenuId menuId;
    private final Plato plato;

    public  AgregarPlatoDeMenu(ComedorId comedorId, MenuId menuId, Plato plato) {
        this.comedorId = comedorId;
        this.menuId = menuId;
        this.plato = plato;
    }

    public ComedorId getComedorId() {
        return comedorId;
    }
    public MenuId getMenuId() {
        return menuId;
    }

    public Plato getPlato() {
        return plato;
    }
}
