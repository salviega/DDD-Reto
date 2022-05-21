package co.com.alimentosybebidas.restaurante.comedor.command;

import co.com.alimentosybebidas.restaurante.comedor.values.ComedorId;
import co.com.alimentosybebidas.restaurante.comedor.values.ComensalId;
import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class AgregarMenu extends Command {

    private  final ComedorId comedorId;
    private final Nombre nombre;

    public AgregarMenu(ComedorId comedorId, Nombre nombre) {
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
