package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashMap;

public class ComedorEventChange extends EventChange {
    public ComedorEventChange(Comedor comedor) {
        apply((ComedorCreado event) -> {
            comedor.nombre = event.getNombre();
            comedor.cartaPlato = new HashMap<>();
        });

        apply((ComensalCreado event) -> {
            var comensalId = event.getComensalId();
            var comensal = new Comensal(comensalId, event.getNombre(), event.getTelefono(), event.getMesa(), event.getCuenta());
            comedor.comensal = comensal;
        });

        apply((MeseroCreado event) -> {
            var meseroId = event.getMeseroId();
            var mesero = new Mesero(meseroId, event.getNombre(), event.getTurno(),event.getMesa(), event.getCuenta());
            comedor.mesero = mesero;

        });

        apply((PlatoAgregadoDeMenu event) ->{
            comedor.cartaPlato.get(event.getMenuId()).agregarPlato(event.getPlato());
        });
        apply((LicorAgregadoDeMenu event) ->{
            comedor.cartaLicor.get(event.getMenuId()).agregarLicor(event.getLicor());
        });
        apply((PostreAgregadoDeMenu event) ->{
            comedor.cartaPlato.get(event.getMenuId()).agregarPostre(event.getPostre());
        });
    }
}
