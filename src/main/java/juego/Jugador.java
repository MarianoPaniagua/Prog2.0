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

    public Mazo getMyDeck() {
        return myMazo;
    }

    public void agregarCartaAlMazo(Carta carta) {
        this.myMazo.addCard(carta);
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public String getAtributoParaJugar(Carta carta) {
        return this.estrategia.jugarEstrategia(carta);
    }

    public Carta getPrimeraCarta(){
      if(this.myMazo.size() > 0){
          return this.myMazo.getCard(0);
      }
      return null;
    }

    public boolean tieneMazoVacio(){
        return this.myMazo.isEmtpy();
    }
}
