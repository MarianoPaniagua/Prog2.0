package pocion;

import juego.Atributo;
import juego.Card;

public class PocionIncrementa extends Pocion {

    Atributo atributoDeLaPocion;

    public PocionIncrementa(String nombre, Atributo atributoDeLaPocion) {
        super(nombre, false);
        this.atributoDeLaPocion = atributoDeLaPocion;
    }

    @Override
    public Card aplicarPocion(Card carta, String atributoCarta) {
        if (atributoDeLaPocion.getNombreAtributo() == null) {
            for (Atributo atributo : carta.getAtributos()) {
                atributo.setValor(atributo.getValor() + ((atributo.getValor() * atributoDeLaPocion.getValor()) / 100));
                carta.addAtributo(atributo);
            }
            this.aplica = true;
            return carta;
        } else if(atributoCarta.equals(this.atributoDeLaPocion.getNombreAtributo())){
            int valorDeLACopia = carta.getAtributo(atributoDeLaPocion.getNombreAtributo()).getValor();
            int valorModificado = (valorDeLACopia + (valorDeLACopia * atributoDeLaPocion.getValor()) / 100);
            carta.reemplazarAtributo(atributoDeLaPocion.getNombreAtributo(), valorModificado);
            this.aplica = true;
        }
        return carta;
    }
}
