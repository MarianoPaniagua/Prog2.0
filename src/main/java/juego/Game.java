package juego;

public class Game {

    public final int MAX_ROUNDS = 1000;

    public void play(Jugador jugadorOne, Jugador jugadorTwo) {
        int counter = 1;

        Jugador auxiliar = new Jugador("Carlos");

        while ((counter < MAX_ROUNDS) && (!jugadorOne.getMyDeck().isEmtpy()) &&
                (!jugadorTwo.getMyDeck().isEmtpy())) {
            //Empieza el juego
            System.out.println("-------Turno " + counter + "-------");
            //Cada jugador toma la primer carta de su mazo
            Carta cartaOne = jugadorOne.getMyDeck().getCard(0);
            Carta cartaTwo = jugadorTwo.getMyDeck().getCard(0);
            //El jugador uno elije un atributo
            String atributoElegido = jugadorOne.getAtributoParaJugar(cartaOne);
            imprimirDatos(jugadorOne, cartaOne, cartaTwo, jugadorTwo, atributoElegido);
            if (cartaOne.compareCards(cartaTwo, atributoElegido) == 1) {
                moverCartasEImprimirEstadoDelDeck(jugadorOne, jugadorTwo, cartaTwo);
                counter++;
            } else if (cartaOne.compareCards(cartaTwo, atributoElegido) == -1) {
                moverCartasEImprimirEstadoDelDeck(jugadorTwo, jugadorOne, cartaOne);
                counter++;
                //Intercambia jugadores para seguir jugando
                auxiliar = jugadorOne;
                jugadorOne = jugadorTwo;
                jugadorTwo = auxiliar;
            } else {
                System.out.println("nadie gano");
                jugadorOne.getMyDeck().putMyCardAtTheBottomOfDeck();
                jugadorTwo.getMyDeck().putMyCardAtTheBottomOfDeck();
                counter++;
            }
        }
        if (counter == MAX_ROUNDS) {
            System.out.println("El juego termino porque alcanzo el maximo de rondas.");
        } else if (jugadorOne.getMyDeck().isEmtpy()) {
            System.out.println("Gano " + jugadorTwo.getName());
        } else {
            System.out.println("Gano " + jugadorOne.getName());
        }
    }

    private void moverCartasEImprimirEstadoDelDeck(Jugador jugador, Jugador rival, Carta carta) {
        moverCartas(jugador, rival, carta);
        imprimirComoQuedanLosMazos(jugador, rival);
    }

    private void imprimirComoQuedanLosMazos(Jugador jugadorOne, Jugador jugadorTwo) {
        System.out.println(jugadorOne.getName() + " Ahora tiene " +
                jugadorOne.getMyDeck().size() + " y " +
                jugadorTwo.getName() + " tiene " +
                jugadorTwo.getMyDeck().size() + " cartas.");
    }

    private void moverCartas(Jugador jugadorOne, Jugador jugadorTwo, Carta cartaTwo) {
        System.out.println("El jugador " + jugadorOne.getName() +
                " Gano la ronda");
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
