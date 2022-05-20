package co.com.alimentosybebidas.restaurante.comedor.events;

import co.com.alimentosybebidas.restaurante.comedor.Menu;
import co.com.alimentosybebidas.restaurante.comedor.values.Licor;
import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.sofka.domain.generic.DomainEvent;

public class LicorAgregadoDeMenu extends DomainEvent {
    private final MenuId menuId;
    private final Licor licor;

    public  LicorAgregadoDeMenu(MenuId menuId, Licor licor) {
        super("co.com.alimentosybebidas.restaurante.comedor.events.LicorAgregadoDeMenu");
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
