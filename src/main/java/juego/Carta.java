package juego;

import pocion.Pocion;

import java.util.ArrayList;
import java.util.Random;

public class Carta {
    private String nombre;
    protected ArrayList<Atributo> atributos;
    private Pocion pocion;

    public Carta() {
        atributos = new ArrayList<>();
    }

    public Carta(String nombre, Pocion pocion) {
        this.nombre = nombre;
        this.atributos = new ArrayList<>();
        this.pocion = pocion;
    }

    public Carta(String nombre) {
        atributos = new ArrayList<>();
        this.nombre = nombre;
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
        return new ArrayList<>(atributos);
    }

    public ArrayList<String> getAtributosNames(ArrayList<Atributo> atributos) {
        ArrayList<String> atributosNames = new ArrayList<>();
        for (Atributo atributo : atributos) {
            atributosNames.add(atributo.getNombreAtributo());
        }
        return atributosNames;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Atributo getAtributo(String nombreAtributo) { //pocion, si es nula, nada, si hay, aplicamos
        for (int i = 0; i < atributos.size(); i++) {
            if (atributos.get(i).getNombreAtributo().equals(nombreAtributo)) {
                return atributos.get(i);
            }
        }
        return null;
    }

    public String getARandomAtributeName() {
        int randomIndex = new Random().nextInt(this.getCantidadAtributos() - 1) + 1;
        String atributoRandom = atributos.get(randomIndex).getNombreAtributo();
        return atributoRandom;
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

    public Carta getCopia() {
        Carta copia = new Carta(this.nombre);
        for (Atributo a : atributos) {
            copia.addAtributo(a.getCopiaAtr());
        }
        return copia;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Carta cartaAComparar = (Carta) obj;
            if (!cartaAComparar.getAtributosNames(cartaAComparar.getAtributos()).containsAll(this.getAtributosNames(this.getAtributos()))) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
