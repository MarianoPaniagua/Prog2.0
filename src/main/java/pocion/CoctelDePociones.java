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
    public int aplicarPocion(Carta carta, String atributo) {
        Carta copia = carta.getCopia();
        int b = copia.getAtributo(atributo).getValor();
        int a;
        if (!this.aplicada) {
            //la consigna dice de ir aplicando el valor al ultimo modificado
            a = pocion1.aplicarPocion(copia, atributo);
            copia.getAtributo(atributo).setValor(a);
            b = pocion2.aplicarPocion(copia, atributo);
            this.aplicada = true;
        }
        return b;
    }
}