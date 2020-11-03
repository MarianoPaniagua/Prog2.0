package juego;

public class Game {

    public final int MAX_ROUNDS = 1000;

    private int counter = 1;

    public void oneTurnpassed() {
        counter++;
    }

    public void play(Jugador jugadorOne, Jugador jugadorTwo) {
        Jugador auxiliar = new Jugador("Carlos");

        while ((counter < MAX_ROUNDS) && (!jugadorOne.getMyDeck().isEmtpy()) &&
                (!jugadorTwo.getMyDeck().isEmtpy())) {
            //Empieza el juego
            System.out.println("-------Turno " + counter + "-------");
            //Cada jugador toma la primer carta de su mazo
            Carta cartaOne = jugadorOne.getMyDeck().getCard(0);
            Carta cartaTwo = jugadorTwo.getMyDeck().getCard(0);
            //El jugador uno elije un atributo
            String atributoElegido = jugadorOne.getEstrategia().jugarEstrategia(cartaOne).getNombreAtributo();
            imprimirDatos(jugadorOne, cartaOne, cartaTwo, jugadorTwo, atributoElegido);
            if (cartaOne.compareCards(cartaTwo, atributoElegido) == 1) {
                System.out.println("El jugador " + jugadorOne.getName() +
                        " Gano la ronda");
                moverCartas(jugadorOne, jugadorTwo, cartaTwo);
                oneTurnpassed();
                imprimirComoQuedanLosMazos(jugadorOne, jugadorTwo);
            } else if (cartaOne.compareCards(cartaTwo, atributoElegido) == -1) {
                System.out.println("El jugador " + jugadorTwo.getName() +
                        " Gano la ronda");
                moverCartas(jugadorTwo, jugadorOne, cartaOne);
                imprimirComoQuedanLosMazos(jugadorOne, jugadorTwo);
                //Intercambia jugadores para seguir jugando
                auxiliar = jugadorOne;
                jugadorOne = jugadorTwo;
                jugadorTwo = auxiliar;
                oneTurnpassed();
            } else {
                System.out.println("nadie gano");
                jugadorOne.getMyDeck().putMyCardAtTheBottomOfDeck();
                jugadorTwo.getMyDeck().putMyCardAtTheBottomOfDeck();
                oneTurnpassed();
            }
        }
        if (counter == MAX_ROUNDS) {
            System.out.println("The game finished because we reached maximum rounds");
        } else if (jugadorOne.getMyDeck().isEmtpy()) {
            System.out.println("Gano " + jugadorTwo.getName());
        } else {
            System.out.println("Gano " + jugadorOne.getName());
        }
    }

    private void imprimirComoQuedanLosMazos(Jugador jugadorOne, Jugador jugadorTwo) {
        System.out.println(jugadorOne.getName() + " Ahora tiene " +
                jugadorOne.getMyDeck().size() + " y " +
                jugadorTwo.getName() + " tiene " +
                jugadorTwo.getMyDeck().size() + " cartas.");
    }

    private void moverCartas(Jugador jugadorOne, Jugador jugadorTwo, Carta cartaTwo) {
        jugadorOne.getMyDeck().addCard(cartaTwo);
        jugadorTwo.getMyDeck().takeCardFromDeck(cartaTwo);
        jugadorOne.getMyDeck().putMyCardAtTheBottomOfDeck();
    }

    private void imprimirDatos(Jugador jugadorOne, Carta cartaOne, Carta cartaTwo, Jugador jugadorTwo, String atributoElegido) {
        System.out.println("El jugador " + jugadorOne.getName() + " selecciona competir con el atributo "
                + atributoElegido);
        System.out.println("La carta de " + jugadorOne.getName() + " es " +
                cartaOne.getNombre() + " con " + atributoElegido + " " +
                cartaOne.getAtributo(atributoElegido).getValor());
        aplicarPocion(cartaOne, atributoElegido, jugadorOne);
        System.out.println("La carta de " + jugadorTwo.getName() + " es " +
                cartaTwo.getNombre() + " con " + atributoElegido + " " +
                cartaTwo.getAtributo(atributoElegido).getValor());
        aplicarPocion(cartaTwo, atributoElegido, jugadorTwo);
    }

    private void aplicarPocion(Carta carta, String atributo, Jugador jugador){
        if (carta.getPocion() != null) {
            carta.getPocion().aplicarPocion(carta, atributo);
        }
    }
}
