package co.com.alimentosybebidas.restaurante.comedor.command;

import co.com.alimentosybebidas.restaurante.comedor.Comedor;
import co.com.alimentosybebidas.restaurante.comedor.values.ComedorId;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class CrearComedor extends Command {

    private final ComedorId comedorId;
    private final Nombre nombre;

    public CrearComedor(ComedorId comedorId, Nombre nombre) {
    this.comedorId = comedorId;
    this.nombre = nombre;
    }

    public ComedorId getComedorId() {
        return comedorId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

