package co.com.alimentosybebidas.restaurante.comedor.cocina;

import co.com.alimentosybebidas.restaurante.cocina.command.AgregarDespensa;
import co.com.alimentosybebidas.restaurante.cocina.events.CocinaCreado;
import co.com.alimentosybebidas.restaurante.cocina.events.DespensaCreada;
import co.com.alimentosybebidas.restaurante.cocina.values.CocinaId;
import co.com.alimentosybebidas.restaurante.cocina.values.Espacio;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarDespensaUseCaseTest {

    @InjectMocks
    private AgregarDespensaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUnaDespensa(){
        //arrange
        CocinaId cocinaId = CocinaId.of("1");
        Espacio espacio = new Espacio(100);
        var command = new AgregarDespensa( cocinaId, espacio);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCocinaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DespensaCreada) events.get(0);
        Assertions.assertEquals(100, event.getEspacio().value());

    }

    private List<DomainEvent> history() {
        Espacio espacio = new Espacio(100);
        var event = new CocinaCreado(
                espacio
        );
        event.setAggregateRootId("1");
        return List.of(event);
    }
}