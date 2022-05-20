package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.values.Cuenta;
import co.com.alimentosybebidas.restaurante.comedor.values.Mesa;
import co.com.alimentosybebidas.restaurante.comedor.values.MeseroId;
import co.com.alimentosybebidas.restaurante.comedor.values.Turno;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.domain.generic.Entity;

public class Mesero extends Entity<MeseroId> {

    protected Nombre nombre;
    protected Turno turno;
    protected Mesa mesa;
    protected Cuenta cuenta;

    public Mesero(MeseroId meseroId,Nombre nombre, Turno turno, Mesa mesa, Cuenta cuenta) {
        super(meseroId);
        this.nombre = nombre;
        this.turno = turno;
        this.mesa = mesa;
        this.cuenta = cuenta;
    }
    public void HacerOrden() {

    }
}
