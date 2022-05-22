package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.command.AgregarPlatoDeMenu;
import co.com.alimentosybebidas.restaurante.comedor.command.AgregarPostreDeMenu;
import co.com.alimentosybebidas.restaurante.comedor.events.ComedorCreado;
import co.com.alimentosybebidas.restaurante.comedor.events.MenuCreado;
import co.com.alimentosybebidas.restaurante.comedor.events.PlatoAgregadoDeMenu;
import co.com.alimentosybebidas.restaurante.comedor.events.PostreAgregadoDeMenu;
import co.com.alimentosybebidas.restaurante.comedor.values.ComedorId;
import co.com.alimentosybebidas.restaurante.comedor.values.MenuId;
import co.com.alimentosybebidas.restaurante.comedor.values.Plato;
import co.com.alimentosybebidas.restaurante.comedor.values.Postre;
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
class AgregarPostreDeMenuUseCaseTest {
    @InjectMocks
    private AgregarPostreDeMenuUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void agregarPostreAMenu() {
        //Arrange
        ComedorId comedorId = ComedorId.of("1");
        MenuId menuId = MenuId.of("1");
        Postre postre = new Postre("Helado", 1);
        var command = new AgregarPostreDeMenu(comedorId, menuId, postre);
        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);
        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getComedorId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (PostreAgregadoDeMenu) events.get(0);
        Assertions.assertEquals("Helado", event.getPostre().value().descripcion());
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