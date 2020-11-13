package juego;

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
               if(mazo.size() == 0) {
                   mazo.addCard(cartita);
               } else{
                   if(cartita.equals(mazo.getCard(0))){
                       mazo.addCard(cartita);
                   }
               }
            }
            reader.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        return mazo;
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

    public void agregarDecksALosJugadores(List<Jugador> jugadores, Mazo allCards){
        int t;
        int total = allCards.getMazo().size();
        for(t=0;t<total;t++){
            if(allCards.getMazo().isEmpty()){
                continue;
            }
            jugadores.get(0).agregarCartaAlMazo(allCards.getCard(0));
            allCards.takeCard(0);
            if(allCards.getMazo().isEmpty()){
                continue;
            }
            jugadores.get(1).agregarCartaAlMazo(allCards.getCard(0));
            allCards.takeCard(0);
        }
    }

    public Mazo intercalarPociones(Mazo mazoGeneral, List<Pocion> pociones) {
        int i;
        for(i=0;i<pociones.size();i++){
            mazoGeneral.getCard(i).setPocion(pociones.get(i));
        }
        return mazoGeneral;
    }
}
