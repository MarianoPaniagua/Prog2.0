package pocion;

import juego.Atributo;
import juego.Carta;

public class PocionModifica extends Pocion {

    Atributo atributoDeLaPocion;

    public PocionModifica(String nombre, Atributo atributoDeLaPocion) {
        super(nombre, false);
        this.atributoDeLaPocion = atributoDeLaPocion;
    }

    @Override
    public Carta aplicarPocion(Carta carta, String atributoCarta) {
        if (!this.aplicada) {
            for (Atributo atributo : carta.getAtributos()) {
                if (atributoDeLaPocion.getNombreAtributo() == null || atributo.getNombreAtributo().equals(atributoDeLaPocion.getNombreAtributo())) {
                    carta.reemplazarAtributo(atributo.getNombreAtributo(), atributoDeLaPocion.getValor());
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
