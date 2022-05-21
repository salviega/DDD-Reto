package co.com.alimentosybebidas.restaurante.recepcion.command;

import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.recepcion.Recepcion;
import co.com.alimentosybebidas.restaurante.recepcion.values.RecepcionId;
import co.com.sofka.domain.generic.Command;

public class CrearRecepcion  extends Command {
    private RecepcionId recepcionId;
    private Nombre nombre;
    public CrearRecepcion(RecepcionId recepcionId, Nombre nombre) {

        this.recepcionId = recepcionId;
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public RecepcionId getRecepcionId() {
        return recepcionId;
    }
}
