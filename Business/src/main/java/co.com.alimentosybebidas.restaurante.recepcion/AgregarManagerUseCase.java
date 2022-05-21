package co.com.alimentosybebidas.restaurante.recepcion;

import co.com.alimentosybebidas.restaurante.recepcion.command.AgregarManager;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sun.net.httpserver.Request;

public class AgregarManagerUseCase extends UseCase<RequestCommand<AgregarManager>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarManager> agregarManagerRequestCommand) {
        var command = agregarManagerRequestCommand.getCommand();
        var recepcion = Recepcion.from(
                command.getRecepcionId(), repository().getEventsBy(command.getRecepcionId().value())
        );
        recepcion.agregarManager(command.getNombre(), command.getTelefono(), command.getReservacion());

        emit().onResponse(new ResponseEvents(recepcion.getUncommittedChanges()));
    }
}
