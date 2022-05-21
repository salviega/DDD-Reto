package co.com.alimentosybebidas.restaurante.recepcion;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.alimentosybebidas.restaurante.recepcion.command.CrearRecepcion;

public class CrearRecepcionUseCase extends UseCase<RequestCommand<CrearRecepcion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearRecepcion> crearRecepcionRequestCommand) {
        var command = crearRecepcionRequestCommand.getCommand();

        var recepcion = new Recepcion(command.getRecepcionId(), command.getNombre());

        emit().onResponse(new ResponseEvents(recepcion.getUncommittedChanges()));
    }
}
