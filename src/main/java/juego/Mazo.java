package juego;

import java.util.ArrayList;

public class Mazo {
    private ArrayList<Carta> mazo;

    public Mazo() {
        this.mazo = new ArrayList<>();
    }

    public void addCard(Carta carta) {
        if (mazo.size() == 0) {
            this.mazo.add(carta);
        } else {
            if (carta.equals(getCard(0))) {
                this.mazo.add(carta);
            }
        }
    }

    public ArrayList<Carta> getMazo() {
        return mazo;
    }

    public int size() {
        return mazo.size();
    }

    public Carta getCard(int position) {
        return mazo.get(position);
    }

    public void takeCardFromDeck(Carta carta) {
        this.mazo.remove(carta);
    }

    public void takeCard(int index) {
        this.mazo.remove(index);
    }

    public boolean isEmtpy() {
        return this.mazo.size() == 0;
    }

    public void putMyCardAtTheBottomOfDeck() {
        mazo.add(mazo.remove(0));
    }

    @Override
    public String toString() {
        return "Deck{" +
                "mazo=" + mazo +
                '}';
    }
}
