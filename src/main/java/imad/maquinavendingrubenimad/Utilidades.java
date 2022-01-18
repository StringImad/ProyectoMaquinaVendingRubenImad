/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.maquinavendingrubenimad;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author diabl
 */
public class Utilidades {

    public static String getPassword() {

        String numeros = "0123456789";

        String mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String minus = "abcdefghijklmnopqrstuvwxyz";

        String esp = "#$%&()*+,-.:;<=>@";

        String todos = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#$%&()*+,-.:;<=>@";

        String pswd = "";

        for (int i = 0; i < 1; i++) {
            pswd += (numeros.charAt((int) (Math.random() * numeros.length())));
        }

        for (int i = 0; i < 1; i++) {
            pswd += (mayus.charAt((int) (Math.random() * mayus.length())));
        }
        for (int i = 0; i < 1; i++) {
            pswd += (minus.charAt((int) (Math.random() * minus.length())));
        }
        for (int i = 0; i < 1; i++) {
            pswd += (esp.charAt((int) (Math.random() * esp.length())));
        }

        for (int i = 0; i < 4; i++) {
            pswd += (todos.charAt((int) (Math.random() * todos.length())));
        }

        return pswd;
    }

    public static String formaPagoEfectivoTarjeta() {
        String formaDePago = "";
        String[] botones = {"Efectivo", "Tarjeta", "salir"};
        int ventana = JOptionPane.showOptionDialog(null,
                "Elige el modo de pago:",
                "Bienvenido al sistema de cobro",
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.QUESTION_MESSAGE, null,
                botones, botones[0]);
        switch (ventana) {
            case 0:
                JOptionPane.showMessageDialog(null, "Ha seleccionado el pago en efectivo\nIntroduce el importe");

                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Ha seleccionado el pago con tarjeta\nIntroduce la tarjeta");
                validacionTarjetaIntroducida();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Operacion cancelada con exito");

        }
        return formaDePago;
    }

    public static TarjetaDeCredito validacionTarjetaIntroducida() {
        String codigo = null;
        int codigoComprobacion;
        String fechaCaducidad;
        String cvvString;
        int cvv = 0;
        boolean comprobarIntroduccionIncorrectaUsuario = false;
        //Bucle control de introduccion correcta de valores

        do {
            comprobarIntroduccionIncorrectaUsuario = false;
            try {
                do {
                    codigo = JOptionPane.showInputDialog("Introduce un codigo de 16 numeros");
                    codigoComprobacion = Integer.parseInt(codigo);
                    comprobarIntroduccionIncorrectaUsuario = false;
                } while (codigo.length() != 16);
            } catch (NumberFormatException ex) {
                //Mensaje de error
                JOptionPane.showMessageDialog(null, "Formato incorrecto:\n"
                        + "Por favor ingrese un valor valido", "Error de formato",
                        JOptionPane.ERROR_MESSAGE);
                comprobarIntroduccionIncorrectaUsuario = true;
            }
        } while (comprobarIntroduccionIncorrectaUsuario);
        //     codigo = JOptionPane.showInputDialog("Introduce un codigo de 16 numeros");

        fechaCaducidad = JOptionPane.showInputDialog("Introduce la fecha de caducidad");
        cvvString = JOptionPane.showInputDialog("Introduce el cvv");
        cvv = Integer.parseInt(cvvString);
        TarjetaDeCredito introducida = new TarjetaDeCredito(codigo, fechaCaducidad, cvv);
        return introducida;
    }

}
