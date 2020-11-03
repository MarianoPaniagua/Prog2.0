package criterio;

import juego.Carta;

public class CriterioAND implements Criterio{

    private Criterio c1;
    private Criterio c2;

    public CriterioAND(Criterio c1, Criterio c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public boolean cumpleCriterio(Carta carta) {
        return c1.cumpleCriterio(carta) && c2.cumpleCriterio(carta);
    }
}
