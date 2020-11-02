package estrategia;

import juego.Atributo;
import juego.Carta;

public class Timbero  extends Estrategia{

    public Timbero(String nombre) {
        super(nombre);
    }

    @Override
    public Atributo jugarEstrategia(Carta carta) {//Juega con un atributo random siempre.
        Atributo atributoQueDevuelvo= new Atributo();
        atributoQueDevuelvo.setNombreAtributo(carta.getARandomAtributeName());//Tomo un (nombre) atributo random de la lista de atributos de la carta
        atributoQueDevuelvo.setValor(carta.getAtributo(atributoQueDevuelvo.getNombreAtributo()).getValor());//Seteo el valor de ese atributo extrayendolo de la carta.
        return atributoQueDevuelvo;
    }
}
