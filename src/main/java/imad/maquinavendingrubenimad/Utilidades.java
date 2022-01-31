/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.maquinavendingrubenimad;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
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

    public static boolean formaPagoEfectivoTarjeta(String codigo, ArrayList lista) {
        ArrayList<Bandeja> listaBandejas = lista;
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("1111222233334444", YearMonth.of(2023, 3), 222);
        boolean formaDePago = false;
        double precioProducto = 0;
        for (Bandeja listaBandeja : listaBandejas) {

            if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                precioProducto = listaBandeja.getPrecioProducto();

            }
        }

        System.out.println("Precio producto: " + precioProducto);
        double dineroIntroducido = 0;
        boolean dineroSuficiente = true;
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
                do {
                    String[] botonesDinero = {"5cts", "10cts", "20cts", "50cts", "1€", "2€", "5€", "10€", "20€", "salir"};

                    int ventanaDinero = JOptionPane.showOptionDialog(null,
                            "Introduce el dinero:",
                            "Bienvenido al sistema de cobro",
                            JOptionPane.INFORMATION_MESSAGE,
                            JOptionPane.QUESTION_MESSAGE, null,
                            botonesDinero, botonesDinero[0]);

                    switch (ventanaDinero) {
                        case 0:
                            dineroIntroducido += 5;
                            break;
                        case 1:
                            dineroIntroducido += 10;
                            System.out.println("Diner introdudido: " + dineroIntroducido);

                            break;
                        case 2:
                            dineroIntroducido += 20;

                            break;
                        case 3:
                            dineroIntroducido += 50;
                            System.out.println("Diner introdudido: " + dineroIntroducido);

                            break;
                        case 4:
                            dineroIntroducido += 100;

                            break;
                        case 5:
                            dineroIntroducido += 200;

                            break;
                        case 6:
                            dineroIntroducido += 500;

                            break;
                        case 7:
                            dineroIntroducido += 1000;

                            break;
                        case 8:
                            dineroIntroducido += 2000;

                            break;
                        case 9:
                            JOptionPane.showMessageDialog(null, "Operacion cancelada con exito");
                            dineroSuficiente = false;
                            break;
                    }

                    if (dineroIntroducido >= precioProducto) {
                        dineroSuficiente = false;

                    }
                } while ((dineroSuficiente));
                for (Bandeja listaBandeja : listaBandejas) {

                    if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                        listaBandeja.setStockBandeja(listaBandeja.getStockBandeja() - 1);

                    }
                }
                System.out.println("Diner introdudido: " + dineroIntroducido);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Ha seleccionado el pago con tarjeta\nIntroduce la tarjeta");
                TarjetaDeCredito tarjetaUsuario = validacionTarjetaIntroducida();
                System.out.println("----Validaciones------");
                System.out.println(TarjetaDeCredito.CompararTarjetas(tarjetaUsuario, tarjeta));
                if (TarjetaDeCredito.CompararTarjetas(tarjetaUsuario, tarjeta)) {
                    JOptionPane.showMessageDialog(null, "Compra realizada con exito");
                    formaDePago = true;
                } else {
                    formaDePago = false;
                    JOptionPane.showMessageDialog(null, "Tarjeta no valida", "Error de compra", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Operacion cancelada con exito");

        }
        return formaDePago;
    }

    public static TarjetaDeCredito validacionTarjetaIntroducida() {
        String codigo;
        int cvv = 0;
        codigo = compruebaIntroduccion16Numeros();
        YearMonth fechaUsuario = compruebaIntroduccionFechaCaducidad();
        cvv = compruebaIntroduccionCvv();
        System.out.println(codigo + "-" + fechaUsuario + "-" + cvv);
        TarjetaDeCredito introducida = new TarjetaDeCredito(codigo, fechaUsuario, cvv);
        return introducida;
    }

    private static String compruebaIntroduccion16Numeros() {
        String codigo = null;
        double codigoComprobacion;
        boolean comprobarIntroduccionIncorrectaUsuario = false;
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

        return codigo;
    }

    private static YearMonth compruebaIntroduccionFechaCaducidad() {
        String fechaCaducidad;
        int mes = 0, anyo = 0;
        boolean comprobarIntroduccionIncorrectaUsuario = false;
        YearMonth fecha;
        do {
            comprobarIntroduccionIncorrectaUsuario = false;
            try {
                do {
                    do {
                        try {
                            comprobarIntroduccionIncorrectaUsuario = false;
                            fechaCaducidad = JOptionPane.showInputDialog("Introduce la fecha de caducidad ejemplo: 10/24");
                            String[] mesAnyo = fechaCaducidad.split("\\/");
                            mes = Integer.parseInt(mesAnyo[0]);
                            anyo = Integer.parseInt(20 + mesAnyo[1]);
                        } catch (ArrayIndexOutOfBoundsException AIOOFBE) {
                            //Mensaje de error
                            JOptionPane.showMessageDialog(null, "Formato incorrecto:\n"
                                    + "Por favor ingrese un valor valido", "Error de formato",
                                    JOptionPane.ERROR_MESSAGE);
                            comprobarIntroduccionIncorrectaUsuario = true;
                        }
                    } while (comprobarIntroduccionIncorrectaUsuario);
                    System.out.println(mes + "/" + anyo);
                    comprobarIntroduccionIncorrectaUsuario = false;
                } while (mes < 1 || mes > 12 || anyo < 2022 || anyo > 2050);
            } catch (NumberFormatException ex) {
                //Mensaje de error
                JOptionPane.showMessageDialog(null, "Formato incorrecto:\n"
                        + "Por favor ingrese un valor valido", "Error de formato",
                        JOptionPane.ERROR_MESSAGE);
                comprobarIntroduccionIncorrectaUsuario = true;
            }
        } while (comprobarIntroduccionIncorrectaUsuario);
        fecha = YearMonth.of(anyo, mes);
        return fecha;
    }

    private static int compruebaIntroduccionCvv() {
        String cvvString;
        int cvv = 0;
        boolean comprobarIntroduccionIncorrectaUsuario = false;
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
        return cvv;
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
