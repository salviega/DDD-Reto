package co.com.alimentosybebidas.restaurante.comedor.command;

import co.com.alimentosybebidas.restaurante.comedor.values.Licor;
import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.sofka.domain.generic.Command;

public class AgregarLicorDeMenu extends Command {
    private final MenuId menuId;
    private final Licor licor;

    public  AgregarLicorDeMenu(MenuId menuId, Licor licor) {
        this.menuId = menuId;
        this.licor = licor;
    }

    public MenuId getMenuId() {
        return menuId;
    }

    public Licor getLicor() {
        return licor;
    }
}
