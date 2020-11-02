package pocion;

import juego.Carta;

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
    public Carta aplicarPocion(Carta carta, String atributo) {
        if(!this.aplicada) {
            for (Pocion pocion : pociones) {
                carta = pocion.aplicarPocion(carta, atributo);
            }
        }
        this.aplicada = true;
        return carta;
    }
}
