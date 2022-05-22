package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.command.AgregarMesero;
import co.com.alimentosybebidas.restaurante.comedor.events.ComedorCreado;
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
class AgregarMeseroUseCaseTest {

    @InjectMocks
    private AgregarMeseroUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUnMesero(){
        //arrange
        ComedorId comedorId = ComedorId.of("1");
        Nombre nombre = new Nombre("Santiago");
        Mesa mesa = new Mesa(true);
        Cuenta cuenta = new Cuenta(500);
        Turno turno = new Turno(false);
        var command = new AgregarMesero( comedorId,  nombre, turno, mesa, cuenta);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getComedorId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (MeseroCreado) events.get(0);
        Assertions.assertEquals(true, event.getTurno().value());

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