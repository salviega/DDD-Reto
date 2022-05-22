package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.command.AgregarLicorDeMenu;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarLicorDeMenuUseCase extends UseCase<RequestCommand<AgregarLicorDeMenu>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarLicorDeMenu> agregarLicorDeMenuRequestCommand) {
        var command = agregarLicorDeMenuRequestCommand.getCommand();
        var comedor = Comedor.from(
                command.getComedorId(), repository().getEventsBy(command.getComedorId().value())
        );
        comedor.licorAgregadoDeMenu(command.getMenuId(), command.getLicor());
        emit().onResponse((new ResponseEvents(comedor.getUncommittedChanges())));


    }
}
