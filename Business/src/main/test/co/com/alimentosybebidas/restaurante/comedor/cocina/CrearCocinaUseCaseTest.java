package co.com.alimentosybebidas.restaurante.comedor.cocina;

import co.com.alimentosybebidas.restaurante.cocina.command.CrearCocina;
import co.com.alimentosybebidas.restaurante.cocina.events.CocinaCreado;
import co.com.alimentosybebidas.restaurante.cocina.values.CocinaId;
import co.com.alimentosybebidas.restaurante.cocina.values.Espacio;
import co.com.alimentosybebidas.restaurante.generic.values.Nombre;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearCocinaUseCaseTest {

    private CrearCocinaUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearCocinaUseCase();
    }

    @Test
    public void crearCursoHappyPass(){
        //arrange
        CocinaId coursoId = CocinaId.of("xxxxx");
        Espacio espacio = new Espacio(10);
        var command = new CrearCocina( coursoId,  espacio);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var cocinaCreada = (CocinaCreado)events.get(0);
        Assertions.assertEquals(10, cocinaCreada.getEspacio().value());

    }
}