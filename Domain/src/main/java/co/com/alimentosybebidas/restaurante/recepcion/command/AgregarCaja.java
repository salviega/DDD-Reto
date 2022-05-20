package co.com.alimentosybebidas.restaurante.recepcion.command;

import co.com.alimentosybebidas.restaurante.recepcion.values.Base;
import co.com.alimentosybebidas.restaurante.recepcion.values.CajaId;
import co.com.sofka.domain.generic.Command;

public class AgregarCaja extends Command {

    private final CajaId cajaId;
    private final Base base;

    public AgregarCaja(CajaId cajaId, Base base) {
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
