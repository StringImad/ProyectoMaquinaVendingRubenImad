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

        codigo = JOptionPane.showInputDialog("El codigo del administrador es: " + codigoGenerado + "\n" + listaBandejas + "\nIntroduce un codigo");
        if (codigo.contentEquals(codigoGenerado)) {
            String[] botones = {"Consultar y cambiar código", "Consultar y cambiar el producto",
                "Consultar y cambiar el stock","Consultar el efectivo",
                "Recargar efectivo","Consultar dinero recaudado", "salir"};
            int ventana = JOptionPane.showOptionDialog(null,
                    "Elige la opcion que desea:",
                    "Bienvenido al menu de administracion",
                    JOptionPane.INFORMATION_MESSAGE,
                    JOptionPane.QUESTION_MESSAGE, null,
                    botones, botones[0]);
            switch (ventana) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Ha seleccionado el pago en efectivo\nIntroduce el importe");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Ha seleccionado el pago con tarjeta\nIntroduce la tarjeta");

                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Operacion cancelada con exito");

            }

        } else {
            switch (Integer.parseInt(codigo)) {
                case 1:
                    for (Bandeja listaBandeja : listaBandejas) {
                        if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                            JOptionPane.showMessageDialog(null, "El precio es " + listaBandeja.getPrecioProducto() + "€.");

                        }

                    }
                    if (Utilidades.formaPagoEfectivoTarjeta()) {
                        for (Bandeja listaBandeja : listaBandejas) {
                            if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                                JOptionPane.showMessageDialog(null, "El precio es " + listaBandeja.getPrecioProducto() + "€.");
                                listaBandeja.setStockBandeja(listaBandeja.getStockBandeja() - 1);
                            }

                        }
                    }
                    break;
                case 2:
                    for (Bandeja listaBandeja : listaBandejas) {
                        if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                            JOptionPane.showMessageDialog(null, "El precio es " + listaBandeja.getPrecioProducto() + "€.");

                        }

                    }
                    if (Utilidades.formaPagoEfectivoTarjeta()) {
                        for (Bandeja listaBandeja : listaBandejas) {
                            if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                                JOptionPane.showMessageDialog(null, "El precio es " + listaBandeja.getPrecioProducto() + "€.");
                                listaBandeja.setStockBandeja(listaBandeja.getStockBandeja() - 1);
                            }

                        }
                    }
                    break;

                case 3:
                    for (Bandeja listaBandeja : listaBandejas) {
                        if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                            JOptionPane.showMessageDialog(null, "El precio es " + listaBandeja.getPrecioProducto() + "€.");

                        }

                    }
                    if (Utilidades.formaPagoEfectivoTarjeta()) {
                        for (Bandeja listaBandeja : listaBandejas) {
                            if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                                JOptionPane.showMessageDialog(null, "El precio es " + listaBandeja.getPrecioProducto() + "€.");
                                listaBandeja.setStockBandeja(listaBandeja.getStockBandeja() - 1);
                            }

                        }
                    }
                    break;

                case 4:
                    for (Bandeja listaBandeja : listaBandejas) {
                        if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                            JOptionPane.showMessageDialog(null, "El precio es " + listaBandeja.getPrecioProducto() + "€.");

                        }

                    }
                    if (Utilidades.formaPagoEfectivoTarjeta()) {
                        for (Bandeja listaBandeja : listaBandejas) {
                            if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                                JOptionPane.showMessageDialog(null, "El precio es " + listaBandeja.getPrecioProducto() + "€.");
                                listaBandeja.setStockBandeja(listaBandeja.getStockBandeja() - 1);
                            }

                        }
                    }
                    Utilidades.formaPagoEfectivoTarjeta();
                    break;

                case 5:
                    for (Bandeja listaBandeja : listaBandejas) {
                        if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                            JOptionPane.showMessageDialog(null, "El precio es " + listaBandeja.getPrecioProducto() + "€.");

                        }

                    }
                    if (Utilidades.formaPagoEfectivoTarjeta()) {
                        for (Bandeja listaBandeja : listaBandejas) {
                            if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                                JOptionPane.showMessageDialog(null, "El precio es " + listaBandeja.getPrecioProducto() + "€.");
                                listaBandeja.setStockBandeja(listaBandeja.getStockBandeja() - 1);
                            }

                        }
                    }
                    break;

                case 6:
                    for (Bandeja listaBandeja : listaBandejas) {
                        if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                            JOptionPane.showMessageDialog(null, "El precio es " + listaBandeja.getPrecioProducto() + "€.");

                        }

                    }
                    if (Utilidades.formaPagoEfectivoTarjeta()) {
                        for (Bandeja listaBandeja : listaBandejas) {
                            if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                                JOptionPane.showMessageDialog(null, "El precio es " + listaBandeja.getPrecioProducto() + "€.");
                                listaBandeja.setStockBandeja(listaBandeja.getStockBandeja() - 1);
                            }

                        }
                    }
                    break;
            }
        }
    }
}
