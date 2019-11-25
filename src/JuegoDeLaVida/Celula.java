/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoDeLaVida;

/**
 *
 * @author Apablaza Fabio
 */
public class Celula {
    //Variable que representa el estado de la celula.
    private boolean estado;
    //Variable que representa el proximo estado de la celula.
    private boolean estadoProximo;
    //Posicicion en la matriz horizontalmente
    private int posicionX;
    //Posicicion en la matriz verticalmente
    private int posicionY;
    public Celula(int posX, int posY, boolean esta){
        //Constructor 
        this.posicionX=posX;
        this.posicionY=posY;
        this.estado=esta;
        this.estadoProximo=esta;
    }
    public void evolucion(){
        //Metodo para evolucionar
        if(this.estado!=this.estadoProximo){
            this.estado=this.estadoProximo;
        }
    }
    //getters and setters
    public boolean getEstado(){
        return this.estado;
    }
    public int getPosicionX(){
        return this.posicionX;
    }
    public int getPosicionY(){
        return this.posicionY;
    }
    
    
}
