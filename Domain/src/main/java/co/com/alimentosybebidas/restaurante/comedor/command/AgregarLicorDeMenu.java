package co.com.alimentosybebidas.restaurante.comedor.command;

import co.com.alimentosybebidas.restaurante.comedor.values.ComedorId;
import co.com.alimentosybebidas.restaurante.comedor.values.Licor;
import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.sofka.domain.generic.Command;

public class AgregarLicorDeMenu extends Command {

    private final ComedorId comedorId;
    private final MenuId menuId;
    private final Licor licor;

    public  AgregarLicorDeMenu(ComedorId comedorId, MenuId menuId, Licor licor) {
        this.comedorId = comedorId;
        this.menuId = menuId;
        this.licor = licor;
    }

    public ComedorId getComedorId() {
        return comedorId;
    }
    public MenuId getMenuId() {
        return menuId;
    }

    public Licor getLicor() {
        return licor;
    }
}
