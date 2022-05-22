package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.command.AgregarMenu;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarMenuUseCase extends UseCase<RequestCommand<AgregarMenu>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMenu> agregarMenuRequestCommand) {
        var command = agregarMenuRequestCommand.getCommand();
        var comedor = Comedor.from(
                command.getComedorId(), repository().getEventsBy(command.getComedorId().value())
        );
        comedor.agregarMenu(command.getNombre());
        emit().onResponse(new ResponseEvents(comedor.getUncommittedChanges()));

    }
}
