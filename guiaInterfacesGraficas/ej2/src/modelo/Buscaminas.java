package modelo;

import excepciones.FueraTableroException;
import excepciones.ParametrosInvalidosException;
import java.util.Random;

public class Buscaminas {
    private int ancho;
    private int alto;
    private int minas;
    private boolean[][] grilla;

    public Buscaminas(int ancho, int alto, int minas) throws ParametrosInvalidosException {
        if (alto <= 0 || ancho <= 0 || minas < 0 || (minas > ancho*alto))
            throw new ParametrosInvalidosException("\nError parametro invalido.");
        this.ancho = ancho;
        this.alto = alto;
        this.minas = minas;
        this.grilla=new boolean[alto][ancho];
        poneMinas();
    }

    private void poneMinas() {
        int k=this.minas;
        Random r = new Random();
        while (k > 0) {
            int i=r.nextInt(this.alto);
            int j=r.nextInt(this.ancho);
            if (!this.grilla[i][j]) {
                k--;
                this.grilla[i][j]=true;
            }
        }
    }

    public int getMinasCercanas(int i,int j) throws FueraTableroException {
        if (i >= this.alto || j >= this.ancho || i < 0 || j < 0) {
            throw new FueraTableroException("\nError fuera del tablero.");
        }
        int sum=0;
        for (int k = Math.max(0,i - 1); k <= Math.min(this.alto-1,i + 1); k++) {
            for (int l = Math.max(0,j - 1); l <= Math.min(this.ancho-1,j + 1); l++) {
                if (k == i && l == j) {
                    continue;
                }
                if (this.grilla[k][l]) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public boolean isMina(int i, int j) throws FueraTableroException {
        if (i < 0 || j < 0 || i >= this.alto || j >= this.ancho) {
            throw new FueraTableroException("\nError fuera del tablero.");
        }
        return this.grilla[i][j];
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getMinas() {
        return minas;
    }
}
