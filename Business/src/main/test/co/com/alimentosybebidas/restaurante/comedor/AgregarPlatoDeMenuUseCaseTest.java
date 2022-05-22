package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.command.AgregarLicorDeMenu;
import co.com.alimentosybebidas.restaurante.comedor.command.AgregarPlatoDeMenu;
import co.com.alimentosybebidas.restaurante.comedor.events.ComedorCreado;
import co.com.alimentosybebidas.restaurante.comedor.events.LicorAgregadoDeMenu;
import co.com.alimentosybebidas.restaurante.comedor.events.MenuCreado;
import co.com.alimentosybebidas.restaurante.comedor.events.PlatoAgregadoDeMenu;
import co.com.alimentosybebidas.restaurante.comedor.values.ComedorId;
import co.com.alimentosybebidas.restaurante.comedor.values.Licor;
import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.alimentosybebidas.restaurante.comedor.values.Plato;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarPlatoDeMenuUseCaseTest {
    @InjectMocks
    private AgregarPlatoDeMenuUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void agregarPlatoAMenu() {
        //Arrange
        ComedorId comedorId = ComedorId.of("1");
        MenuId menuId = MenuId.of("1");
        Plato plato = new Plato("Sancocho", 50);
        var command = new AgregarPlatoDeMenu(comedorId, menuId, plato);
        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);
        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getComedorId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (PlatoAgregadoDeMenu) events.get(0);
        Assertions.assertEquals("Sancocho", event.getPlato().value().descripcion());
    }

    private List<DomainEvent> history() {
        Nombre nombre = new Nombre("Sala Dub");
        var event = new ComedorCreado(
                nombre

        );
        MenuId menuId1 = new MenuId("1");
        Nombre nombreMentoria = new Nombre("Raúl");
        var evento = new MenuCreado(
                menuId1,
                nombreMentoria

        );
        event.setAggregateRootId("1");
        return List.of(event,evento);
    }
}