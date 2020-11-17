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
    public int aplicarPocion(Carta carta, String atributoAJugar) {
        if (!this.aplicada) {
            Carta copia = carta.getCopia();
            //si el atributo esta seteado como null, entonces aplicamos la pocion a todos los atributos
            if (this.atributoDeLaPocion.getNombreAtributo() == null) {
                for (Atributo atributo : copia.getAtributos()) {
                    atributo.setValor(atributoDeLaPocion.getValor());
                }
            } else if (atributoAJugar.equals(atributoDeLaPocion.getNombreAtributo())) {
                Atributo atributoAModificar = copia.getAtributo(atributoAJugar);
                atributoAModificar.setValor(atributoDeLaPocion.getValor());
            }
            this.aplicada = true;
            return copia.getAtributo(atributoAJugar).getValor();
        }
        return carta.getAtributo(atributoAJugar).getValor();
    }
}
