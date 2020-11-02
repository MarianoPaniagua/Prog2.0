package juego;

import criterio.CriterioCantAtributos;
import criterio.Criterio;
import criterio.CriterioNombreAtributos;
import pocion.Pocion;
import pocion.PocionIncrementa;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        String path = "C:\\Users\\mariano.paniagua\\IdeaProjects\\prog2\\src\\main\\java\\juego\\superheroes.json";

        //Creamos pociones
        Pocion pocionIncrementaFuerza = new PocionIncrementa("PocionIncrementadoraDeFuerza", new Atributo("fuerza", 20));
        Pocion pocionIncrementaVelocidad = new PocionIncrementa("PocionIncrementadoraDeVelocidad", new Atributo("velocidad", 10));

        ArrayList<Pocion> listaDePociones = new ArrayList<>();
        listaDePociones.add(pocionIncrementaFuerza);
        listaDePociones.add(pocionIncrementaVelocidad);

        //Se crea el juego y el criterio (tipo de cartas del que se tratará el juego)
        Game game = new Game();
        ArrayList<String> atributosPosibles = new ArrayList<String>() {
            {
                add("altura");
                add("peso");
                add("fuerza");
                add("peleas ganadas");
                add("velocidad");
            }
        };
        Criterio cantidadAtributos = new CriterioCantAtributos(5);
        Criterio nombreAtributos = new CriterioNombreAtributos(atributosPosibles);
        ArrayList<Criterio> criterios = new ArrayList<Criterio>();
        criterios.add(cantidadAtributos);
        criterios.add(nombreAtributos);
        System.out.println("Juego creado");

        //Se crean 2 jugadores
        Player playerOne = new Player("Mariano");
        Player playerTwo = new Player("Fran");
        System.out.println("Jugadores creados");

        //Se crea el mazo general
        DeckHelper deckHelper = new DeckHelper();
        Deck allCards = deckHelper.generateDeckAllCards(path);
        System.out.println("Mazo con todas las cartas creado");

        //Se incorporan pociones al mazo general para posterior repartida
        allCards = deckHelper.intercalarPociones(allCards, listaDePociones);

        //Se asigna un mazo (filtrado según criterio) a cada jugador
        playerOne.setMyDeck(deckHelper.generateDeck(allCards, true, criterios));
        System.out.println(playerOne.getName() + "--->" + playerOne.getMyDeck().size() + " cartas");
        playerTwo.setMyDeck(deckHelper.generateDeck(allCards, false, criterios));
        System.out.println(playerTwo.getName() + "--->" + playerTwo.getMyDeck().size() + " cartas");
        System.out.println("Mazos seteados a cada jugador");

        //Inicio de rondas
        System.out.println("------------Empieza el juego--------------");
        game.play(playerOne, playerTwo);
    }
}

