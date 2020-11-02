package juego;

import criterio.Criterio;
import pocion.Pocion;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                Carta cartita = new Carta();
                cartita.setNombre(nombreCarta);

                String atributosStr = "";
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

    public Mazo filtrarMazoPorCriterio(Mazo mazoToFilter, List<Criterio> criterios) {
        Mazo filteredMazo = new Mazo();
        boolean cumple = true;
        for (int i = 0; i < mazoToFilter.size(); i++) {
            for (int j = 0; j < criterios.size(); j++) {
                if (!criterios.get(j).cumpleCriterio(mazoToFilter.getCard(i))) {
                    cumple = false;
                }
            }
            if (cumple) {
                filteredMazo.addCard(mazoToFilter.getCard(i));
            }
            cumple = true;
        }
        return filteredMazo;
    }

    private Mazo repartirDeck(Mazo allCards, int extraCard) {
        int i;
        ArrayList<Carta> cartaselegidas = new ArrayList<>();
        for (i = 0; i < (allCards.size() / 2) + extraCard; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, allCards.size());
            cartaselegidas.add(allCards.getMazo().get(randomNum));
        }
        Mazo mazoRepartido = new Mazo();
        mazoRepartido.setMazo(cartaselegidas);
        return mazoRepartido;
    }

    public Mazo generateDeck(Mazo allCards, boolean isPlayer1, List<Criterio> criterios) {
        int extraCard = 0;
        if (isPlayer1 && allCards.size() % 2 > 0) {
            extraCard = 1;
        }
        Mazo mazoRepartido = repartirDeck(filtrarMazoPorCriterio(allCards, criterios), extraCard);
        return mazoRepartido;
    }

    public Mazo intercalarPociones(Mazo mazoGeneral, List<Pocion> pociones) {
        int i;
        for(i = 0; i < pociones.size(); i++){
            int randomNumCard = ThreadLocalRandom.current().nextInt(0, mazoGeneral.size());
            mazoGeneral.getCard(randomNumCard).setPocion(pociones.get(i));
        }
        return mazoGeneral;
    }
}
