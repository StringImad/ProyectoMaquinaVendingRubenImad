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
        String codigo = "";
        //Guardamos en este string el codigo aleatorio generado para se le codigo de administrador
        String codigoGenerado = Utilidades.getPassword();
        //Se imprime el codigo para que sea mas facil de introdcuir
        System.out.println(codigoGenerado);
        //Creamos un arrayList de bandejas apartir de un fichero csv
        ArrayList<Bandeja> listaBandejas = LecturaFicheros.leerFicheroCsvArticulos("articulos.csv");
        boolean repetir = true;
        boolean repetirMenuAdmin = true;
        MaquinaVending m1 = new MaquinaVending();
        boolean comprobarIntroduccionIncorrectaUsuario = true;
        int codigoSwitch = 0;
        Dinero d5 = new Dinero(5, 10);
        Dinero d10 = new Dinero(10, 10);
        Dinero d20 = new Dinero(20, 10);
        Dinero d50 = new Dinero(50, 10);
        Dinero d100 = new Dinero(100, 7);
        Dinero d200 = new Dinero(200, 5);
        Dinero d500 = new Dinero(500, 3);
        Dinero d1000 = new Dinero(1000, 2);
        Dinero d2000 = new Dinero(2000, 0);
        do {

            do {
                codigo = JOptionPane.showInputDialog("El codigo del administrador es: " + codigoGenerado + "\n" + listaBandejas + "\nIntroduce un codigo");

                try {
                    if (codigo.equals(codigoGenerado)) {
                        break;
                    }
                    codigoSwitch = Integer.parseInt(codigo);
                    comprobarIntroduccionIncorrectaUsuario = false;
                } catch (NumberFormatException NFE) {
                    //Mensaje de error
                    JOptionPane.showMessageDialog(null, "Formato incorrecto:\n"
                            + "Por favor ingrese un valor valido", "Error de formato",
                            JOptionPane.ERROR_MESSAGE);
                    comprobarIntroduccionIncorrectaUsuario = true;
                }
            } while (comprobarIntroduccionIncorrectaUsuario);
            System.out.println("-------Erroe 1");
            if (codigo.contentEquals(codigoGenerado)) {
                do {
                    repetirMenuAdmin = true;
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

                                case 3:

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
//                            int ventanaEfectivo = JOptionPane.showOptionDialog(null,
//                                    "Elige la opcion que desea:",
//                                    "Bienvenido al menu de administracion",
//                                    JOptionPane.INFORMATION_MESSAGE,
//                                    JOptionPane.QUESTION_MESSAGE, null,
//                                    botones, botones[0]);
                            JOptionPane.showMessageDialog(null, Utilidades.consultarEfectivo(d5, d10, d20, d50, d100, d200, d500, d1000, d2000));
                            break;
                        case 4:
                            Utilidades.cambiarCantidad(d5, d10, d20, d50, d100, d200, d500, d1000);
                            break;
                        case 5:
                            Utilidades.consultarEfectivoTotal(d5, d10, d20, d50, d100, d200, d500, d1000, d2000, m1);
                            JOptionPane.showMessageDialog(null, m1.getDeposito() + "€");
                            break;
                        case 6:
                            repetirMenuAdmin = false;
                            repetir = false;
                            JOptionPane.showMessageDialog(null, "Apagando la maquina");
                            break;
                        case 7:
                            repetirMenuAdmin = false;

                            break;

                    }
                } while (repetirMenuAdmin);
            } else {
                switch ((codigoSwitch)) {
                    case 1:
                        for (Bandeja listaBandeja : listaBandejas) {
                            if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                                JOptionPane.showMessageDialog(null, "El precio es " + (listaBandeja.getPrecioProducto()) / 100 + "€.");
                                if (Utilidades.formaPagoEfectivoTarjeta((codigo), listaBandejas)) {

                                    listaBandeja.setStockBandeja(listaBandeja.getStockBandeja() - 1);

                                } else {
                                    JOptionPane.showMessageDialog(null, "La compra no se ha realizado");

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
