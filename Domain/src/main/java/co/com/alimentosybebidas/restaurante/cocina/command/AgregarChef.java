package co.com.alimentosybebidas.restaurante.cocina.command;

import co.com.alimentosybebidas.restaurante.cocina.values.ChefId;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.generic.values.Telefono;
import co.com.sofka.domain.generic.Command;

public class AgregarChef extends Command {
    private final ChefId chefId;
    private final Nombre nombre;
    private final Telefono telefono;

    public AgregarChef(ChefId chefId, Nombre nombre, Telefono telefono) {
        this.chefId = chefId;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public ChefId getChefId() {
        return chefId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
