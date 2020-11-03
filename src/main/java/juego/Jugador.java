package juego;

import estrategia.Estrategia;

public class Jugador {

    private String name;
    private Mazo myMazo;
    private Estrategia estrategia;

    public Jugador(){}

    public Jugador(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mazo getMyDeck() {
        return myMazo;
    }

    public void setMyDeck(Mazo myMazo) {
        this.myMazo = myMazo;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }
    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }
}
