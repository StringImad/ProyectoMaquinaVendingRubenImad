/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.maquinavendingrubenimad;

import static imad.maquinavendingrubenimad.Utilidades.validacionTarjetaIntroducida;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class Programa {

    public static void main(String[] args) {
        //Declaracion de variables
        String codigo;
        String codigoGenerado = Utilidades.getPassword();
        ArrayList<Bandeja> listaBandejas = LecturaFicheros.leerFicheroCsvArticulos("articulos.csv");
        boolean repetir = true;
        boolean repetirMenuAdmin = true;

        do {
            codigo = JOptionPane.showInputDialog("El codigo del administrador es: " + codigoGenerado + "\n" + listaBandejas + "\nIntroduce un codigo");
            if (codigo.contentEquals(codigoGenerado)) {
                do {
                    String[] botones = {
                        "Consultar y cambiar código",
                        "Consultar y cambiar el producto",
                        "Consultar y cambiar el stock",
                        "Consultar el efectivo",
                        "Recargar efectivo", "Consultar dinero recaudado", "Apagar", "salir"};
                    int ventana = JOptionPane.showOptionDialog(null,
                            "Elige la opcion que desea:",
                            "Bienvenido al menu de administracion",
                            JOptionPane.INFORMATION_MESSAGE,
                            JOptionPane.QUESTION_MESSAGE, null,
                            botones, botones[0]);
                    switch (ventana) {
                        case 0:
                            String[] botonesCodigo = {
                                "Consultar código",
                                "cambiar codigo", "salir"};
                            int ventanaCodigo = JOptionPane.showOptionDialog(null,
                                    "Elige la opcion que desea:",
                                    "Consultar y cambiar el código de las bandejas",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    botonesCodigo, botonesCodigo[0]);
                            switch (ventanaCodigo) {
                                case 0:
                                    JOptionPane.showMessageDialog(null, listaBandejas);

                                    break;
                                case 1:
                                    String codigoNuevo = JOptionPane.showInputDialog(listaBandejas + "\nIntroduce el codigo del producto que desea modificar");

                                    for (Bandeja listaBandeja : listaBandejas) {
                                        if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigoNuevo)) {
                                            codigoNuevo = JOptionPane.showInputDialog("El producto es " + listaBandeja.getTipoDeProducto() + " introduce el codigo nuevo");
                                            listaBandeja.setCodigoProducto(Integer.parseInt(codigoNuevo));
                                        }

                                    }
                                case 2:
                                    JOptionPane.showMessageDialog(null, "volviendo al menu");

                            }
                            break;
                        case 1:
                            int ventanaProducto = JOptionPane.showOptionDialog(null,
                                    "Elige la opcion que desea:",
                                    "Bienvenido al menu de administracion",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    botones, botones[0]);
                            break;
                        case 2:
                            int ventanaStock = JOptionPane.showOptionDialog(null,
                                    "Elige la opcion que desea:",
                                    "Bienvenido al menu de administracion",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    botones, botones[0]);
                            break;
                        case 3:
                            int ventanaEfectivo = JOptionPane.showOptionDialog(null,
                                    "Elige la opcion que desea:",
                                    "Bienvenido al menu de administracion",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    botones, botones[0]);
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            repetir = false;
                            JOptionPane.showMessageDialog(null, "Apagando la maquina");
                            break;
                        case 8:
                            repetirMenuAdmin = false;
                            break;
                    }
                } while (repetirMenuAdmin);
            } else {
                switch (Integer.parseInt(codigo)) {
                    case 1:
                        for (Bandeja listaBandeja : listaBandejas) {
                            if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                                JOptionPane.showMessageDialog(null, "El precio es " + (listaBandeja.getPrecioProducto())/100 + "€.");
                                if (Utilidades.formaPagoEfectivoTarjeta((codigo),listaBandejas)) {

                                    listaBandeja.setStockBandeja(listaBandeja.getStockBandeja() - 1);

                                }
                            }

                        }

                        break;
                    case 2:
                
                        break;

                    case 3:
      
                        break;

                    case 4:
              
                        break;

                    case 5:
                  
                        break;

                    case 6:
                      
                        break;
                }
            }
        } while (repetir);
    }
}
