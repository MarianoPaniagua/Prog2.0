package Estrategias;

import juego.Atributo;
import juego.Card;

public class Timbero  extends Estrategia{

    public Timbero(String nombre) {
        super(nombre);
    }

    @Override
    public Atributo playUsingStrategy(Card card) {//Juega con un atributo random siempre.
        Atributo atributoQueDevuelvo= new Atributo();
        atributoQueDevuelvo.setNombreAtributo(card.getARandomAtributeName());//Tomo un (nombre) atributo random de la lista de atributos de la carta
        atributoQueDevuelvo.setValor(card.getAtributo(atributoQueDevuelvo.getNombreAtributo()).getValor());//Seteo el valor de ese atributo extrayendolo de la carta.
        return atributoQueDevuelvo;
    }
}
