package co.com.alimentosybebidas.restaurante.cocina;

import co.com.alimentosybebidas.restaurante.cocina.events.ChefCreado;
import co.com.alimentosybebidas.restaurante.cocina.events.CocinaCreado;
import co.com.alimentosybebidas.restaurante.cocina.events.DespensaCreada;
import co.com.sofka.domain.generic.EventChange;

public class CocinaEventChange extends EventChange {
    public CocinaEventChange(Cocina cocina) {
        apply((CocinaCreado event) -> {
            cocina.espacio = event.getEspacio();
        });
        apply((ChefCreado event) -> {
            var chefId = event.getChefId();
            var chef = new Chef(chefId, event.getNombre(), event.getTelefono());
            cocina.chef = chef;
        });
        apply((DespensaCreada event) -> {
            var despensaId = event.getDespensaId();
            var despensa = new Despensa(despensaId, event.getEspacio());
            cocina.despensa = despensa;
        });
    }
}
