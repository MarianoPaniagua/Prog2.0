package estrategia;

import juego.Atributo;
import juego.Carta;

public abstract class Estrategia {

    private String nombre;

    public Estrategia(String nombre) {
        this.nombre = nombre;
    }

    public abstract String jugarEstrategia(Carta carta);
}
