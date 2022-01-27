/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.maquinavendingrubenimad;


import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MSI
 */
public class LecturaFicheros {
    
     public static ArrayList<Bandeja> leerFicheroCsvArticulos(String idFichero) {
         ArrayList<Bandeja> listaArticulos = new ArrayList<>();
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero CSV: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            //Omitimos la primera linea
//                datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un Stringç
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                Bandeja tmp = new Bandeja();

                for (String string : tokens) {
                    tmp.setTipoDeProducto(tokens[0]);
                    tmp.setCodigoProducto(Integer.parseInt(tokens[1]));
                    tmp.setPrecioProducto(Integer.parseInt(tokens[2]));
                    tmp.setStockBandeja(Integer.parseInt(tokens[3]));
                }
                listaArticulos.add(tmp);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaArticulos;
    }
}
