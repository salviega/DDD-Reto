package co.com.alimentosybebidas.restaurante.recepcion.command;

import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.generic.values.Telefono;
import co.com.alimentosybebidas.restaurante.recepcion.values.ManagerId;
import co.com.alimentosybebidas.restaurante.recepcion.values.RecepcionId;
import co.com.alimentosybebidas.restaurante.recepcion.values.Reservacion;
import co.com.sofka.domain.generic.Command;

public class AgregarManager extends Command {

    private final RecepcionId recepcionId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Reservacion reservacion;

    public AgregarManager(RecepcionId recepcionId, Nombre nombre, Telefono telefono, Reservacion reservacion) {
        this.recepcionId = recepcionId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.reservacion = reservacion;
    }

    public RecepcionId getRecepcionId() {
        return recepcionId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Reservacion getReservacion() {
        return reservacion;
    }
}

