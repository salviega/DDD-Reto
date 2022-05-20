package co.com.alimentosybebidas.restaurante.comedor.events;

import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.alimentosybebidas.restaurante.comedor.values.Postre;
import co.com.sofka.domain.generic.DomainEvent;

public class PostreAgregadoDeMenu extends DomainEvent {
    private final MenuId menuId;
    private final Postre postre;

    public PostreAgregadoDeMenu(MenuId menuId, Postre postre) {
        super("co.com.alimentosybebidas.restaurante.comedor.events.PostreAgregadoDeMenu");
        this.menuId = menuId;
        this.postre = postre;
    }

    public Postre getPostre() {
        return postre;
    }

    public MenuId getMenuId() {
        return menuId;
    }
}
