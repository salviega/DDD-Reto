package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.command.AgregarMenu;
import co.com.alimentosybebidas.restaurante.comedor.command.AgregarMesero;
import co.com.alimentosybebidas.restaurante.comedor.events.ComedorCreado;
import co.com.alimentosybebidas.restaurante.comedor.events.MenuCreado;
import co.com.alimentosybebidas.restaurante.comedor.events.MeseroCreado;
import co.com.alimentosybebidas.restaurante.comedor.values.ComedorId;
import co.com.alimentosybebidas.restaurante.comedor.values.Cuenta;
import co.com.alimentosybebidas.restaurante.comedor.values.Mesa;
import co.com.alimentosybebidas.restaurante.comedor.values.Turno;
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
class AgregarMenuUseCaseTest {

    @InjectMocks
    private AgregarMenuUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUnMenu(){
        //arrange
        ComedorId comedorId = ComedorId.of("1");
        Nombre nombre = new Nombre("Carta1");
        var command = new AgregarMenu( comedorId,  nombre);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getComedorId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (MenuCreado) events.get(0);
        Assertions.assertEquals("Carta1", event.getNombre().value());

    }

    private List<DomainEvent> history() {
        Nombre nombre = new Nombre("Sala Dub");
        var event = new ComedorCreado(
                nombre
        );
        event.setAggregateRootId("1");
        return List.of(event);
    }

}