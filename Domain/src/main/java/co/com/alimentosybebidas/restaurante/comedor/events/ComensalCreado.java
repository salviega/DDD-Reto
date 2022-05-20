package co.com.alimentosybebidas.restaurante.comedor.events;

import co.com.alimentosybebidas.restaurante.comedor.values.ComensalId;
import co.com.alimentosybebidas.restaurante.comedor.values.Cuenta;
import co.com.alimentosybebidas.restaurante.comedor.values.Mesa;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.generic.values.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class ComensalCreado extends DomainEvent {
    private ComensalId comensalId;
    private Nombre nombre;
    private Telefono telefono;
    private Mesa mesa;
    private Cuenta cuenta;

    public ComensalCreado(Nombre nombre, Telefono telefono, Mesa mesa, Cuenta cuenta) {
        super("co.com.alimentosybebidas.restaurante.comedor.events.ComensalCreado");
        this.nombre = nombre;
        this.telefono = telefono;
        this.mesa = mesa;
        this.cuenta = cuenta;
    }

    public ComensalId getComensalId() {
        return comensalId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
