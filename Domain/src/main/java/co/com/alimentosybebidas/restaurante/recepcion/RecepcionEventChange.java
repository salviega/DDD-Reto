package co.com.alimentosybebidas.restaurante.recepcion;

import co.com.alimentosybebidas.restaurante.recepcion.events.CajaCreada;
import co.com.alimentosybebidas.restaurante.recepcion.events.ManagerCreado;
import co.com.alimentosybebidas.restaurante.recepcion.events.RecepcionCreado;
import co.com.sofka.domain.generic.EventChange;

public class RecepcionEventChange extends EventChange {

    public RecepcionEventChange(Recepcion recepcion) {
        apply((RecepcionCreado event) -> {
            recepcion.nombre = event.getNombre();
        });

        apply((CajaCreada event) -> {
            var cajaId = event.getCajaId();
            var caja = new Caja(cajaId, event.getBase());
            if (!(caja instanceof Caja)) {
                throw new IllegalArgumentException("La caja no es correcta");
            }
            recepcion.caja = caja;
        });

        apply((ManagerCreado event) -> {
            var managerId = event.getManagerId();
            var manager = new Manager(managerId, event.getNombre(), event.getTelefono(), event.getReservacion());
            if (!(manager instanceof Manager)) {
                throw new IllegalArgumentException("No es un objecto válido");
            }
            recepcion.manager = manager;
        });
    }
}
