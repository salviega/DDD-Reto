package co.com.alimentosybebidas.restaurante.cocina;

import co.com.alimentosybebidas.restaurante.cocina.events.ChefCreado;
import co.com.alimentosybebidas.restaurante.cocina.events.CocinaCreado;
import co.com.alimentosybebidas.restaurante.cocina.events.DespensaCreada;
import co.com.alimentosybebidas.restaurante.cocina.values.ChefId;
import co.com.alimentosybebidas.restaurante.cocina.values.CocinaId;
import co.com.alimentosybebidas.restaurante.cocina.values.DespensaId;
import co.com.alimentosybebidas.restaurante.cocina.values.Espacio;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.generic.values.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Cocina extends AggregateEvent<CocinaId> {
    protected Espacio espacio;
    protected Chef chef;
    protected Despensa despensa;

    public Cocina(CocinaId cocinaId, Espacio espacio) {
        super(cocinaId);
        appendChange(new CocinaCreado(espacio)).apply();
        subscribe(new CocinaEventChange(this));
    }

    private Cocina(CocinaId cocinaId){
        super(cocinaId);
        subscribe(new CocinaEventChange(this));
    }

    public static Cocina from(CocinaId cocinaId, List<DomainEvent> events){
        var cocina = new Cocina(cocinaId);
        events.forEach(cocina::applyEvent);
        return cocina;
    }
    public void agregarChef(Nombre nombre, Telefono telefono) {
        var chefId =new ChefId();
        appendChange(new ChefCreado(chefId, nombre, telefono)).apply();
    }
    public void agregarDespensa(Espacio espacio) {
        var despensaId =new DespensaId();
        appendChange(new DespensaCreada(despensaId, espacio)).apply();
    }

}
