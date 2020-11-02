package criterio;

import juego.Carta;

public class CriterioCantAtributos extends Criterio {
    private int cantidadAtributos;

    public CriterioCantAtributos(int cantidad){
        cantidadAtributos = cantidad;
    }

    @Override
    public boolean cumpleCriterio(Carta carta) {
        return carta.getAtributos().size() == cantidadAtributos;
    }
}
