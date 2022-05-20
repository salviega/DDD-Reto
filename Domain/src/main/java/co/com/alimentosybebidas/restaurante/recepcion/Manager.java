package co.com.alimentosybebidas.restaurante.recepcion;

import co.com.alimentosybebidas.restaurante.comedor.values.ComensalId;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.generic.values.Telefono;
import co.com.alimentosybebidas.restaurante.recepcion.values.ManagerId;
import co.com.alimentosybebidas.restaurante.recepcion.values.Reservacion;
import co.com.sofka.domain.generic.Entity;

import java.awt.*;

public class Manager extends Entity<ManagerId> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected Reservacion reservacion;

    public Manager(ManagerId managerId, Nombre nombre, Telefono telefono, Reservacion reservacion) {
        super(managerId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.reservacion = reservacion;
    }

    public Boolean darMesa(ComensalId comensalId) {
        if (comensalId instanceof ComensalId ) {
            return false;
        }
        return true;
    }

}
