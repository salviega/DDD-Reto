package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.values.Licor;
import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.alimentosybebidas.restaurante.comedor.values.Plato;
import co.com.alimentosybebidas.restaurante.comedor.values.Postre;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.domain.generic.Entity;

import java.util.HashSet;
import java.util.Set;

public class Menu extends Entity<MenuId> {

    protected Nombre nombre;
    protected Set<Plato> platos;
    protected Set<Licor> licores;
    protected Set<Postre> postres;
    public Menu(MenuId menuId, Nombre nombre) {
        super(menuId);
        this.nombre = nombre;
        this.platos = new HashSet<>();
        this.licores = new HashSet<>();
        this.postres = new HashSet<>();
    }

    public void agregarPlato(Plato plato) {
        this.platos.add(plato);
    }
    public void agregarLicor(Licor licor) {
        this.licores.add(licor);
    }
    public void agregarPostre(Postre postre) {
        this.postres.add(postre);
    }
}
