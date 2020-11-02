package Estrategias;

import juego.Atributo;
import juego.Card;

public class Obstinado extends Estrategia {

    private String atributo;

    public Obstinado(String nombre, String atributo) {
        super(nombre);
        this.atributo = atributo;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    @Override
    public Atributo playUsingStrategy(Card card) {//Juega siempre con el atributo que setee o con el que construi la estrategia.
        return card.getAtributo(this.atributo);
    }
}
