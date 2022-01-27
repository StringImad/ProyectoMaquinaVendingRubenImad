/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.maquinavendingrubenimad;

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
        String codigo = "";
        String codigoGenerado = Utilidades.getPassword();
        String efectivo;
        String codigoProductoElegidoString;
        int codigoProductoElegidoInt;
                ArrayList<Bandeja> listaBandejas = LecturaFicheros.leerFicheroCsvArticulos("articulos.csv");

//        Bandeja[] bandejas = new Bandeja[6];
//        bandejas[0] = new Bandeja("Agua", 1, 100, 15);
//        bandejas[1] = new Bandeja("Patatas Fritas", 2, 150, 15);
//        bandejas[2] = new Bandeja("Coca Cola", 3, 200, 15);
//        bandejas[3] = new Bandeja("Nestea", 4, 200, 15);
//        bandejas[4] = new Bandeja("Kinder Bueno", 5, 250, 15);
//        bandejas[5] = new Bandeja("Bocadillo", 6, 500, 15);
//        
//        TarjetaDeCredito []tarjetas = new TarjetaDeCredito[3];
//        tarjetas[0] = new TarjetaDeCredito("",YearMonth.of(2023, 3),2);
//        tarjetas[1] = new TarjetaDeCredito("",YearMonth.of(2021, 6),2);
//        tarjetas[2] = new TarjetaDeCredito("",YearMonth.of(2022, 1),2);
        
        
       
        codigo = JOptionPane.showInputDialog("El codigo del administrador es: " + codigoGenerado + "\n" + listaBandejas + "\nIntroduce un codigo");
        if (codigo.contentEquals(codigoGenerado)) {
            JOptionPane.showMessageDialog(null, "Bienvenido al menu de administracion.");
            
        } else {
           // Utilidades.leerProductos(bandejas);
            codigoProductoElegidoString = JOptionPane.showInputDialog(null, "¿Que producto desea?");
            codigoProductoElegidoInt = Integer.parseInt(codigoProductoElegidoString);
            switch (codigoProductoElegidoInt) {
                case 1:
//                    JOptionPane.showMessageDialog(null, "El precio es " + bandejas[0].getCodigoProducto() + "€.");
                    
                    
                        Utilidades.formaPagoEfectivoTarjeta();
                  // tarjetas[0].equals(Utilidades.formaPagoEfectivoTarjeta());
                    break;
                case 2:
//                    JOptionPane.showMessageDialog(null, "El precio es " + bandejas[1].getCodigoProducto() + "€.");
                    break;

                case 3:
//                    JOptionPane.showMessageDialog(null, "El precio es " + bandejas[2].getCodigoProducto() + "€");
                    Utilidades.formaPagoEfectivoTarjeta();
                    break;

                case 4:
//                    JOptionPane.showMessageDialog(null, "El precio es " + bandejas[3].getCodigoProducto() + "€");
                    Utilidades.formaPagoEfectivoTarjeta();
                    break;

                case 5:
//                    JOptionPane.showMessageDialog(null, "El precio es " + bandejas[4].getCodigoProducto() + "€");
                    Utilidades.formaPagoEfectivoTarjeta();
                    break;

                case 6:
//                    JOptionPane.showMessageDialog(null, "El precio " + bandejas[5].getCodigoProducto() + "€");
                    Utilidades.formaPagoEfectivoTarjeta();
                    break;
            }
        }
    }
}
