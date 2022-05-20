package co.com.alimentosybebidas.restaurante.cocina.events;

import co.com.alimentosybebidas.restaurante.cocina.values.Espacio;
import co.com.sofka.domain.generic.DomainEvent;

public class CocinaCreado extends DomainEvent {
    private final Espacio espacio;

    public  CocinaCreado(Espacio espacio) {
        super("co.com.alimentosybebidas.restaurante.cocina.events.CocinaCreado");
        this.espacio = espacio;
    }
    public Espacio getEspacio() {
        return espacio;
    }
}