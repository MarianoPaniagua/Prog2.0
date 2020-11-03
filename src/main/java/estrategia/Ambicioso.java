package estrategia;

import juego.Atributo;
import juego.Carta;

public class Ambicioso extends Estrategia {

    public Ambicioso(String nombre) {
        super(nombre);
    }

    @Override
    public Atributo jugarEstrategia(Carta carta) {
        Atributo maxValor = new Atributo();
        maxValor.setValor(0);
        for (Atributo atributo: carta.getAtributos()) {
            if(maxValor.getValor() < atributo.getValor()){
                maxValor.setNombreAtributo(atributo.getNombreAtributo());
                maxValor.setValor(atributo.getValor());
            }
        }
        return maxValor;
    }
}
