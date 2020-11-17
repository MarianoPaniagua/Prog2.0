package juego;

import estrategia.Estrategia;
import estrategia.Obstinado;

import estrategia.Timbero;
import pocion.*;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        String path = "src/main/java/juego/superheroes.json";

        //Se crea lista de pociones
        ArrayList<Pocion> listaDePociones = crearPociones();

        //Se crea el juego
        Game game = new Game();
        System.out.println("Juego creado");

        //Se crean 2 jugadores
        Jugador jugadorOne = new Jugador("Mariano");
        Jugador jugadorTwo = new Jugador("Fran");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorOne);
        jugadores.add(jugadorTwo);
        System.out.println("Jugadores creados");

        //Se setean estrategias para cada jugador.
        Estrategia elegirMayor = new Obstinado("obstinado", "peso");
        Estrategia elegirRandom = new Timbero("timbero");
        jugadorOne.setEstrategia(elegirMayor);
        jugadorTwo.setEstrategia(elegirRandom);

        //Se crea el mazo general
        DeckHelper deckHelper = new DeckHelper();
        Mazo allCards = deckHelper.generateDeckAllCards(path);
        System.out.println("Mazo con todas las cartas creado");

        Mazo mazoConPociones = deckHelper.intercalarPociones(allCards, listaDePociones);
        deckHelper.agregarDecksALosJugadores(jugadores, mazoConPociones);
        System.out.println(jugadorOne.getName() + "--->" + jugadorOne.getMyDeck().size() + " cartas");
        System.out.println(jugadorTwo.getName() + "--->" + jugadorTwo.getMyDeck().size() + " cartas");
        System.out.println("Mazos seteados a cada jugador");

        //Inicio de rondas
        System.out.println("------------Empieza el juego--------------");
        game.play(jugadorOne, jugadorTwo);
    }

    private static ArrayList<Pocion> crearPociones() {
        //Creamos pociones
        Pocion pocionIncrementaFuerza = new PocionIncrementa("PocionIncrementadoraDeFuerza", new Atributo("fuerza", 20));
        Pocion pocionIncrementaVelocidad = new PocionIncrementa("PocionIncrementadoraDeVelocidad", new Atributo("velocidad", 10));
        Pocion pocionIncrementaPeso = new PocionIncrementa("PocionIncrementadoraDePeso", new Atributo("peso", 24));
        Pocion pocionIncrementaPeleasGanadas = new PocionIncrementa("PocionIncrementadoraDePeleasGanadas", new Atributo("peleas ganadas", 68));
        Pocion pocionIncrementaAltura = new PocionIncrementa("PocionIncrementadoraDeAltura", new Atributo("altura", 15));
        Pocion modificaTodos = new PocionModifica("ModificaTodos", new Atributo(null, 202));

        Pocion modificaFuerza = new PocionModifica("PocionModificaFuerza", new Atributo("fuerza", 20));
        Pocion modificaTodas = new PocionModifica("PocionModificaTodas", new Atributo(null, 20));

        Pocion decrementaPeso20 = new PocionDecrementa("PocionDecrementadoraDePesox20", new Atributo("peso", 20));
        Pocion decrementaPeso40 = new PocionDecrementa("PocionDecrementadoraDePesox40", new Atributo("peso", 40));

        Pocion pocionIncrementaTodo = new PocionIncrementa("PocionIncrementadoraDeTodo", new Atributo(null, 20));

        Pocion coctel = new CoctelDePociones("CoctelDePeso", decrementaPeso20, decrementaPeso40);
        ArrayList<Pocion> listaDePociones = new ArrayList<>();
        listaDePociones.add(pocionIncrementaFuerza);
        listaDePociones.add(pocionIncrementaVelocidad);
        listaDePociones.add(coctel);
        listaDePociones.add(pocionIncrementaPeso);
        listaDePociones.add(pocionIncrementaPeleasGanadas);
        listaDePociones.add(pocionIncrementaAltura);

        listaDePociones.add(modificaFuerza);
        listaDePociones.add(modificaTodas);
        listaDePociones.add(pocionIncrementaTodo);

        listaDePociones.add(modificaTodos);

        return listaDePociones;
    }
}

