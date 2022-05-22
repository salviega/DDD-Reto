package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.command.AgregarMesero;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarMeseroUseCase  extends UseCase<RequestCommand<AgregarMesero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMesero> agregarMeseroRequestCommand) {
        var command = agregarMeseroRequestCommand.getCommand();
        var comedor = Comedor.from(
                command.getComedorId(), repository().getEventsBy(command.getComedorId().value())
        );
        comedor.agregarMesero(command.getNombre(), command.getMesa(), command.getCuenta(), command.getTurno());

        emit().onResponse(new ResponseEvents(comedor.getUncommittedChanges()));
    }
}
