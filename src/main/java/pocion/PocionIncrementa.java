package pocion;

import juego.Atributo;
import juego.Carta;

public class  PocionIncrementa extends Pocion {

    Atributo atributoDeLaPocion;

    public PocionIncrementa(String nombre, Atributo atributoDeLaPocion) {
        super(nombre, false);
        this.atributoDeLaPocion = atributoDeLaPocion;
    }

    @Override
    public Carta aplicarPocion(Carta carta, String atributoCarta) {
        if (!this.aplicada) {
            for (Atributo atributo : carta.getAtributos()) {
                if (this.atributoDeLaPocion.getNombreAtributo() == null || atributo.getNombreAtributo().equals(this.atributoDeLaPocion.getNombreAtributo())) {
                    atributo.setValor(atributo.getValor() + ((atributo.getValor() * this.atributoDeLaPocion.getValor()) / 100));
                }
            }
        }
        if (!this.aplicada && (atributoDeLaPocion.getNombreAtributo() == null || atributoCarta.equals(atributoDeLaPocion.getNombreAtributo()))) {
            System.out.println("Se aplicó la pocima " + this.nombre +
                    " , el valor resultante es " + carta.getAtributo(atributoCarta).getValor());
        }
        this.aplicada = true;
        return carta;

    }
}
