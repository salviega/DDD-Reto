package co.com.alimentosybebidas.restaurante.comedor.command;

import co.com.alimentosybebidas.restaurante.comedor.values.ComedorId;
import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.alimentosybebidas.restaurante.comedor.values.Postre;
import co.com.sofka.domain.generic.Command;

public class AgregarPostreDeMenu extends Command {

    private final ComedorId comedorId;
    private final MenuId menuId;
    private final Postre postre;

    public AgregarPostreDeMenu(ComedorId comedorId, MenuId menuId, Postre postre) {
        this.comedorId = comedorId;
        this.menuId = menuId;
        this.postre = postre;
    }

    public ComedorId getComedorId() {
        return comedorId;
    }
    public Postre getPostre() {
        return postre;
    }

    public MenuId getMenuId() {
        return menuId;
    }
}
