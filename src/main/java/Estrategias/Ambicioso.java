package Estrategias;

import juego.Atributo;
import juego.Card;

public class Ambicioso extends Estrategia {

    public Ambicioso(String nombre) {
        super(nombre);
    }

    @Override
    public Atributo playUsingStrategy(Card card) {
        Atributo maxValor = new Atributo();
        maxValor.setValor(0);
        for (Atributo atributo: card.getAtributos()) {
            if(maxValor.getValor() < atributo.getValor()){
                maxValor.setNombreAtributo(atributo.getNombreAtributo());
                maxValor.setValor(atributo.getValor());
            }
        }
        return maxValor;
    }
}
