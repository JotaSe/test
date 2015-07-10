/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemontech;

/**
 *
 * @author JotaSe
 */
public class KnightTour {

    private final int size;
    private int solution[][];
    private final int initialX, initialY;

    public KnightTour(int size, int initialX, int initialY) {
        this.size = size;
        this.initialX = initialX;
        this.initialY = initialY;
        solution = new int[size][size];
    }

    /**
     * Funcion para determinar si es un index valido
     *
     * @param x posicion x
     * @param y posicion Y
     * @return Es un index valido
     */
    private boolean isSafe(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size && solution[x][y] == -1) {
            return true;
        }
        return false;
    }

    /**
     * Metodo recursivo para solucionar los posibles movimientos del caballo
     *
     * @param x posicion en X
     * @param y posicion en Y
     * @param movei numero del movimiento
     * @param xMove movimientos de X
     * @param yMove movimientos de Y
     * @return Recorrido terminado? . . . Recursividad
     */
    private boolean solve(int x, int y, int movei, int xMove[], int yMove[]) {
        int k, next_x, next_y;
       // System.out.println(movei);
        if (movei == size * size) {//Si ya ha tocado todos los espacios, entonces termina
            return true;
        }

        for (k = 0; k < size; k++) {//Se recorren los N*N pasos
            next_x = x + xMove[k];// Se agrega el siguiente espacio en X
            next_y = y + yMove[k];// Se agrega el siguiente espacio en Y
            if (isSafe(next_x, next_y)) { // Si el nuevo paso es un index valido entonces prosigue
                solution[next_x][next_y] = movei; //Se agrega el nuevo paso a la matriz de solucoines
                if (solve(next_x, next_y, movei + 1, xMove, yMove)) {//Si con los nuevos pasos se determina que se ha visitado todos los espacios, entonces se rompe la recursividad
                    return true;//solucion encontrada
                } else {
                    solution[next_x][next_y] = -1;
                }
            }
        }
        return false;
    }

    private boolean safeInitialPoint() {
        if (initialX < 0 || initialX > size || initialY < 0 || initialY > size) {
            return false;
        } else {
            return true;
        }
    }

    public boolean solveKnightTour() {
        if (safeInitialPoint()) {// Se verifica que el punto de inicio sea correcto ( que se encuentre dentro de los rangos del tablero)
            for (int x = 0; x < size; x++) {//Se determinan todos los espacios como no pisados con -1
                for (int y = 0; y < size; y++) {
                    solution[x][y] = -1;
                }
            }
            //test 1, 2, 1, 2, -2, -1, -1, -2 
            //  2, 2, 1, 1, -2, -2, -1, -1 
            //2, 1, -1, -2, -2, -1, 1, 2
            int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; //patron de movimientos en X
            //test  2, 1, -2, -1, 1, 2, -2, -1 
            //  1, -1, 2, -2, 1, -1, 2, -2 
            // 1, 2, 2, 1, -1, -2, -2, -1
            int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; //patron de movimientos en Y

            solution[initialX][initialY] = 0;
            if (!solve(initialX, initialY, 1, xMove, yMove)) {
                System.out.println("No hay solucion para este tamano");
                return false;
            } else {
                print();
            }
            return true;
        }else{
            System.out.println("Punto de inicia erroneo");
            return false;
        }

    }

    private void print() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                System.out.print("  " + solution[x][y]);
            }
            System.out.println();
        }
    }


}
