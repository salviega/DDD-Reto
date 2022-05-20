package co.com.alimentosybebidas.restaurante.comedor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Licor implements ValueObject<Licor.Pros> {

    private final String descripcion;
    private final Integer precio;

    public Licor(String descripcion, Integer precio) {
        this.descripcion = Objects.requireNonNull(descripcion);
        this.precio = Objects.requireNonNull(precio);
    }

    @Override
    public Licor.Pros value() {
        return new Licor.Pros() {
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
