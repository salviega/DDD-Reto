package co.com.alimentosybebidas.restaurante.recepcion.command;

import co.com.alimentosybebidas.restaurante.recepcion.values.Base;
import co.com.alimentosybebidas.restaurante.recepcion.values.CajaId;
import co.com.alimentosybebidas.restaurante.recepcion.values.RecepcionId;
import co.com.sofka.domain.generic.Command;

public class AgregarCaja extends Command {

    private final RecepcionId recepcionId;
    private final Base base;

    public AgregarCaja(RecepcionId recepcionId, Base base) {
        this.recepcionId = recepcionId;
        this.base = base;
    }

    public RecepcionId getRecepcionId() {
        return recepcionId;
    }

    public Base getBase() {
        return base;
    }
}
