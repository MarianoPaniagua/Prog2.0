package pocion;

import juego.Atributo;
import juego.Carta;

public class PocionIncrementa extends Pocion {

    Atributo atributoDeLaPocion;

    public PocionIncrementa(String nombre, Atributo atributoDeLaPocion) {
        super(nombre, false);
        this.atributoDeLaPocion = atributoDeLaPocion;
    }

    @Override
    public Carta aplicarPocion(Carta carta, String atributoCarta) {
        if(!this.aplicada) {
            if (atributoDeLaPocion.getNombreAtributo() == null) {
                for (Atributo atributo : carta.getAtributos()) {
                    atributo.setValor(atributo.getValor() + ((atributo.getValor() * atributoDeLaPocion.getValor()) / 100));
                    carta.addAtributo(atributo);
                }
                System.out.println("Se aplicó la pocima " + this.nombre +
                        " , el valor resultante es " + carta.getAtributo(atributoCarta).getValor());
                return carta;
            } else if (atributoCarta.equals(this.atributoDeLaPocion.getNombreAtributo())) {
                int valorDeLACopia = carta.getAtributo(atributoDeLaPocion.getNombreAtributo()).getValor();
                int valorModificado = (valorDeLACopia + (valorDeLACopia * atributoDeLaPocion.getValor()) / 100);
                carta.reemplazarAtributo(atributoDeLaPocion.getNombreAtributo(), valorModificado);
                System.out.println("Se aplicó la pocima " + this.nombre +
                        " , el valor resultante es " + carta.getAtributo(atributoCarta).getValor());
            }
        }
        this.aplicada = true;
        return carta;
    }
}
