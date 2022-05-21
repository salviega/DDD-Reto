package co.com.alimentosybebidas.restaurante.cocina.command;

import co.com.alimentosybebidas.restaurante.cocina.values.CocinaId;
import co.com.alimentosybebidas.restaurante.cocina.values.DespensaId;
import co.com.alimentosybebidas.restaurante.cocina.values.Espacio;
import co.com.sofka.domain.generic.Command;

public class AgregarDespensa extends Command {
    private final CocinaId cocinaId;
    private final Espacio espacio;

    public AgregarDespensa(CocinaId cocinaId, Espacio espacio) {
        this.cocinaId = cocinaId;
        this.espacio = espacio;
    }

    public CocinaId getCocinaId() {
        return cocinaId;
    }

    public Espacio getEspacio() {
        return espacio;
    }
}
