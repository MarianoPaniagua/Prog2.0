package pocion;

import juego.Atributo;
import juego.Carta;

public class PocionDecrementa extends Pocion {

    Atributo atributoDeLaPocion;

    public PocionDecrementa(String nombre, Atributo atributoDeLaPocion) {
        super(nombre, false);
        this.atributoDeLaPocion = atributoDeLaPocion;
    }

    @Override
    public int aplicarPocion(Carta carta, String atributoAJugar) {
        if (!this.aplicada) {
            Carta copia = carta.getCopia();
            //si el atributo esta seteado como null, entonces aplicamos la pocion a todos los atributos
            if (this.atributoDeLaPocion.getNombreAtributo() == null) {
                for (Atributo atributo : copia.getAtributos()) {
                    atributo.setValor(atributo.getValor() -
                            ((atributo.getValor() * this.atributoDeLaPocion.getValor()) / 100));
                }
            } else if (atributoAJugar.equals(atributoDeLaPocion.getNombreAtributo())) {
                Atributo atributoAModificar = copia.getAtributo(atributoAJugar);
                atributoAModificar.setValor(atributoAModificar.getValor() -
                        ((atributoAModificar.getValor() * this.atributoDeLaPocion.getValor()) / 100));
            }
            this.aplicada = true;
            return copia.getAtributo(atributoAJugar).getValor();
        }
        return carta.getAtributo(atributoAJugar).getValor();
    }
}
