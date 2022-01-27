/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.maquinavendingrubenimad;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public static boolean formaPagoEfectivoTarjeta() {
        boolean formaDePago = false;
        String[] botones = {"Efectivo", "Tarjeta", "salir"};
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("1111222233334444", YearMonth.of(2023, 3), 222);
        TarjetaDeCredito tarjetaUsuario = validacionTarjetaIntroducida();
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
                if (TarjetaDeCredito.CompararTarjetas(tarjetaUsuario, tarjeta)) {
                    JOptionPane.showMessageDialog(null, "Compra realizada con exito");
                    formaDePago = true;
                } else {
                    formaDePago = false;
                    JOptionPane.showMessageDialog(null, "Tarjeta no valida, Se cancela la operacion", "Error de compra",JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Operacion cancelada con exito");

        }
        return formaDePago;
    }

    public static TarjetaDeCredito validacionTarjetaIntroducida() {
        String codigo = null;
        double codigoComprobacion;
        String fechaCaducidad;
        String cvvString;
        int cvv = 0;
        boolean comprobarIntroduccionIncorrectaUsuario = false;
        boolean formatoFechaCaducidadCorrecto = false;
        //Bucle control de introduccion correcta de valores

        do {
            comprobarIntroduccionIncorrectaUsuario = false;
            try {
                comprobarIntroduccionIncorrectaUsuario = false;
                do {
                    codigo = JOptionPane.showInputDialog("Introduce un codigo de 16 numeros");
                    codigoComprobacion = Double.parseDouble(codigo);
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

        Pattern patron = Pattern.compile("[1-12]{1}\\/[22-50]{1}");
//        patron.matcher(fechaCaducidad);
        Matcher mat;
        do {
            comprobarIntroduccionIncorrectaUsuario = false;
            try {
                do {
                    fechaCaducidad = JOptionPane.showInputDialog("Introduce la fecha de caducidad");
                    mat = patron.matcher(fechaCaducidad);

                    comprobarIntroduccionIncorrectaUsuario = false;
                    //mat.matches()

                } while (mat.matches());
            } catch (NumberFormatException ex) {
                //Mensaje de error
                JOptionPane.showMessageDialog(null, "Formato incorrecto:\n"
                        + "Por favor ingrese un valor valido", "Error de formato",
                        JOptionPane.ERROR_MESSAGE);
                comprobarIntroduccionIncorrectaUsuario = true;
            }
        } while (comprobarIntroduccionIncorrectaUsuario);

        //   cvvString = JOptionPane.showInputDialog("Introduce el cvv");
        do {
            comprobarIntroduccionIncorrectaUsuario = false;
            try {
                do {
                    cvvString = JOptionPane.showInputDialog("Introduce el cvv");
                    cvv = Integer.parseInt(cvvString);
                    comprobarIntroduccionIncorrectaUsuario = false;
                } while (cvv == 3);
            } catch (NumberFormatException ex) {
                //Mensaje de error
                JOptionPane.showMessageDialog(null, "Formato incorrecto:\n"
                        + "Por favor ingrese un valor valido", "Error de formato",
                        JOptionPane.ERROR_MESSAGE);
                comprobarIntroduccionIncorrectaUsuario = true;
            }
        } while (comprobarIntroduccionIncorrectaUsuario);
        YearMonth prueba;
        prueba = YearMonth.now().plusYears(3);
        // cvv = Integer.parseInt(cvvString);
        TarjetaDeCredito introducida = new TarjetaDeCredito(codigo, prueba, cvv);
        return introducida;
    }

//    public static void leerProductos(Bandeja[] bandeja) {
//
//        JOptionPane.showMessageDialog(null, "El productos es " + bandeja[0].getTipoDeProducto() + " y su código es " + bandeja[0].getCodigoProducto() + " y cuesta " + bandeja[1].getPrecioProducto() + "€" + "\n"
//                + "El productos es " + bandeja[1].getTipoDeProducto() + " y su código es " + bandeja[1].getCodigoProducto() + " y cuesta " + bandeja[1].getPrecioProducto() + "€" + "\n"
//                + "El productos es " + bandeja[2].getTipoDeProducto() + " y su código es " + bandeja[2].getCodigoProducto() + " y cuesta " + bandeja[2].getPrecioProducto() + "€" + "\n"
//                + "El productos es " + bandeja[3].getTipoDeProducto() + " y su código es " + bandeja[3].getCodigoProducto() + " y cuesta " + bandeja[3].getPrecioProducto() + "€" + "\n"
//                + "El productos es " + bandeja[4].getTipoDeProducto() + " y su código es " + bandeja[4].getCodigoProducto() + " y cuesta " + bandeja[4].getPrecioProducto() + "€" + "\n"
//                + "El productos es " + bandeja[5].getTipoDeProducto() + " y su código es " + bandeja[5].getCodigoProducto() + " y cuesta " + bandeja[5].getPrecioProducto() + "€"
//        );
//
//    }
}
