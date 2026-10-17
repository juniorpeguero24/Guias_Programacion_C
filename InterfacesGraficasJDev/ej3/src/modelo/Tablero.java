package modelo;

import exceptions.ParametrosInvalidosException;

import java.util.Random;

public class Tablero {
    private int ancho;
    private int alto;
    private int[][] grilla;

    public Tablero(int ancho, int alto) throws ParametrosInvalidosException {
        if (ancho <= 0 || alto <= 0 || ancho * alto % 2 != 0)
            throw new ParametrosInvalidosException("\nError de parametros.");
        this.ancho = ancho;
        this.alto = alto;
        this.grilla = new int[alto][ancho];
        iniciaGrilla();
        poneImagenes();
    }
    
    public int getFigura(int i,int j) {
        return this.grilla[i][j];
    }

    public void iniciaGrilla(){
        for (int i = 0; i < this.alto; i++) {
            for (int j = 0; j < this.ancho; j++) {
                this.grilla[i][j]=0;
            }
        }
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }


    public int[][] getGrilla() {
        return grilla;
    }

    private void poneImagenes() {
        Random r = new Random();
        for (int k=0;k<(this.alto*this.ancho)/2;k++){
            int i;
            int j;
            do {
                i = r.nextInt(this.alto);
                j = r.nextInt(this.ancho);
            } while (this.grilla[i][j] != 0);
            this.grilla[i][j] = k + 1;
            do{
                i = r.nextInt(this.alto);
                j = r.nextInt(this.ancho);
            }while (this.grilla[i][j] != 0);
            this.grilla[i][j] = k + 1;
        }
    }
}
