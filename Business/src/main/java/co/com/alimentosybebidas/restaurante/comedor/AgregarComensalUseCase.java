package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.command.AgregarComensal;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarComensalUseCase extends UseCase<RequestCommand<AgregarComensal>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarComensal> agregarComensalRequestCommand) {
        var command = agregarComensalRequestCommand.getCommand();
        var comedor = Comedor.from(
                command.getComedorId(), repository().getEventsBy(command.getComedorId().value())
        );
        comedor.agregarComensal(command.getNombre(), command.getTelefono(), command.getMesa(), command.getCuenta());
        emit().onResponse(new ResponseEvents(comedor.getUncommittedChanges()));
    }
}
