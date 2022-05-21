package co.com.alimentosybebidas.restaurante.comedor.cocina;

import co.com.alimentosybebidas.restaurante.cocina.Cocina;
import co.com.alimentosybebidas.restaurante.cocina.command.CrearCocina;
import co.com.alimentosybebidas.restaurante.comedor.Comedor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearCocinaUseCase extends UseCase<RequestCommand<CrearCocina>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCocina> crearCocinaRequestCommand) {
        var command = crearCocinaRequestCommand.getCommand();
        var cocina = new Cocina(command.getCocinaId(), command.getEspacio());
        emit().onResponse(new ResponseEvents(cocina.getUncommittedChanges()));
    }
}
