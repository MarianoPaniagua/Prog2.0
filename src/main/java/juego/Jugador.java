package juego;

import estrategia.Estrategia;

public class Jugador {

    private String name;
    private Mazo myMazo;
    private Estrategia estrategia;


    public Jugador(String name) {
        this.name = name;
        this.myMazo = new Mazo();
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

    public void agregarCartaAlMazo(Carta carta) {
        this.myMazo.addCard(carta);
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public String getAtributoParaJugar(Carta carta) {
        return this.estrategia.jugarEstrategia(carta);
    }
}
