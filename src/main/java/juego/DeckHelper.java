package juego;

import pocion.Pocion;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;
import java.util.List;

public class DeckHelper {

    public Mazo generateDeckAllCards(String path) {
        Mazo mazo = new Mazo();
        File jsonInputFile = new File(path);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre");
                JsonObject atributos = carta.getJsonObject("atributos");
                Carta cartita = new Carta();
                cartita.setNombre(nombreCarta);

                for (String nombreAtributo : atributos.keySet()) {
                    Atributo atributo = new Atributo();
                    atributo.setNombreAtributo(nombreAtributo);
                    atributo.setValor(atributos.getInt(nombreAtributo));
                    cartita.addAtributo(atributo);
                }
                mazo.addCard(cartita);
            }
            reader.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        return mazo;
    }

    public void agregarDecksALosJugadores(List<Jugador> jugadores, Mazo allCards) {
        int t;
        int total = allCards.getMazo().size();
        for (t = 0; t < total; t++) {
            if (allCards.getMazo().isEmpty()) {
                continue;
            }
            jugadores.get(0).agregarCartaAlMazo(allCards.getCard(0));
            allCards.takeCard(0);
            if (allCards.getMazo().isEmpty()) {
                continue;
            }
            jugadores.get(1).agregarCartaAlMazo(allCards.getCard(0));
            allCards.takeCard(0);
        }
    }

    public Mazo intercalarPociones(Mazo mazoGeneral, List<Pocion> pociones) {
        int i;
        for (i = 0; i < pociones.size(); i++) {
            mazoGeneral.getCard(i).setPocion(pociones.get(i));
        }
        return mazoGeneral;
    }
}