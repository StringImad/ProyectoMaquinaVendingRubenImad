/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.maquinavendingrubenimad;

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
//        boolean repetir = true;
//        do {
//            repetir = true;
//            try {
                codigo = JOptionPane.showInputDialog("El codigo del administrador es: " + codigoGenerado + "\nIntroduce un codigo");
//           repetir = true;
//            } catch (NumberFormatException ex) {
//                //Mensaje de error
//                JOptionPane.showMessageDialog(null, "Formato incorrecto:\n"
//                        + "Por favor ingrese un valor valido", "Error de formato",
//                        JOptionPane.ERROR_MESSAGE);
////            repetir = false;
//            }
//        } while (repetir);
        if (codigo.contentEquals(codigoGenerado)) {
            JOptionPane.showMessageDialog(null, "Bienvenido al menu de administracion.");

        } else {
            switch (Integer.parseInt(codigo)) {
                case 1:
                    JOptionPane.showMessageDialog(null, "El precio es 1€.");
                    Utilidades.formaPagoEfectivoTarjeta();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "El precio es 1€.");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "El precio es 1€.");
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "El precio es 1€.");
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "El precio es 1€.");
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "El precio es 1€.");
                    break;
            }
        }
    }
}
