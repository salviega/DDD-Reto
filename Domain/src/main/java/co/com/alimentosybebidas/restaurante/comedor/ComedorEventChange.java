package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashMap;

public class ComedorEventChange extends EventChange {
    public ComedorEventChange(Comedor comedor) {
        apply((ComedorCreado event) -> {
            comedor.nombre = event.getNombre();
            comedor.menus = new HashMap<>();
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

        apply((MenuCreado event) -> {
            var menuId = event.getMenuId();
            var menu = new Menu(menuId, event.getNombre());
            comedor.menus.put(menuId, menu);
        });


        apply((PlatoAgregadoDeMenu event) ->{
            comedor.menus.get(event.getMenuId()).agregarPlato(event.getPlato());
        });
        apply((LicorAgregadoDeMenu event) ->{
            comedor.menus.get(event.getMenuId()).agregarLicor(event.getLicor());
        });
        apply((PostreAgregadoDeMenu event) ->{
            comedor.menus.get(event.getMenuId()).agregarPostre(event.getPostre());
        });
    }
}
