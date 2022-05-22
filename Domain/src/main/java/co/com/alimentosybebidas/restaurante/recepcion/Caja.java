package co.com.alimentosybebidas.restaurante.recepcion;

import co.com.alimentosybebidas.restaurante.recepcion.values.Base;
import co.com.alimentosybebidas.restaurante.recepcion.values.CajaId;
import co.com.sofka.domain.generic.Entity;

public class Caja extends Entity<CajaId> {

    protected Base base;

    public Caja(CajaId cajaId, Base base) {
        super(cajaId);
        this.base = base;
    }
    public Base obtenerVenta() {
        return this.base;
    }
}
