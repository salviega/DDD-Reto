package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.command.AgregarPostreDeMenu;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.nio.charset.CoderMalfunctionError;

public class AgregarPostreDeMenuUseCase extends UseCase<RequestCommand<AgregarPostreDeMenu>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarPostreDeMenu> agregarPostreDeMenuRequestCommand) {
        var command = agregarPostreDeMenuRequestCommand.getCommand();
        var comedor = Comedor.from(
                command.getComedorId(), repository().getEventsBy(command.getComedorId().value())
        );

        comedor.postreAgregadoDeMenu(command.getMenuId(), command.getPostre());
        emit().onResponse(new ResponseEvents(comedor.getUncommittedChanges()));
    }
}
