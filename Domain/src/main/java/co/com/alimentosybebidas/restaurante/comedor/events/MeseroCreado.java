package co.com.alimentosybebidas.restaurante.comedor.events;

import co.com.alimentosybebidas.restaurante.comedor.values.Cuenta;
import co.com.alimentosybebidas.restaurante.comedor.values.Mesa;
import co.com.alimentosybebidas.restaurante.comedor.values.MeseroId;
import co.com.alimentosybebidas.restaurante.comedor.values.Turno;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class MeseroCreado extends DomainEvent {

    private MeseroId meseroId;
    private Nombre nombre;
    private Turno turno;
    private Mesa mesa;
    private Cuenta cuenta;

    public MeseroCreado(MeseroId meseroId, Nombre nombre, Turno turno, Mesa mesa, Cuenta cuenta) {
        super("co.com.alimentosybebidas.restaurante.comedor.events.MeseroCreado");
        this.meseroId = meseroId;
        this.nombre = nombre;
        this.turno = turno;
        this.mesa = mesa;
        this.cuenta = cuenta;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Turno getTurno() {
        return turno;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public MeseroId getMeseroId() {
        return meseroId;
    }
}
