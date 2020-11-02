package pocion;

import juego.Card;

import java.util.ArrayList;

public class CoctelDePociones extends Pocion{

    ArrayList<Pocion> pociones;

    public CoctelDePociones(String nombre) {
        super(nombre,false);
        this.pociones = new ArrayList<>();
    }

    public CoctelDePociones(String nombre, ArrayList<Pocion> pociones) {
        super(nombre, false);
        this.pociones = pociones;
    }

    @Override
    public Card aplicarPocion(Card carta, String atributo) {
        for(Pocion pocion : pociones){
            carta = pocion.aplicarPocion(carta, atributo);
        }
        return carta;
    }
}
