
package JuegoDeLaVida;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Apablaza Fabio
 */
public class Tarea implements Runnable{
    private int limX,columnaInicial,columnaFinal,id;
    private Celula[][] mundo;
    private CyclicBarrier barrera;
    public Tarea(int identificador, int rondas, int columnaI, int columnaF, Celula[][] mun, CyclicBarrier bar){
        //Costructor para cada tarea
        this.limX=rondas;
        this.columnaInicial=columnaI;
        this.columnaFinal=columnaF;
        this.id=identificador;
        this.mundo=mun;
        this.barrera=bar;
    }
    @Override
    public void run() {
        //Recorre todo su parte del mundo para determinar el proximo estado de cada celula
        for(int i=0; i<this.limX;i++){
            for(int j=this.columnaInicial; j<=this.columnaFinal;j++){
                //System.out.println("Tarea id "+id+" i= "+i+" j= "+j+" limX= "+limX+" columnaInicial= "+columnaInicial+" columnaFinal= "+columnaFinal);
                
                this.mundo[i][j].determinarEstado();
            }
        }
        try {
            
            this.barrera.await();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Tarea.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Vuelve a recorrer la parte del mundo para que las celulas cambien de estado
        for(int i=0; i<this.limX;i++){
            for(int j=columnaInicial; j<=columnaFinal;j++){
                this.mundo[i][j].evolucion();
            }
        }
    }
    
}
