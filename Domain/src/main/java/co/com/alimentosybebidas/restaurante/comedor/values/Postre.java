package co.com.alimentosybebidas.restaurante.comedor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Postre implements ValueObject<Postre.Pros> {

    private final String descripcion;
    private final Integer precio;

    public Postre(String descripcion, Integer precio) {
        this.descripcion = Objects.requireNonNull(descripcion);
        this.precio = Objects.requireNonNull(precio);
    }

    @Override
    public Postre.Pros value() {
        return new Postre.Pros() {
            @Override
            public String descripcion() {
                return descripcion;
            }

            @Override
            public Integer precio() {
                return precio;
            }
        };
    };

    public interface Pros {
        String descripcion();
        Integer precio();
    }
}