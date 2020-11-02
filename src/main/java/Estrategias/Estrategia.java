package Estrategias;

import juego.Atributo;
import juego.Card;

public  abstract class Estrategia {

    private String nombre;

    public Estrategia(String nombre) {
        this.nombre = nombre;
    }

    public abstract Atributo playUsingStrategy(Card card);
}
