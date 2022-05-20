package co.com.alimentosybebidas.restaurante.recepcion.command;

import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.generic.values.Telefono;
import co.com.alimentosybebidas.restaurante.recepcion.values.ManagerId;
import co.com.alimentosybebidas.restaurante.recepcion.values.Reservacion;
import co.com.sofka.domain.generic.Command;

public class AgregarManager extends Command {

    private final ManagerId managerId;
    private Nombre nombre;
    private Telefono telefono;
    private Reservacion reservacion;

    public AgregarManager(ManagerId managerId, Nombre nombre, Telefono telefono, Reservacion reservacion) {
        this.managerId = managerId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.reservacion = reservacion;
    }

    public ManagerId getManagerId() {
        return managerId;
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

