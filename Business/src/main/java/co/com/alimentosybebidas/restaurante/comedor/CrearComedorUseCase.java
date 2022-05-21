package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.command.CrearComedor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearComedorUseCase extends UseCase<RequestCommand<CrearComedor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearComedor> crearComedorRequestCommand) {
        var command = crearComedorRequestCommand.getCommand();
        var comedor = new Comedor(
                command.getComedorId(),
                command.getNombre());
        emit().onResponse(new ResponseEvents(comedor.getUncommittedChanges()));
    }
}
