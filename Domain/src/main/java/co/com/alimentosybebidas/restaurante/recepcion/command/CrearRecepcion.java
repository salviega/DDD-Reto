package co.com.alimentosybebidas.restaurante.recepcion.command;

import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class CrearRecepcion  extends Command {
    private Nombre nombre;
    public CrearRecepcion(Nombre nombre) {
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
