package pocion;

import juego.Atributo;
import juego.Card;

public class PocionModifica extends Pocion {

    Atributo atributoDeLaPocion;

    public PocionModifica(String nombre, Atributo atributoDeLaPocion) {
        super(nombre,false);
        this.atributoDeLaPocion = atributoDeLaPocion;
    }

    @Override
    public Card aplicarPocion(Card carta, String atributoCarta) {
        if (atributoDeLaPocion.getNombreAtributo() == null) {
            for (Atributo atributo : carta.getAtributos()) {
                carta.reemplazarAtributo(atributo.getNombreAtributo(), atributoDeLaPocion.getValor());
            }
            this.aplica = true;
            return carta;
        } else if (atributoCarta.equals(this.atributoDeLaPocion.getNombreAtributo())) {
            carta.reemplazarAtributo(atributoDeLaPocion.getNombreAtributo(), atributoDeLaPocion.getValor());
            this.aplica = true;
        }
        return carta;

    }

}
