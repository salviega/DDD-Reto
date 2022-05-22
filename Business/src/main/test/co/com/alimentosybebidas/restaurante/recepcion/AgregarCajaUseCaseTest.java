package co.com.alimentosybebidas.restaurante.recepcion;

import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.recepcion.command.AgregarCaja;
import co.com.alimentosybebidas.restaurante.recepcion.events.CajaCreada;
import co.com.alimentosybebidas.restaurante.recepcion.events.ManagerCreado;
import co.com.alimentosybebidas.restaurante.recepcion.events.RecepcionCreado;
import co.com.alimentosybebidas.restaurante.recepcion.values.Base;
import co.com.alimentosybebidas.restaurante.recepcion.values.RecepcionId;
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
class AgregarCajaUseCaseTest {
    @InjectMocks
    private AgregarCajaUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void agregarUnCaja() {
        //Arrange
        var recepcionId = RecepcionId.of("1");
        var base = new Base("1000");
        var command = new AgregarCaja(recepcionId, base);
        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);
        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRecepcionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //Assert
        var event = (CajaCreada) events.get(0);
        Assertions.assertEquals("1000", event.getBase().value());

    }
    private List<DomainEvent> history() {
        var nombre = new Nombre("x");
        var event = new RecepcionCreado(nombre);
        event.setAggregateRootId("1");
        return List.of(event);
    }
}