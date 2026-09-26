package excepciones;

import paquete.Arquero;
import paquete.Personaje;

public class AtaqueImposibleException extends Exception{
    @SuppressWarnings("compatibility:166376295984548934")
    private static final long serialVersionUID = 1L;
    private Personaje atacante,atacado;
    
    public AtaqueImposibleException(Personaje atacante, Personaje atacado) {
        super("\n[ERROR] Ataque imposible. No esta a distancia de ataque.\n");
        this.atacado=atacado;
        this.atacante=atacante;
    }

    public Personaje getAtacante() {
        return atacante;
    }

    public Personaje getAtacado() {
        return atacado;
    }
}
