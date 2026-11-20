package kaprekar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author temis
 */
public class Kaprekar {

    /* Pongo un número de cuatro cifras. Lo ordeno de mayor a menor y de menor a mayor. Resto 
las cifras del menor al mayor y vuelvo a ordenarlo de esa manera. Repito eso hasta que me salga el mismo número dos veces seguidas.    */
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[4];
        int destrozo,original, a, b, i, j, aux, nuevoNumero;
        System.out.println("Dame un número de cuatro cifras.");
        nuevoNumero = Integer.parseInt(teclado.readLine());
        do {
            original=nuevoNumero;// Num es el número que no quiero que se destroze- Mi punto de partida va a ser la anterior resta.
            destrozo=nuevoNumero; // 
            for (i = 0; i < 4; i++) {
                array[i] = destrozo % 10;
                destrozo /= 10;
            }
            // Ordeno el array de mayor a menor
            for (i = 0; i < 3; i++) {
                for (j = 2; j >= i; j--) {
                    if (array[j] < array[j + 1]) {
                        aux = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = aux;
                    }
                }
            }
            a = 0;
            b = 0;
            for (i = 0; i < 4; i++) {
                a = a * 10 + array[i];
                b = b * 10 + array[3 - i];
            }
            nuevoNumero = a - b;
        } while (nuevoNumero!=original);
        System.out.println(nuevoNumero);
    }

}
