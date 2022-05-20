package co.com.alimentosybebidas.restaurante.recepcion;

import co.com.alimentosybebidas.restaurante.recepcion.values.Base;
import co.com.alimentosybebidas.restaurante.recepcion.values.CajaId;
import co.com.sofka.domain.generic.Entity;

public class Caja extends Entity<CajaId> {

    protected Base base;

    public Caja(CajaId cajaId, Base base) {
        super(cajaId);
        Base baseMinima = new Base(1000);
        if (base.value() != baseMinima.value()) {
            throw new IllegalArgumentException("La base no está completa");
        }
        this.base = base;
    }
    public Base obtenerVenta() {
        return this.base;
    }
}
