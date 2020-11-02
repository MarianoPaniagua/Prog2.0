package juego;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> mazo;

    public Deck(){
        this.mazo = new ArrayList<>();
    }
    public Deck (ArrayList<Card> mazo){this.mazo = mazo;}

    public void addCard(Card card){
        this.mazo.add(card);
    }

    public ArrayList<Card> getMazo() {
        return mazo;
    }
    public int size() {
        return mazo.size();
    }

    public void setMazo(ArrayList<Card> mazo) {
        this.mazo = mazo;
    }

    public Card getARandomCard(){
        int randomIndex = new Random().nextInt(mazo.size());
        return mazo.get(randomIndex);
    }

    public Card getCard(int position){
        return mazo.get(position);
    }

    public void takeCardFromDeck(Card card) {
        this.mazo.remove(card);
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
