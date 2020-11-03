package criterio;

import juego.Atributo;
import juego.Carta;

public class CriterioMaxValorAtributo extends Criterio {
    private int maximo;

    public CriterioMaxValorAtributo(int maximo) {
        this.maximo = maximo;
    }

    @Override
    public boolean cumpleCriterio(Carta carta) {
        for (Atributo atributo : carta.getAtributos()) {
            if (atributo.getValor() > maximo) {
                return false;
            }
        }
        return true;
    }
}
