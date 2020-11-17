package pocion;

import juego.Carta;

public abstract class Pocion {

    String nombre;

    boolean aplicada;

    public Pocion(String nombre, boolean aplicada) {
        this.nombre = nombre; this.aplicada = aplicada;
    }

    public abstract int aplicarPocion(Carta cartaAModificar, String Atributo);

    public String getNombre(){
        return this.nombre;
    }

}
