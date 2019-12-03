package JuegoDeLaVida;

import java.util.LinkedList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Apablaza Fabio
 */
public class Tablero {

    //Matriz que representa el mundo de las celulas
    private final Celula[][] mundo;
    //
    private ExecutorService executor;
    //
    private CyclicBarrier barrera;
    //
    private LinkedList<Tarea> listaTareas;
    //Cantidad de tareas
    private int CANTTAREAS = 3;

    public Tablero(int Tamaño) {//El mundo siempre va a tener el mismo ancho y alto
        //Constructor del tablero
        this.mundo = new Celula[Tamaño][Tamaño];
        this.listaTareas = new LinkedList<Tarea>();
        barrera = new CyclicBarrier(CANTTAREAS);
        this.crearCelulas();
        this.vecinosCelulas();
        
    }

    private void crearCelulas() {
        //Metodo para crear las celulas
        for (int i = 0; i < mundo.length; i++) {
            for (int j = 0; j < mundo[0].length; j++) {
                mundo[i][j] = new Celula(i, j);
            }
        }
    }

    private void vecinosCelulas() {
        for (int i = 0; i < mundo.length; i++) {
            for (int j = 0; j < mundo.length; j++) {
                this.definirVecinosCelulas(i, j);
            }
        }
    }

    private void definirVecinosCelulas(int i, int j) {
        int k = i, m = j;
        Celula unaCelula = mundo[k][m];
        // 1er vecino
        k = i - 1;
        if (k < 0) {
            k=this.mundo.length - 1;
        }

        unaCelula.agregarVecino(mundo[k][m]);
        // 2do vecino
        k = i + 1;
        if (k >= this.mundo.length) {
            k = 0;
        }
        unaCelula.agregarVecino(mundo[k][m]);
        // 3er vecino
        k = i;
        m = j - 1;
        if (m < 0) {
            m = this.mundo.length - 1;
        }
        unaCelula.agregarVecino(mundo[k][m]);
        // 4to vecino
        m = j + 1;
        if (m >= this.mundo.length) {
            m = 0;
        }
        unaCelula.agregarVecino(mundo[k][m]);
        // 5to vecino
        k = i - 1;
        m = j - 1;
        if (k < 0) {
            k = this.mundo.length - 1;
        }
        if (m < 0) {
            m = this.mundo.length - 1;
        }
        unaCelula.agregarVecino(mundo[k][m]);
        // 6to vecino
        k = i + 1;
        m = j + 1;
        if (k >= this.mundo.length) {
            k = 0;
        }
        if (m >= this.mundo.length) {
            m = 0;
        }
        unaCelula.agregarVecino(mundo[k][m]);
        // 7mo vecino
        k = i + 1;
        m = j - 1;
        if (k >= this.mundo.length) {
            k = 0;
        }
        if (m < 0) {
            m = this.mundo.length - 1;
        }
        unaCelula.agregarVecino(mundo[k][m]);
        // 8vo vecino
        k = i - 1;
        m = j + 1;
        if (k < 0) {
            k = this.mundo.length - 1;
        }
        if (m >= this.mundo.length) {
            m = 0;
        }
        unaCelula.agregarVecino(mundo[k][m]);
    }

    public void inicio() {
        //Metodo para iniciar todo el desarrollo del juego
        int TAMAÑO = this.mundo[0].length, columnaInicial = 0;
        //Creación de las tareas
        int cantCadaHilo = TAMAÑO / CANTTAREAS, columnaFinal = cantCadaHilo - 1;
        executor = Executors.newFixedThreadPool(CANTTAREAS);
        
        Patrones.seleccionDePatrones(mundo);//seleccion del patron o diseño de la matriz
        for (int i = 0; i < CANTTAREAS; i++) {
            Tarea tarea = new Tarea(i, TAMAÑO, columnaInicial, columnaFinal, mundo, barrera);
            columnaInicial += cantCadaHilo;
            columnaFinal += cantCadaHilo;
            listaTareas.add(tarea);
        }

        GestorJuego unGestor = new GestorJuego(this, this.listaTareas, this.mundo);
        unGestor.run();
    }

    public void turno() {
        for (int i = 0; i < this.listaTareas.size(); i++) {
            this.executor.execute(this.listaTareas.get(i));
        }
    }

    @Override
    public String toString() {
        //Metodo para imprimir la matriz
        String res = "";
        for (int i = 0; i < this.mundo.length; i++) {
            res = res + "| ";
            for (int j = 0; j < this.mundo[0].length; j++) {
                if (this.mundo[i][j].getEstado()) {
                    //Si entra aca es que la celula en esta posicion esta viva
                    res = res + "0 ";
                } else {
                    //Si entra aca es que la celula en esta posicion esta muerta
                    res = res + ". ";
                }

            }
            res = res + " |";
            res += "\n";
        }
        return res;
    }
}
