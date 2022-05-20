package co.com.alimentosybebidas.restaurante.cocina.events;

import co.com.alimentosybebidas.restaurante.cocina.values.DespensaId;
import co.com.alimentosybebidas.restaurante.cocina.values.Espacio;
import co.com.sofka.domain.generic.DomainEvent;

public class DespensaCreada extends DomainEvent {

    private final DespensaId despensaId;
    private final Espacio espacio;

    public DespensaCreada(DespensaId despensaId, Espacio espacio) {
        super("co.com.alimentosybebidas.restaurante.cocina.events.DespensaCreada");
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
