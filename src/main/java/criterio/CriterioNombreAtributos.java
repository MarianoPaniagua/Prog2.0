package criterio;

import juego.Carta;

import java.util.ArrayList;

public class CriterioNombreAtributos extends Criterio {

    private ArrayList<String> atributosPosibles;

    public CriterioNombreAtributos(ArrayList<String> listaAtributos) {
        atributosPosibles = listaAtributos;
    }
    @Override
    public boolean cumpleCriterio(Carta carta) {
        ArrayList<String> atributos =new ArrayList<>();
        atributos = carta.getAtributosNames(carta.getAtributos());
        return atributos.containsAll(atributosPosibles);
    }
}
