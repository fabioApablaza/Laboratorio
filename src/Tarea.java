
import java.util.concurrent.Callable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Tarea implements Callable<Integer>{
    private int start;// Variable que guardara el valor desde donde empezara a sumar en el arreglo
    private int end;// Variable que guardara el valor desde donde terminara de sumar el arreglo
    private int[] arreglo;
    public Tarea(int inicio, int fin, int[] arr){
        //Constructor
        this.start=inicio;
        this.end=fin;
        this.arreglo=arr;
    }

    @Override
    public Integer call() throws Exception {
        int res=0;//Declaración de la variable resultado
        //Cada hilo sumara desde el inicio dado hasta el fin
        for (int i=start;i<end;i++){
            res+=arreglo[i];
        }
        return res;
    }
    
}
