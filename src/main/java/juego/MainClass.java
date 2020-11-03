package juego;

import estrategia.Estrategia;
import estrategia.Obstinado;
import criterio.CriterioCantAtributos;
import criterio.Criterio;
import criterio.CriterioNombreAtributos;
import estrategia.Timbero;
import pocion.CoctelDePociones;
import pocion.Pocion;
import pocion.PocionDecrementa;
import pocion.PocionIncrementa;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        String path = "C:\\Users\\Francisco\\Desktop\\Prog 2.0\\Prog2.0\\src\\main\\java\\juego\\superheroes.json";

        ArrayList<Pocion> listaDePociones = crearPociones();
        ArrayList<Criterio> criterios = crearCriterios();
        //Se crea el juego y el criterio (tipo de cartas del que se tratará el juego)
        Game game = new Game();
        System.out.println("Juego creado");

        //Se crean 2 jugadores
        Jugador jugadorOne = new Jugador("Mariano");
        Jugador jugadorTwo = new Jugador("Fran");
        System.out.println("Jugadores creados");

        //Se setean estrategias para cada jugador.
        Estrategia elegirMayor = new Obstinado("ambicioso", "fuerza");
        Estrategia elegirRandom = new Timbero("timbero");
        jugadorOne.setEstrategia(elegirRandom);
        jugadorTwo.setEstrategia(elegirRandom);

        //Se crea el mazo general
        DeckHelper deckHelper = new DeckHelper();
        Mazo allCards = deckHelper.generateDeckAllCards(path);
        System.out.println("Mazo con todas las cartas creado");

        //Se incorporan pociones al mazo general para posterior repartida
        allCards = deckHelper.intercalarPociones(allCards, listaDePociones);

        //Se asigna un mazo (filtrado según criterio) a cada jugador
        jugadorOne.setMyDeck(deckHelper.generateDeck(allCards, true, criterios));
        System.out.println(jugadorOne.getName() + "--->" + jugadorOne.getMyDeck().size() + " cartas");
        jugadorTwo.setMyDeck(deckHelper.generateDeck(allCards, false, criterios));
        System.out.println(jugadorTwo.getName() + "--->" + jugadorTwo.getMyDeck().size() + " cartas");
        System.out.println("Mazos seteados a cada jugador");

        //Inicio de rondas
        System.out.println("------------Empieza el juego--------------");
        game.play(jugadorOne, jugadorTwo);
    }

    private static ArrayList<Criterio> crearCriterios() {
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
        return criterios;
    }

    private static ArrayList<Pocion> crearPociones() {
        //Creamos pociones
        Pocion pocionIncrementaFuerza = new PocionIncrementa("PocionIncrementadoraDeFuerza", new Atributo("fuerza", 20));
        Pocion pocionIncrementaVelocidad = new PocionIncrementa("PocionIncrementadoraDeVelocidad", new Atributo("velocidad", 10));
        Pocion pocionIncrementaPeso = new PocionIncrementa("PocionIncrementadoraDePeso", new Atributo("peso", 24));
        Pocion pocionIncrementaPeleasGanadas = new PocionIncrementa("PocionIncrementadoraDePeleasGanadas", new Atributo("peleas ganadas", 68));
        Pocion pocionIncrementaAltura = new PocionIncrementa("PocionIncrementadoraDeAltura", new Atributo("altura", 15));

        Pocion decrementaPeso20 = new PocionDecrementa("PocionDecrementadoraDePesox20", new Atributo("peso", 20));
        Pocion decrementaPeso40= new PocionDecrementa("PocionDecrementadoraDePesox40", new Atributo("peso", 40));
        ArrayList<Pocion> listParaElCoctel = new ArrayList<>();
        listParaElCoctel.add(decrementaPeso20);
        listParaElCoctel.add(decrementaPeso40);
        Pocion coctel = new CoctelDePociones("Coctel", listParaElCoctel);
        ArrayList<Pocion> listaDePociones = new ArrayList<>();
        listaDePociones.add(pocionIncrementaFuerza);
        listaDePociones.add(pocionIncrementaVelocidad);
        listaDePociones.add(coctel);
        listaDePociones.add(pocionIncrementaPeso);
        listaDePociones.add(pocionIncrementaPeleasGanadas);
        listaDePociones.add(pocionIncrementaAltura);

        return listaDePociones;
    }
}

