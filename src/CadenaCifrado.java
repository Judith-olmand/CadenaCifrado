import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CadenaCifrado {
    public static void main(String[] args) {
        String clave = ""; //String para ir almacenando la clave
        String ultimaLineaLeida = ""; //String para almacenar la última línea

        try (BufferedReader reader = new BufferedReader(new FileReader("../CadenaCifrado.txt"))) {
            String linea;

            /**
             * Mientras la longitud de clave sea menor que 10
             * y no hayamos llegado al final del archivo...
             */
            while (clave.length() < 10 && (linea = reader.readLine()) != null) {
                /**
                 * Si la línea no está vacía
                 */
                if(!linea.isEmpty()){
                    /**
                     * almacena en char el último caracter de la línea
                     * y se contcatena a la clave.
                     * Almacenamos la línea en otro String
                     */
                    char ultimoChar = linea.charAt(linea.length() - 1);
                    clave += ultimoChar;
                    ultimaLineaLeida = linea;
                }
            }
            /**
             * Si la clave no tiene una longitud de 10
             * se usa la UltimaLineaLeida para extraer el último caracter
             * hasta llegar a 10
             */
            if (clave.length() < 10) {
                char ultimoChar = ultimaLineaLeida.charAt(ultimaLineaLeida.length() - 1);
                while (clave.length() < 10){
                    clave += ultimoChar;
                }
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }


        System.out.println(clave);
    }
}