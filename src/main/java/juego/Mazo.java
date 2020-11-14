package juego;

import java.util.ArrayList;
import java.util.Random;

public class Mazo {
    private ArrayList<Carta> mazo;

    public Mazo(){
        this.mazo = new ArrayList<>();
    }

    public Mazo(ArrayList<Carta> mazo){this.mazo = mazo;}

    public void addCard(Carta carta){
        this.mazo.add(carta);
    }

    public ArrayList<Carta> getMazo() {
        return mazo;
    }
    public int size() {
        return mazo.size();
    }

    public void setMazo(ArrayList<Carta> mazo) {
        this.mazo = mazo;
    }

    public Carta getARandomCard(){
        int randomIndex = new Random().nextInt(mazo.size());
        return mazo.get(randomIndex);
    }

    public Carta getCard(int position){
        return mazo.get(position);
    }

    public void takeCardFromDeck(Carta carta) {
        this.mazo.remove(carta);
    }

    public void takeCard(int index) {
        this.mazo.remove(index);
    }

    public boolean isEmtpy(){
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
