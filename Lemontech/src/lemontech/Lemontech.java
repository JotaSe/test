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
public class Lemontech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProgrammingTest test = new ProgrammingTest();
        int number = 3563;
        System.out.println("Prueba 1: Escriba una función/método que determine la cantidad de 0’s a la\n"
                + "derecha de n! (factorial)  \nCantidad de 0 para " + number + " =" + test.findZeros(number));

        System.out.println("Prueba 2: Escriba una función/método que dado un número entero, entregue su\n"
                + "representación en palabras, Ej. 145 ­> “ciento cuarenta y cinco” \n"
                + "Numero en letras de " + number + " = " + test.numberToLetters(number));
        
        KnightTour tour = new KnightTour(8, 0, 0);
        System.out.println("tour "+tour.solveKnightTour());
    }

}
