package co.com.alimentosybebidas.restaurante.recepcion;

import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.generic.values.Telefono;
import co.com.alimentosybebidas.restaurante.recepcion.command.AgregarManager;
import co.com.alimentosybebidas.restaurante.recepcion.events.ManagerCreado;
import co.com.alimentosybebidas.restaurante.recepcion.events.RecepcionCreado;
import co.com.alimentosybebidas.restaurante.recepcion.values.ManagerId;
import co.com.alimentosybebidas.restaurante.recepcion.values.RecepcionId;
import co.com.alimentosybebidas.restaurante.recepcion.values.Reservacion;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarManagerUseCaseTest {

    @InjectMocks
    private AgregarManagerUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void agregarUnManager() {
        //Arrange
        var recepcionId = RecepcionId.of("1");
        var nombre = new Nombre("Santiago");
        var telefono = new Telefono("1234567890");
        var reservacion = new Reservacion(true);
        var command = new AgregarManager(recepcionId, nombre, telefono, reservacion);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);
        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRecepcionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //Assert
        var event = (ManagerCreado) events.get(0);
        Assertions.assertEquals("Santiago", event.getNombre().value());
    }
    private List<DomainEvent> history() {
        var nombre = new Nombre("x");
        var event = new RecepcionCreado(nombre);
        event.setAggregateRootId("1");
        return List.of(event);
    }


}