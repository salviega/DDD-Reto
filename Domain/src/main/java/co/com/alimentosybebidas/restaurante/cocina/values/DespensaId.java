package co.com.alimentosybebidas.restaurante.cocina.values;

import co.com.sofka.domain.generic.Identity;

public class DespensaId extends Identity {
    public DespensaId(String id) {
        super(id);
    }
    public DespensaId() {}

    public static DespensaId of(String id) {
        return new DespensaId(id);
    }
}