package co.com.alimentosybebidas.restaurante.cocina;

import co.com.alimentosybebidas.restaurante.cocina.values.DespensaId;
import co.com.alimentosybebidas.restaurante.cocina.values.Espacio;
import co.com.alimentosybebidas.restaurante.cocina.values.Insumo;
import co.com.sofka.domain.generic.Entity;

import java.util.HashSet;
import java.util.Set;

public class Despensa extends Entity<DespensaId> {

    protected Espacio espacio;
    protected Set<Insumo> insumos;

    public Despensa(DespensaId entityId, Espacio espacio) {
        super(entityId);
        this.espacio = espacio;
        this.insumos = new HashSet<>();
    }

    //comportamiento

}
