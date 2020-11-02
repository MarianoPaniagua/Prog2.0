package juego;

import pocion.Pocion;

import java.util.ArrayList;
import java.util.Random;

public class Card {
    private String nombre;
    protected ArrayList<Atributo> atributos;
    private Pocion pocion;

    public Card() {
        atributos = new ArrayList<>();
    }

    public Card(String nombre, ArrayList<Atributo> atributos, Pocion pocion) {
        this.nombre = nombre;
        this.atributos = atributos;
        this.pocion = pocion;
    }

    public Card(String nombre) {
        atributos = new ArrayList<>();
    }

    public void addAtributo(String nombreAtributo, int valor) {
        this.atributos.add(new Atributo(nombreAtributo, valor));
    }

    public void addAtributo(Atributo atributo) {
        this.atributos.add(atributo);
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadAtributos() {
        return atributos.size();
    }

    public ArrayList<Atributo> getAtributos() {
        return atributos;
    }

    public ArrayList<String> getAtributosNames(ArrayList<Atributo> atributos) {
        ArrayList<String> atributosNames = new ArrayList<>();
        for (int i = 0; i < atributos.size(); i++) {
            atributosNames.add(atributos.get(i).getNombreAtributo());
        }
        return atributosNames;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAtributos(ArrayList<Atributo> atributos) {
        this.atributos = atributos;
    }

    public Atributo getAtributo(String nombreAtributo) { //pocion, si es nula, nada, si hay, aplicamos
        for (int i = 0; i < atributos.size(); i++) {
            if (atributos.get(i).getNombreAtributo().equals(nombreAtributo)) {
                return atributos.get(i);
            }
        }
        return null;
    }

    //fran medio putingo
    public void reemplazarAtributo(String nombre, int valor) {
        this.getAtributo(nombre).setValor(valor);
    }


    public String getARandomAtributeName(Card card) {
        int randomIndex = new Random().nextInt(card.getCantidadAtributos() - 1) + 1;
        String atributoRandom = atributos.get(randomIndex).getNombreAtributo();
        return atributoRandom;
    }

    public int compareCards(Card cardFromOponent, String attribute) {
        if (this.getAtributo(attribute).getValor() > cardFromOponent.getAtributo(attribute).getValor()) {
            return 1;
        } else if (this.getAtributo(attribute).getValor() < cardFromOponent.getAtributo(attribute).getValor()) {
            return -1;
        } else if (this.getAtributo(attribute).getValor() == cardFromOponent.getAtributo(attribute).getValor()) {
            return 0;
        } else return 99;
    }

    public Pocion getPocion() {
        return pocion;
    }

    public void setPocion(Pocion pocion) {
        this.pocion = pocion;
    }

    @Override
    public String toString() {
        return "Card{" +
                "nombre='" + nombre + '\'' +
                ", atributos=" + atributos +
                '}';
    }

    public Card getCopia() {
        Card copia = new Card(this.nombre);
        ArrayList array = new ArrayList(atributos);
        copia.setAtributos(array);
        return copia;
    }
}
