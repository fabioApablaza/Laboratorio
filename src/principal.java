
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.Scanner;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 */
/**
 *
 * @author Apablaza Fabio
 */
public class principal {

    private static final int TAMAÑO = 50000;//Tamaño del arreglo
    private static Random ALEATORIO = new Random();// Variable RANDOM
    private static int[] arreglo = new int[TAMAÑO];//Definicion del arreglo
    private static Scanner scn = new Scanner(System.in);

    public static void cargarArreglo() {
        //Metodo para cargar de numeros del 1 al 10 aleatorios al arreglo antes predefinido
        for (int i = 0; i < TAMAÑO; i++) {
            arreglo[i] = ALEATORIO.nextInt(10) + 1;
        }
    }

    public static int sumarArreglo() {
        //Metodo para sumar secuencialmente el arreglo
        int res = 0;
        for (int i = 0; i < TAMAÑO; i++) {
            res += arreglo[i];
        }
        return res;
    }

    public static int crearTareas(int tareas, int hilos, int cantAsumar) throws ExecutionException {
        int inicio = 0, fin, suma = 0;
        fin = cantAsumar - 1;
        LinkedList<Tarea> tareasSumadoras = new LinkedList<Tarea>();
        ExecutorService executor = Executors.newFixedThreadPool(hilos);
        for (int i = 0; i < tareas; i++) {
            Tarea sumador = new Tarea(inicio, fin, arreglo);
            tareasSumadoras.add(sumador);
            inicio = fin;
            fin += cantAsumar;
        }
        fin=TAMAÑO;
        Tarea sumador = new Tarea(inicio, fin, arreglo);
        tareasSumadoras.add(sumador);
        
        try {
            List<Future<Integer>> listaFuture = executor.invokeAll(tareasSumadoras);
            for (int j = 0; j < listaFuture.size(); j++) {
                suma += listaFuture.get(j).get();
            }
            executor.shutdown();
        } catch (InterruptedException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        return suma;
    }

    public static void main(String[] args) throws ExecutionException {
        //Declaración de variables
        int tareas, hilos, resultado = 0, cantAsumar = 0, resultadoTareas;

        System.out.print("Ingrese la cantidad de tareas: ");
        tareas = scn.nextInt();

        System.out.print("Ingrese la cantidad de hilos: ");
        hilos = scn.nextInt();

        cantAsumar = TAMAÑO / tareas;

        cargarArreglo();//Se carga el arreglo

        resultadoTareas = crearTareas(tareas, hilos, cantAsumar); //Creación de tareas

        resultado = sumarArreglo();
        
        System.out.println("El resultado de la suma del arreglo sumado con tareas es: " + resultadoTareas);
        System.out.println("El resultado de la suma del arreglo sumado secuencialmente es: " + resultado);
    }
}
