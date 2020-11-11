package pocion;

import juego.Carta;

public class CoctelDePociones extends Pocion {

    Pocion pocion1;
    Pocion pocion2;

    public CoctelDePociones(String nombre, Pocion pocion1, Pocion pocion2) {
        super(nombre, false);
        this.pocion1 = pocion1;
        this.pocion2 = pocion2;
    }

    @Override
    public Carta aplicarPocion(Carta carta, String atributo) {
        if (!this.aplicada) {
            carta = pocion1.aplicarPocion(carta, atributo);
            carta = pocion2.aplicarPocion(carta, atributo);
        }
        this.aplicada = true;
        return carta;
    }
}