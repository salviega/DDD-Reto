package co.com.alimentosybebidas.restaurante.comedor.cocina;

import co.com.alimentosybebidas.restaurante.cocina.Cocina;
import co.com.alimentosybebidas.restaurante.cocina.command.AgregarChef;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarChefUseCase extends UseCase<RequestCommand<AgregarChef>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarChef> agregarChefRequestCommand) {
        var command = agregarChefRequestCommand.getCommand();
        var cocina = Cocina.from(
                command.getCocinaId(), repository().getEventsBy(command.getCocinaId().value())
        );
        cocina.agregarChef(command.getNombre(), command.getTelefono());
        emit().onResponse(new ResponseEvents(cocina.getUncommittedChanges()));
    }
}
