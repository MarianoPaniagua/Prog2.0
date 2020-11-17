package juego;

public class Game {

    public final int MAX_ROUNDS = 1000;

    public void play(Jugador jugadorOne, Jugador jugadorTwo) {
        int counter = 1;
        Jugador auxiliar;
        while ((counter < MAX_ROUNDS) && (!jugadorOne.tieneMazoVacio()) &&
                (!jugadorTwo.tieneMazoVacio())) {
            //Empieza el juego
            System.out.println("-------Turno " + counter + "-------");
            //Cada jugador toma la primer carta de su mazo

            Carta cartaOne = jugadorOne.getPrimeraCarta();
            Carta cartaTwo = jugadorTwo.getPrimeraCarta();

            //El jugador uno elije un atributo
            String atributoElegido = jugadorOne.getAtributoParaJugar(cartaOne);
            System.out.println("El jugador " + jugadorOne.getName() + " selecciona competir con el atributo "
                    + atributoElegido);

            //Aplicamos las pociones y guardamos el resultado
            int valorDelJugador1 = aplicarPociones(jugadorOne, cartaOne, atributoElegido);
            int valorDelJugador2 = aplicarPociones(jugadorTwo, cartaTwo, atributoElegido);

            //Comparamos los atributos
            if (valorDelJugador1 > valorDelJugador2) {
                moverCartasEImprimirEstadoDelDeck(jugadorOne, jugadorTwo, cartaTwo);
                counter++;
            } else if (valorDelJugador2 > valorDelJugador1) {
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

    private int aplicarPociones(Jugador jugadorOne, Carta cartaOne, String atributoElegido) {
        System.out.println("La carta de " + jugadorOne.getName() + " es " +
                cartaOne.getNombre() + " con " + atributoElegido + " " +
                cartaOne.getAtributo(atributoElegido).getValor());
        return aplicarPocion(cartaOne, atributoElegido);
    }

    private int aplicarPocion(Carta carta, String atributo) {
        int atributoOriginal = carta.getAtributo(atributo).getValor();
        int atributoModificado = atributoOriginal;
        if (carta.getPocion() != null) {
            atributoModificado = carta.getPocion().aplicarPocion(carta, atributo);
        }
        if (atributoOriginal != atributoModificado) {
            imprimirValorModificado(atributoModificado, carta.getPocion().getNombre());
        }
        return atributoModificado;
    }

    private void imprimirValorModificado(int atributoModificado, String nombrePocion) {
        System.out.println("Se aplicó la pocima " + nombrePocion +
                " , el valor resultante es " + atributoModificado);
    }
}
