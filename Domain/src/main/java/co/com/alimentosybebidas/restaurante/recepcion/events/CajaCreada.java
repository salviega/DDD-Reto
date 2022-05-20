package co.com.alimentosybebidas.restaurante.recepcion.events;

import co.com.alimentosybebidas.restaurante.recepcion.values.Base;
import co.com.alimentosybebidas.restaurante.recepcion.values.CajaId;
import co.com.sofka.domain.generic.DomainEvent;

public class CajaCreada extends DomainEvent {

    private final CajaId cajaId;
    private final Base base;

    public CajaCreada(CajaId cajaId, Base base) {
        super("co.com.alimentosybebidas.restaurante.recepcion.events.CajaCreada");
        this.cajaId = cajaId;
        this.base = base;
    }

    public CajaId getCajaId() {
        return cajaId;
    }

    public Base getBase() {
        return base;
    }
}
