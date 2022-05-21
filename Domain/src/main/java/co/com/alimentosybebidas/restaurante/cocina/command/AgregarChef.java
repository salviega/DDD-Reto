package co.com.alimentosybebidas.restaurante.cocina.command;

import co.com.alimentosybebidas.restaurante.cocina.values.ChefId;
import co.com.alimentosybebidas.restaurante.cocina.values.CocinaId;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.generic.values.Telefono;
import co.com.sofka.domain.generic.Command;

public class AgregarChef extends Command {
    private final CocinaId cocinaId;
    private final Nombre nombre;
    private final Telefono telefono;

    public AgregarChef(CocinaId cocinaId, Nombre nombre, Telefono telefono) {
        this.cocinaId = cocinaId;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public CocinaId getCocinaId() {
        return cocinaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
