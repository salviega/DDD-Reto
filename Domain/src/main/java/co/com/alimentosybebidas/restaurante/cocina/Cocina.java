package co.com.alimentosybebidas.restaurante.cocina;

import co.com.alimentosybebidas.restaurante.cocina.events.CocinaCreado;
import co.com.alimentosybebidas.restaurante.cocina.values.CocinaId;
import co.com.alimentosybebidas.restaurante.cocina.values.Espacio;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.domain.generic.AggregateEvent;

public class Cocina extends AggregateEvent<CocinaId> {
    protected Espacio espacio;
    protected Chef chef;
    protected Despensa despensa;

    public Cocina(CocinaId cocinaId, Espacio espacio) {
        super(cocinaId);
        appendChange(new CocinaCreado(espacio)).apply();
        subscribe(new CocinaEventChange(this));
    }
}
