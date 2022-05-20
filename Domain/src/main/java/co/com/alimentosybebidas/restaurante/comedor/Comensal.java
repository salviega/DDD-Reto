package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.values.ComensalId;
import co.com.alimentosybebidas.restaurante.comedor.values.Cuenta;
import co.com.alimentosybebidas.restaurante.comedor.values.Mesa;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.generic.values.Telefono;
import co.com.sofka.domain.generic.Entity;

public class Comensal extends Entity<ComensalId> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected Mesa mesa;
    protected Cuenta cuenta;

    public Comensal(ComensalId comensalId, Nombre nombre, Telefono telefono, Mesa mesa, Cuenta cuenta) {
        super(comensalId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.mesa = mesa;
        this.cuenta = cuenta;
    }

    //Comportamientos
}
