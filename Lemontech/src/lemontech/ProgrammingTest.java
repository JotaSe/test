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
public class ProgrammingTest {

    /**
     * Prueba 1: Escriba una función/método que determine la cantidad de 0’s a
     * la derecha de n! (factorial)
     *
     * @param number numero factorial
     * @return cantidad de zeros
     */
    public int findZeros(int number) {
        int count = 0; // Contador de 0

        if (number < 0) {
            return -1; //No existen factoriales negativos
        } else if (number == 5) {
            return 1; //Existe un patron en los factoriales que, cada 5 aparece un 0, por lo tanto el primer 0 aparece en 5
        } else if (number > 5) {
            // comenzamos a iterar desde el 5 para ir tomando cada 5 puestos los numeros de 0 que se vayan acumulando
            for (int j = 5; number / j >= 1; j *= 5) {
                count += number / j;
            }
        }

        return count;
    }

    final String[] UNIT = {"", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
    final String[] TENS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
        "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ",
        "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};

    final String[] HUNDREDS = {"", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
        "setecientos ", "ochocientos ", "novecientos "};

    /**
     * Prueba 2:Escriba una función/método que dado un número entero, entregue
     * su representación en palabras, Ej. 145 ­> “ciento cuarenta y cinco”
     *
     * @param number numero entero a convertir
     * @return numero en letras
     */
    public String numberToLetters(int number) {

        String textNumber;
        if (number == 0) {//si el valor es cero
            textNumber = "cero ";
        } else if (number > 999999) {//si es millon
            textNumber = getMillions(number + "");
        } else if (number > 999) {//si es miles
            textNumber = getThousands(number + "");
        } else if (number > 99) {//si es centena
            textNumber = getHundreds(number + "");
        } else if (Integer.parseInt(number + "") > 9) {//si es decena
            textNumber = getTens(number + "");
        } else {//sino unidades -> 9
            textNumber = getUnits(number + "");
        }

        return textNumber;
    }

    /**
     * Metodo para devolver las unidades del numero
     *
     * @param number numero entero a tratar
     * @return numeros enteros en texto
     */
    private String getUnits(String number) {
        //Eliminamos los 0 a las izquierda
        String num = number.substring(number.length() - 1);
        return UNIT[Integer.parseInt(num)];
    }

    /**
     * Metodo para devolver las decenas del numero
     *
     * @param number numero entero a tratar
     * @return numero de decenas en texto
     */
    private String getTens(String number) {
        int n = Integer.parseInt(number);
        if (n < 10) { //Para numeros del 1-9
            return getUnits(number);
        } else if (n > 19) {// para numeros de 20 en adelante
            String u = getUnits(number);
            if (u.equals("")) {
                return TENS[Integer.parseInt(number.substring(0, 1)) + 8];
            } else {

                return TENS[Integer.parseInt(number.substring(0, 1)) +8] + "y " + u;
            }
        } else {
            return TENS[n - 10];
        }
    }

    /**
     * Metodo para devolver las centenas del numero
     *
     * @param number numero a tratar
     * @return centenas en texto
     */
    private String getHundreds(String number) {
        if (Integer.parseInt(number) > 99) {
            if (Integer.parseInt(number) == 100) {
                return " cien ";
            } else {

                return HUNDREDS[Integer.parseInt(number.substring(0, 1))] + getTens(number.substring(1));
            }
        } else {
            return getTens(Integer.parseInt(number) + "");
        }
    }

    /**
     * Metodo para retornar los miles del numero
     *
     * @param number numero a tratar
     * @return miles del numero en texto
     */
    private String getThousands(String number) {

        String hundreds = number.substring(number.length() - 3);

        String thousands = number.substring(0, number.length() - 3);
        String n = "";

        if (Integer.parseInt(thousands) > 0) {
            n = getHundreds(thousands);
            return n + "mil " + getHundreds(hundreds);
        } else {
            return "" + getHundreds(hundreds);
        }
    }

    /**
     * Metodo para devolver los millones del numero
     *
     * @param number numero a tratar
     * @return millones del numero en texto
     */
    private String getMillions(String number) {
        String miles = number.substring(number.length() - 6);

        String millon = number.substring(0, number.length() - 6);
        String n = "";
        if (millon.length() > 1) {
            n = getHundreds(millon) + "millones ";
        } else {
            n = getUnits(millon) + "millon ";
        }
        return n + getThousands(miles);
    }
}

