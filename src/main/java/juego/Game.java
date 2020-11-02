package juego;

public class Game {

    public final int MAX_ROUNDS = 1000;

    private int counter = 1;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void oneTurnpassed() {
        counter++;
    }

    public void play(Player playerOne, Player playerTwo) {
        Player auxiliar = new Player("Carlos");

        while ((counter < MAX_ROUNDS) && (!playerOne.getMyDeck().isEmtpy()) &&
                (!playerTwo.getMyDeck().isEmtpy())) {

            //Empieza el juego
            System.out.println("-------" + counter + "-------");
            //Cada jugador toma la primer carta de su mazo
            Card cardOne = playerOne.getMyDeck().getCard(0);
            Card cardTwo = playerTwo.getMyDeck().getCard(0);
            //El jugador uno elije un atributo
            String atributoRandom = cardOne.getARandomAtributeName(cardOne);
            System.out.println("El jugador " + playerOne.getName() + " selecciona competir con el atributo "
                    + atributoRandom);
            System.out.println("La carta de " + playerOne.getName() + " es " +
                    cardOne.getNombre() + " con " + atributoRandom + " " +
                    cardOne.getAtributo(atributoRandom).getValor());
            System.out.println("La carta de " + playerTwo.getName() + " es " +
                    cardTwo.getNombre() + " con " + atributoRandom + " " +
                    cardTwo.getAtributo(atributoRandom).getValor());
            aplicarPociones(cardOne, cardTwo, atributoRandom);
            if (cardOne.compareCards(cardTwo, atributoRandom) == 1) {
                System.out.println("El jugador " + playerOne.getName() +
                        " Gano la ronda");
                //Tomar las dos cartas y ponerlas al final del arr
                playerOne.getMyDeck().addCard(cardTwo);
                playerTwo.getMyDeck().takeCardFromDeck(cardTwo);
                playerOne.getMyDeck().putMyCardAtTheBottomOfDeck();
                oneTurnpassed();
                System.out.println(playerOne.getName() + " Ahora tiene " +
                        playerOne.getMyDeck().size() + " y " +
                        playerTwo.getName() + " tiene " +
                        playerTwo.getMyDeck().size() + " cartas.");
            } else if (cardOne.compareCards(cardTwo, atributoRandom) == -1) {
                System.out.println("El jugador " + playerTwo.getName() +
                        " Gano la ronda");
                //Tomar las dos cartas y ponerlas al final del array
                playerOne.getMyDeck().takeCardFromDeck(cardOne);
                playerTwo.getMyDeck().addCard(cardOne);
                playerTwo.getMyDeck().putMyCardAtTheBottomOfDeck();
                //Imprimo como quedaron los mazos de cada jugador
                System.out.println(playerOne.getName() + " Ahora tiene " +
                        playerOne.getMyDeck().size() + " y " +
                        playerTwo.getName() + " tiene " +
                        playerTwo.getMyDeck().size() + " cartas.");
                //Intercambia jugadores para seguir jugando
                auxiliar = playerOne;
                playerOne = playerTwo;
                playerTwo = auxiliar;
                oneTurnpassed();
            } else {
                System.out.println("nadie gano");
                playerOne.getMyDeck().putMyCardAtTheBottomOfDeck();
                playerTwo.getMyDeck().putMyCardAtTheBottomOfDeck();
                oneTurnpassed();
            }
        }
        if (counter == MAX_ROUNDS) {
            System.out.println("The game finished because we reached maximum rounds");
        } else if (playerOne.getMyDeck().isEmtpy()) {
            System.out.println("Gano " + playerTwo.getName());
        } else {
            System.out.println("Gano " + playerOne.getName());
        }
    }

    private void aplicarPociones(Card carta1, Card carta2, String atributo) {
        if (carta1.getPocion() != null) {
            carta1.getPocion().aplicarPocion(carta1, atributo);
        }
        if (carta2.getPocion() != null) {
            carta2.getPocion().aplicarPocion(carta2, atributo);
        }
    }
}
