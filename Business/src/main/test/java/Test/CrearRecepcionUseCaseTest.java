package Test;

import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.recepcion.CrearRecepcionUseCase;
import co.com.alimentosybebidas.restaurante.recepcion.Recepcion;
import co.com.alimentosybebidas.restaurante.recepcion.command.AgregarCaja;
import co.com.alimentosybebidas.restaurante.recepcion.command.CrearRecepcion;
import co.com.alimentosybebidas.restaurante.recepcion.events.RecepcionCreado;
import co.com.alimentosybebidas.restaurante.recepcion.values.Base;
import co.com.alimentosybebidas.restaurante.recepcion.values.RecepcionId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static co.com.alimentosybebidas.restaurante.recepcion.values.RecepcionId.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CrearRecepcionUseCaseTest {

    private CrearRecepcionUseCase useCase;

    @BeforeEach
    public void setuo() { useCase = new CrearRecepcionUseCase();}
    @Test
    public  void crearRecepcion() {
        //Arrange
        var recepcionId = RecepcionId.of("1");
        var nombre = new Nombre("x");
        var command = new CrearRecepcion(recepcionId, nombre);
        //Act
        var events = UseCaseHandler.getInstance()

                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //Assert
        var rececpcionCreado= (RecepcionCreado) events.get(0);
        assertEquals("1", rececpcionCreado.aggregateParentId());
    }

}