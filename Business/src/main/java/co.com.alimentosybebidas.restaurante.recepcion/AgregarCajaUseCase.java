package co.com.alimentosybebidas.restaurante.recepcion;

import co.com.alimentosybebidas.restaurante.recepcion.command.AgregarCaja;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarCajaUseCase extends UseCase<RequestCommand<AgregarCaja>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCaja> agregarCajaRequestCommand) {
        var command = agregarCajaRequestCommand.getCommand();
        var recepcion = Recepcion.from(
                command.getRecepcionId(), repository().getEventsBy(command.getRecepcionId().value())
        );
        recepcion.agregarCaja(command.getBase());

        emit().onResponse(new ResponseEvents(recepcion.getUncommittedChanges()));
    }
}
