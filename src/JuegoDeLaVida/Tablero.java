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
public class Tablero {
    //Matriz que representa el mundo de las celulas
    private final Celula[][] mundo;
    //Constante para restringir el tamaño del mundo
    private final int TAMAÑOMUNDOCONTROLADOR = 4;
    
    public Tablero(int Tamaño){
        //Constructor del tablero
        this.mundo= new Celula[TAMAÑOMUNDOCONTROLADOR * Tamaño][TAMAÑOMUNDOCONTROLADOR * Tamaño];
    }
    
}
