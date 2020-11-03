package criterio;

import juego.Carta;

public class CriterioNOT implements Criterio{

    private Criterio c;

    public CriterioNOT(Criterio c) {
        this.c = c;
    }

    @Override
    public boolean cumpleCriterio(Carta carta) {
        return !c.cumpleCriterio(carta);
    }
}
