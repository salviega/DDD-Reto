package co.com.alimentosybebidas.restaurante.cocina.command;

import co.com.alimentosybebidas.restaurante.cocina.values.DespensaId;
import co.com.alimentosybebidas.restaurante.cocina.values.Espacio;
import co.com.sofka.domain.generic.Command;

public class AgregarDespensa extends Command {
    private final DespensaId despensaId;
    private final Espacio espacio;

    public AgregarDespensa(DespensaId despensaId, Espacio espacio) {
        this.despensaId = despensaId;
        this.espacio = espacio;
    }

    public DespensaId getDespensaId() {
        return despensaId;
    }

    public Espacio getEspacio() {
        return espacio;
    }
}
