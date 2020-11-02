package juego;

public class Player {

    private String name;
    private Deck myDeck;

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
}
