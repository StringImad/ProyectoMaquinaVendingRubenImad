/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.maquinavendingrubenimad;

import static imad.maquinavendingrubenimad.TarjetaDeCredito.CompararTarjetasLista;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author diabl
 */
public class Utilidades {

    private static int contadorDineroTarjeta;

    public static int getContadorDineroTarjeta() {
        return contadorDineroTarjeta;
    }

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

    public static boolean formaPagoEfectivoTarjeta(String codigo, ArrayList lista, Dinero d5, Dinero d10, Dinero d20, Dinero d50, Dinero d100, Dinero d200, Dinero d500, Dinero d1000, Dinero d2000) {
        ArrayList<Bandeja> listaBandejas = lista;
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("1111222233334444", YearMonth.of(2023, 3), 222);
        TarjetaDeCredito tarjeta2 = new TarjetaDeCredito("1111222233334444", YearMonth.of(2021, 3), 222);
        TarjetaDeCredito tarjeta3 = new TarjetaDeCredito("1111222244443333", YearMonth.of(2023, 3), 222);
        ArrayList<TarjetaDeCredito> listaTarjetas = new ArrayList<>();
        listaTarjetas.add(tarjeta);
        listaTarjetas.add(tarjeta2);
        listaTarjetas.add(tarjeta3);

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
        int cont5 = 0,cont10 = 0,cont20 = 0,cont50 = 0,cont100 = 0,cont200 = 0,cont500 = 0,cont1000 = 0,cont2000 = 0;
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
                                cont5++;
                                break;
                            case 1:
                                dineroIntroducido += 10;
                                System.out.println("Diner introdudido: " + dineroIntroducido);
                                cont10++;
                                break;
                            case 2:
                                dineroIntroducido += 20;
                                cont20++;
                                break;
                            case 3:
                                dineroIntroducido += 50;
                                System.out.println("Diner introdudido: " + dineroIntroducido);
                                cont50++;
                                break;
                            case 4:
                                dineroIntroducido += 100;
                                cont100++;
                                break;
                            case 5:
                                dineroIntroducido += 200;
                                cont200++;
                                break;
                            case 6:
                                dineroIntroducido += 500;
                                cont500++;
                                break;
                            case 7:
                                dineroIntroducido += 1000;
                                cont1000++;
                                break;
                            case 8:
                                dineroIntroducido += 2000;
                                cont2000++;
                                break;
                            case 9:
                                JOptionPane.showMessageDialog(null, "Operacion cancelada con exito");
                                dineroSuficiente = false;
                                break;
                        }
                        if (dineroIntroducido < precioProducto) {
                            JOptionPane.showMessageDialog(null, "introduzca el siguiente importe, dinero actual:" + dineroIntroducido / 100 + "€");
                        }
                    } while (dineroIntroducido < precioProducto || !dineroSuficiente);

                    System.out.println("dinero introducido fase final: " + dineroIntroducido + " precioProducto: " + precioProducto);
                    System.out.println(darCambio(d5, d10, d20, d50, d100, d200, d500, d1000, (int) precioProducto, (int) dineroIntroducido));
                    if (dineroIntroducido >= precioProducto && !(darCambio(d5, d10, d20, d50, d100, d200, d500, d1000, (int) precioProducto, (int) dineroIntroducido).contains("No"))) {
                        dineroSuficiente = false;
                        formaDePago = true;
                        JOptionPane.showMessageDialog(null, darCambio(d5, d10, d20, d50, d100, d200, d500, d1000, (int) precioProducto, (int) dineroIntroducido));
                        d5.setCantidad(d5.getCantidad()+cont5);
                        d10.setCantidad(d10.getCantidad()+cont10);
                        d20.setCantidad(d20.getCantidad()+cont20);
                        d50.setCantidad(d50.getCantidad()+cont50);
                        d100.setCantidad(d100.getCantidad()+cont100);
                        d200.setCantidad(d200.getCantidad()+cont200);
                        d500.setCantidad(d500.getCantidad()+cont500);
                        d1000.setCantidad(d1000.getCantidad()+cont1000);
                        d2000.setCantidad(d2000.getCantidad()+cont2000);
                        //      System.out.println(darCambio(d5, d10, d20, d50, d100, d200, d500, d1000, (int) precioProducto, (int) dineroIntroducido));
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay dinero suficiente en la maquina\nIntroduce la cantidad exacta");
                        dineroIntroducido = 0;
                        dineroSuficiente = true;
                    }
                } while (dineroSuficiente);
//                for (Bandeja listaBandeja : listaBandejas) {
//
//                    if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
//                        listaBandeja.setStockBandeja(listaBandeja.getStockBandeja() - 1);
//
//                    }
//                }
                System.out.println("Diner introdudido: " + dineroIntroducido);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Ha seleccionado el pago con tarjeta\nIntroduce la tarjeta");
                TarjetaDeCredito tarjetaUsuario = validacionTarjetaIntroducida();
                System.out.println("----Validaciones------");
                System.out.println(TarjetaDeCredito.CompararTarjetas(tarjetaUsuario, tarjeta));

                System.out.println(CompararTarjetasLista(tarjetaUsuario, listaTarjetas));
                if (TarjetaDeCredito.CompararTarjetas(tarjetaUsuario, tarjeta)) {
                    JOptionPane.showMessageDialog(null, "Compra realizada con exito");
                    contadorDineroTarjeta += precioProducto;
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

    //método para cambiar la cantidad del dinero de la máquina
    public static void cambiarCantidad(Dinero d5, Dinero d10, Dinero d20, Dinero d50, Dinero d100, Dinero d200, Dinero d500, Dinero d1000) {

        String monedaString = JOptionPane.showInputDialog(null, "¿Que monedas quiere recargar (en centimos)? \n "
                + "Las cantidades son: \n 5 centimos \n 10 centimos \n 20 centimos \n 50 centimos \n 100 centimos (1€) \n 200 centimos (2€) \n 500 centimos (5€)\n 1000 centimos (10€)");
        int moneda = Integer.parseInt(monedaString);
        int cantidad = 0;
        switch (moneda) {

            case 5:
                cantidad = joptionTryCatch();
                d5.setCantidad(cantidad);
                break;
            case 10:
                cantidad = joptionTryCatch();
                d10.setCantidad(cantidad);
                break;
            case 20:
                cantidad = joptionTryCatch();
                d20.setCantidad(cantidad);
                break;
            case 50:
                cantidad = joptionTryCatch();
                d50.setCantidad(cantidad);
                break;
            case 100:
                cantidad = joptionTryCatch();
                d100.setCantidad(cantidad);
                break;
            case 200:
                cantidad = joptionTryCatch();
                d200.setCantidad(cantidad);
                break;
            case 500:
                cantidad = joptionTryCatch();
                d500.setCantidad(cantidad);
                break;
            case 1000:
                cantidad = joptionTryCatch();
                d1000.setCantidad(cantidad);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Cantidad no valida");
        }
    }

    //método en el cual nos da el cambio de las monedas si tiene las suficientes para hacerlo y si no dice eso
    public static String darCambio(Dinero d5, Dinero d10, Dinero d20, Dinero d50, Dinero d100, Dinero d200, Dinero d500, Dinero d1000, int precio, int dineroPagado) {
        String StringFinal = "";
        String dialogo = "";
        int cont5 = 0, cont10 = 0, cont20 = 0, cont50 = 0, cont100 = 0, cont200 = 0, cont500 = 0, cont1000 = 0;
        dineroPagado -= precio;
        if (precio <= dineroPagado) {

            while (d1000.getCantidad() != 0 && dineroPagado >= d1000.getValor()) {

                dineroPagado -= d1000.getValor();
                d1000.setCantidad(d1000.getCantidad() - 1);
                cont1000++;

            }
            while (d500.getCantidad() != 0 && dineroPagado >= d500.getValor()) {
                if (dineroPagado >= d500.getValor() || d500.getCantidad() != 0) {
                    dineroPagado -= d500.getValor();
                    d500.setCantidad(d500.getCantidad() - 1);
                    cont500++;
                }
            }

            while (d200.getCantidad() != 0 && dineroPagado >= d200.getValor()) {

                dineroPagado -= d200.getValor();
                d200.setCantidad(d200.getCantidad() - 1);
                cont200++;

            }

            while (d100.getCantidad() != 0 && dineroPagado >= d100.getValor()) {

                dineroPagado -= d100.getValor();
                d100.setCantidad(d100.getCantidad() - 1);
                cont100++;

            }
            while (d50.getCantidad() != 0 && dineroPagado >= d50.getValor()) {

                dineroPagado -= d50.getValor();
                d50.setCantidad(d50.getCantidad() - 1);
                cont50++;

            }
            while (d20.getCantidad() != 0 && dineroPagado >= d20.getValor()) {

                dineroPagado -= d20.getValor();
                d20.setCantidad(d20.getCantidad() - 1);
                cont20++;

            }
            while (d10.getCantidad() != 0 && dineroPagado >= d10.getValor()) {

                dineroPagado -= d10.getValor();
                d10.setCantidad(d10.getCantidad() - 1);
                cont10++;

            }
            while (d5.getCantidad() != 0 && dineroPagado >= d5.getValor()) {

                dineroPagado -= d5.getValor();
                d5.setCantidad(d5.getCantidad() - 1);
                cont5++;

            }

        }
        if (dineroPagado != 0) {
            return StringFinal = "No hay monedas suficientes, introduzca la cifra exacta";
        } else {
            return StringFinal = "Dinero devuelto = 10€:" + cont1000 + "| 5€:" + cont500 + "| 2€:" + cont200 + "| 1€:" + cont100 + "| 0,50€:" + cont50 + "| 0,20€:" + cont20 + "| 0,10€:" + cont10 + "| 0,05€:" + cont5;
        }

    }

    //metodo para recaudar el dinero 
    public static void recaudarDinero(Dinero d5, Dinero d10, Dinero d20, Dinero d50, Dinero d100, Dinero d200, Dinero d500, Dinero d1000, Dinero d2000) {
        double cantidad = 0;
        cantidad += d5.getValor() * d5.getCantidad();
        d5.setCantidad(0);
        cantidad += d10.getValor() * d10.getCantidad();
        d10.setCantidad(0);
        cantidad += d20.getValor() * d20.getCantidad();
        d20.setCantidad(0);
        cantidad += d50.getValor() * d50.getCantidad();
        d50.setCantidad(0);
        cantidad += d100.getValor() * d100.getCantidad();
        d100.setCantidad(0);
        cantidad += d200.getValor() * d200.getCantidad();
        d200.setCantidad(0);
        cantidad += d500.getValor() * d500.getCantidad();
        d500.setCantidad(0);
        cantidad += d1000.getValor() * d1000.getCantidad();
        d1000.setCantidad(0);
        cantidad += d2000.getValor() * d2000.getCantidad();
        d2000.setCantidad(0);

        JOptionPane.showMessageDialog(null, "Has recaudado:" + (cantidad / 100) + "€");
    }

    public static String consultarEfectivo(Dinero d5, Dinero d10, Dinero d20, Dinero d50, Dinero d100, Dinero d200, Dinero d500, Dinero d1000, Dinero d2000) {
        return "El dinero de la máquina es: \n 5cts: " + d5.getCantidad() + " monedas\n 10cts: " + d10.getCantidad() + " monedas\n 20cts: "
                + d20.getCantidad() + " monedas\n 50cts: " + d50.getCantidad() + " monedas\n 1€: " + d100.getCantidad() + " monedas \n 2€: "
                + d200.getCantidad() + " monedas\n 5€: " + d500.getCantidad() + " billetes\n 10€: " + d1000.getCantidad() + " billetes\n 20€: " + d2000.getCantidad() + " billetes";
    }

    //try catch para las excepciones 
    public static int joptionTryCatch() {
        boolean seguir = true;
        String stringCantidad;
        int cantidad = 0;
        do {
            try {
                stringCantidad = JOptionPane.showInputDialog(null, "¿Que cantidad vas a añadir?");
                cantidad = Integer.parseInt(stringCantidad);
                seguir = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El valor ingresado no es un número");

            }

        } while (seguir);
        return cantidad;
    }
}
