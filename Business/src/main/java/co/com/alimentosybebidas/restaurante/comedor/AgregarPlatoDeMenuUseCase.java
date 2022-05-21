package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.command.AgregarPlatoDeMenu;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarPlatoDeMenuUseCase extends UseCase<RequestCommand<AgregarPlatoDeMenu>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPlatoDeMenu> agregarPlatoDeMenuRequestCommand) {
        var command = agregarPlatoDeMenuRequestCommand.getCommand();
        var comedor = Comedor.from(
                command.getComedorId(), repository().getEventsBy(command.getComedorId().value())
                );

        comedor.platoAgregadoDeMenu(command.getMenuId(), command.getPlato());
        emit().onResponse(new ResponseEvents(comedor.getUncommittedChanges()));
    }
}
