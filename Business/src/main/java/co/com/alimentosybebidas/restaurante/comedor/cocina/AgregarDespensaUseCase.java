package co.com.alimentosybebidas.restaurante.comedor.cocina;

import co.com.alimentosybebidas.restaurante.cocina.Cocina;
import co.com.alimentosybebidas.restaurante.cocina.command.AgregarDespensa;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarDespensaUseCase extends UseCase<RequestCommand<AgregarDespensa>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarDespensa> agregarDespensaRequestCommand) {
        var command = agregarDespensaRequestCommand.getCommand();
        var cocina = Cocina.from(
                command.getCocinaId(), repository().getEventsBy(command.getCocinaId().value())
        );
        cocina.agregarDespensa(command.getEspacio());
        emit().onResponse(new ResponseEvents((cocina.getUncommittedChanges())));
    }
}
