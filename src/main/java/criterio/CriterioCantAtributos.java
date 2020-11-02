package criterio;

import juego.Card;

public class CriterioCantAtributos extends Criterio {
    private int cantidadAtributos;

    public CriterioCantAtributos(int cantidad){
        cantidadAtributos = cantidad;
    }

    @Override
    public boolean cumpleCriterio(Card carta) {
        return carta.getAtributos().size() == cantidadAtributos;
    }
}
