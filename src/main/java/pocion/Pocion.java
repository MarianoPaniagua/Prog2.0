package pocion;

import juego.Carta;

public abstract class Pocion {

    String nombre;

    boolean aplicada;

    public Pocion(String nombre, boolean aplicada) {
        this.nombre = nombre; this.aplicada = aplicada;
    }

    public abstract Carta aplicarPocion(Carta cartaAModificar, String Atributo);

    public String getnombre() {
        return this.nombre;
    }

    public boolean aplicada() {
        return this.aplicada;
    }
}
