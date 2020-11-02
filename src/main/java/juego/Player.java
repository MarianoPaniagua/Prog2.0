package juego;

import Estrategias.Estrategia;

public class Player {

    private String name;
    private Deck myDeck;
    private Estrategia estrategia;

    public Player(){}

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deck getMyDeck() {
        return myDeck;
    }

    public void setMyDeck(Deck myDeck) {
        this.myDeck = myDeck;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }
    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }
}
