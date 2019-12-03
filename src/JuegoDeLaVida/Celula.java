/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoDeLaVida;

import java.util.LinkedList;

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
    //Lista de vecinos
    private LinkedList<Celula> vecinos;
    public Celula(int posX, int posY, boolean esta){
        //Constructor 
        this.posicionX=posX;
        this.posicionY=posY;
        this.estado=esta;
        this.estadoProximo=esta;
    }
    public Celula(int posX, int posY){
        //Constructor 
        this.posicionX=posX;
        this.posicionY=posY;
        this.estado=false;
        this.estadoProximo=false;
        this.vecinos = new LinkedList<Celula>();
    }
    public void determinarEstado(){
        //Metodo para determinar el estado de cada celula
        int vecinosVivos=0;//cantidad de celulas vivas vecinas
        for(int i=0; i<this.vecinos.size();i++){
            
            if(this.vecinos.get(i).estado){//si entra aca es que alguna celula vecina esta viva
                vecinosVivos++;
            }
        }
        if(this.estado){//si la celula está viva
            //Verifica las regla de que si "tiene 2 o 3 celulas vecinas vivas, la celula vive sino muere"
            
            if(vecinosVivos!=2&&vecinosVivos!=3){
                //System.out.println("x "+this.posicionX+" y "+this.posicionY+" vecinos "+vecinosVivos);
                this.setProximoEstado(false);//La celula muere
            }
        }
        else{//Si la celula esta muerta
            //Si aparte de estar muerta, la celula tiene tres celulas vecinas vivas entontes nace
            if(vecinosVivos==3){
                this.setProximoEstado(true);
            }
            
        }
    }
    public void evolucion(){
        //Metodo para evolucionar cada celula  
        this.estado=this.estadoProximo;
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
    public void agregarVecino(Celula unaCelula){
        this.vecinos.add(unaCelula);
    }
    public void setProximoEstado(boolean estado){
        this.estadoProximo=estado;
    }
    public void setEstadoActual(boolean estado){
        this.estado=estado;
        this.estadoProximo=estado;
    }
    
}
