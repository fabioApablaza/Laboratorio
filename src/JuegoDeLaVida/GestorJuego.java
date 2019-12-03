/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoDeLaVida;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Apablaza Fabio
 */
public class GestorJuego implements Runnable{
    private LinkedList<Tarea> listaTareas;
    private Celula[][] unMundo;
    private Tablero unTablero;
    public GestorJuego(Tablero unT, LinkedList<Tarea> listaT, Celula[][] unMun){
        this.unTablero=unT;
        this.listaTareas=listaT;
        this.unMundo= unMun;
    }
    @Override
    public void run() {
        while(true){
            System.out.println(this.unTablero.toString());
            this.unTablero.turno();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GestorJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
