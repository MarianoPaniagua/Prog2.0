package pocion;

import juego.Atributo;
import juego.Carta;

public class PocionModifica extends Pocion {

    Atributo atributoDeLaPocion;

    public PocionModifica(String nombre, Atributo atributoDeLaPocion) {
        super(nombre,false);
        this.atributoDeLaPocion = atributoDeLaPocion;
    }

    @Override
    public Carta aplicarPocion(Carta carta, String atributoCarta) {
        if(!this.aplicada) {
            if (atributoDeLaPocion.getNombreAtributo() == null) {
                for (Atributo atributo : carta.getAtributos()) {
                    carta.reemplazarAtributo(atributo.getNombreAtributo(), atributoDeLaPocion.getValor());
                }
                System.out.println("Se aplicó la pocima " + this.nombre +
                        " , el valor resultante es " + carta.getAtributo(atributoCarta).getValor());
                return carta;
            } else if (atributoCarta.equals(this.atributoDeLaPocion.getNombreAtributo())) {
                carta.reemplazarAtributo(atributoDeLaPocion.getNombreAtributo(), atributoDeLaPocion.getValor());
                System.out.println("Se aplicó la pocima " + this.nombre +
                        " , el valor resultante es " + carta.getAtributo(atributoCarta).getValor());
            }
        }
        this.aplicada = true;
        return carta;
    }

}
