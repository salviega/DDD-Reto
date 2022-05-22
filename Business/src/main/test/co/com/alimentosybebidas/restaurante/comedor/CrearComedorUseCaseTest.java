package co.com.alimentosybebidas.restaurante.comedor;

import co.com.alimentosybebidas.restaurante.comedor.command.CrearComedor;
import co.com.alimentosybebidas.restaurante.comedor.events.ComedorCreado;
import co.com.alimentosybebidas.restaurante.comedor.values.ComedorId;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearComedorUseCaseTest {

    private CrearComedorUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearComedorUseCase();
    }

    @Test
    public void crearComedor(){
        //arrange
        ComedorId comedorId = ComedorId.of("1");
        Nombre nombre = new Nombre("Sala Dub");
        var command = new CrearComedor( comedorId,  nombre);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var cursoCreado = (ComedorCreado)events.get(0);
        Assertions.assertEquals("Sala Dub", cursoCreado.getNombre().value());

    }

}