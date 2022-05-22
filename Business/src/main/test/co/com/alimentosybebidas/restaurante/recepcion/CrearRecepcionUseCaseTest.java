package co.com.alimentosybebidas.restaurante.recepcion;

import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.alimentosybebidas.restaurante.recepcion.command.CrearRecepcion;
import co.com.alimentosybebidas.restaurante.recepcion.events.RecepcionCreado;
import co.com.alimentosybebidas.restaurante.recepcion.values.RecepcionId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearRecepcionUseCaseTest {

    private CrearRecepcionUseCase useCase;

    @BeforeEach
    public void setup() { useCase = new CrearRecepcionUseCase();}
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
        assertEquals("x", rececpcionCreado.getNombre().value());
    }

}