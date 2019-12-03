/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoDeLaVida;

import java.util.Scanner;

/**
 *
 * @author Apablaza Fabio
 */
public class Patrones {

    private static Scanner sc = new Scanner(System.in);

    public static void seleccionDePatrones(Celula[][] unaMatriz) {
        int opcion;
        boolean exito = true;
        while (exito) {
            menu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    definir(unaMatriz);
                    exito = false;
                    break;
                }
                case 2: {
                    glinder(unaMatriz);
                    exito = false;
                    break;
                }
                case 3: {
                    smallExploder(unaMatriz);
                    exito = false;
                    break;
                }
                case 4: {
                    exploder(unaMatriz);
                    exito = false;
                    break;
                }
                case 5: {
                    tenCellRow(unaMatriz);
                    exito = false;
                    break;
                }
                case 6: {
                    lightweightSpaceship(unaMatriz);
                    exito = false;
                    break;
                }
                case 7: {
                    tumbler(unaMatriz);
                    exito = false;
                    break;
                }
                default: {
                    System.out.println("Esa opcion no existe");
                    break;
                }
            }
        }

    }

    private static void menu() {
        //Metodo para mostrar menu        
        System.out.println("Seleccione un patron o personalice el suyo:");
        System.out.println("1. Personalizar.");
        System.out.println("2. Glinder.");
        System.out.println("3. Small Exploder.");
        System.out.println("4. Exploder.");
        System.out.println("5. 10 Cell Row.");
        System.out.println("6. lightweightSpaceship.");
        System.out.println("7. Tumbler.");
        System.out.print("Ingrese la opcion: ");
    }

    private static void definir(Celula[][] unaMatriz) {
        //Metodo para definir una matriz personalizada
        int x=0, y=0, opcion=0;
        boolean exito = true, exitoX = true, exitoY = true;
        while (exito) {
            while (exitoX) {

                System.out.print("Ingrese el numero de fila: ");
                x = sc.nextInt();
                if (x < 1 || x > unaMatriz.length) {
                    System.out.println("Ingreso una fila no permitida");
                } else {
                    exitoX = false;
                }
            }
            while (exitoY) {
                System.out.print("Ingrese el numero de columna: ");
                y = sc.nextInt();
                if (y < 1 || y > unaMatriz.length) {
                    System.out.println("Ingreso una fila no permitida");
                } else {
                    exitoY = false;
                }
            }
            unaMatriz[(x-1)][(y-1)].setEstadoActual(true);
            System.out.println("Celula viva en fila "+x+" columna "+y);
            System.out.print("¿Desea cambiar otra celula a viva? (1: si o 2: no) ");
            opcion=sc.nextInt();
            if(opcion==2){
                exito=false;
            }
            
        }

    }

    private static void glinder(Celula[][] unaMatriz) {
        //Metodo para setear el patron glinder
        unaMatriz[14][10].setEstadoActual(true);
        unaMatriz[14][11].setEstadoActual(true);
        unaMatriz[14][12].setEstadoActual(true);
        unaMatriz[13][12].setEstadoActual(true);
        unaMatriz[12][11].setEstadoActual(true);
    }

    private static void smallExploder(Celula[][] unaMatriz) {
        //Metodo para setear el patron Small Exploder
        unaMatriz[13][12].setEstadoActual(true);
        unaMatriz[12][12].setEstadoActual(true);
        unaMatriz[12][11].setEstadoActual(true);
        unaMatriz[11][11].setEstadoActual(true);
        unaMatriz[12][10].setEstadoActual(true);
        unaMatriz[13][10].setEstadoActual(true);
        unaMatriz[14][11].setEstadoActual(true);
    }

    private static void exploder(Celula[][] unaMatriz) {
        //Metodo para setear el patron Exploder
        //Linea izquierda
        unaMatriz[10][9].setEstadoActual(true);
        unaMatriz[11][9].setEstadoActual(true);
        unaMatriz[12][9].setEstadoActual(true);
        unaMatriz[13][9].setEstadoActual(true);
        unaMatriz[14][9].setEstadoActual(true);
        //celulas del medio
        unaMatriz[10][11].setEstadoActual(true);
        unaMatriz[14][11].setEstadoActual(true);
        //Linea derecha
        unaMatriz[10][13].setEstadoActual(true);
        unaMatriz[11][13].setEstadoActual(true);
        unaMatriz[12][13].setEstadoActual(true);
        unaMatriz[13][13].setEstadoActual(true);
        unaMatriz[14][13].setEstadoActual(true);
    }

    private static void tenCellRow(Celula[][] unaMatriz) {
        //Metodo para setear el patron 10 Cell Row
        unaMatriz[11][7].setEstadoActual(true);
        unaMatriz[11][8].setEstadoActual(true);
        unaMatriz[11][9].setEstadoActual(true);
        unaMatriz[11][10].setEstadoActual(true);
        unaMatriz[11][11].setEstadoActual(true);
        unaMatriz[11][12].setEstadoActual(true);
        unaMatriz[11][13].setEstadoActual(true);
        unaMatriz[11][14].setEstadoActual(true);
        unaMatriz[11][15].setEstadoActual(true);
        unaMatriz[11][16].setEstadoActual(true);
    }

    private static void lightweightSpaceship(Celula[][] unaMatriz) {
        //Metodo para setear el patron lightweight Spaceship
        unaMatriz[12][9].setEstadoActual(true);
        unaMatriz[14][9].setEstadoActual(true);
        unaMatriz[11][10].setEstadoActual(true);
        unaMatriz[11][11].setEstadoActual(true);
        unaMatriz[11][12].setEstadoActual(true);
        unaMatriz[11][13].setEstadoActual(true);
        unaMatriz[12][13].setEstadoActual(true);
        unaMatriz[13][13].setEstadoActual(true);
        unaMatriz[14][12].setEstadoActual(true);
    }

    private static void tumbler(Celula[][] unaMatriz) {
        //Metodo para setear el patron Tumbler
        //Izquierda
        unaMatriz[12][9].setEstadoActual(true);
        unaMatriz[13][9].setEstadoActual(true);
        unaMatriz[14][9].setEstadoActual(true);
        //
        unaMatriz[9][10].setEstadoActual(true);
        unaMatriz[10][10].setEstadoActual(true);
        unaMatriz[14][10].setEstadoActual(true);
        //
        unaMatriz[9][11].setEstadoActual(true);
        unaMatriz[10][11].setEstadoActual(true);
        unaMatriz[11][11].setEstadoActual(true);
        unaMatriz[12][11].setEstadoActual(true);
        unaMatriz[13][11].setEstadoActual(true);
        //Derecha
        unaMatriz[9][13].setEstadoActual(true);
        unaMatriz[10][13].setEstadoActual(true);
        unaMatriz[11][13].setEstadoActual(true);
        unaMatriz[12][13].setEstadoActual(true);
        unaMatriz[13][13].setEstadoActual(true);
        //
        unaMatriz[9][14].setEstadoActual(true);
        unaMatriz[10][14].setEstadoActual(true);
        unaMatriz[14][14].setEstadoActual(true);
        //
        unaMatriz[12][15].setEstadoActual(true);
        unaMatriz[13][15].setEstadoActual(true);
        unaMatriz[14][15].setEstadoActual(true);
    }
}
