package pocion;

import juego.Card;

public abstract class Pocion {

    String nombre;

    boolean aplica;

    public Pocion(String nombre, boolean aplica) {
        this.nombre = nombre; this.aplica = aplica;
    }

    public abstract Card aplicarPocion(Card cartaAModificar, String Atributo);

    public String getnombre() {
        return this.nombre;
    }

    public boolean getAplica() {
        return this.aplica;
    }
}
