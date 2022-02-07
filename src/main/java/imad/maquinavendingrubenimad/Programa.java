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
        boolean repetir = true;
        boolean repetirMenuAdmin = true;
        int dineroRecaudado = 0;
        boolean comprobarIntroduccionIncorrectaUsuario = true;
        int codigoSwitch = 0;
        //Guardamos en este string el codigo aleatorio generado para se le codigo de administrador
        final String CODIGO_GENERADO = Utilidades.getPassword();
        System.out.println(CODIGO_GENERADO);
        //Se imprime el codigo para que sea mas facil de introdcuir
        //Creamos un arrayList de bandejas apartir de un fichero csv
        ArrayList<Bandeja> listaBandejas = LecturaFicheros.leerFicheroCsvArticulos("articulos.csv");
        //Declaracion de objetos
        LocalDate ultimaFecha = LocalDate.now();
        MaquinaVending m1 = new MaquinaVending();
        Dinero d5 = new Dinero(5, 10);
        Dinero d10 = new Dinero(10, 10);
        Dinero d20 = new Dinero(20, 10);
        Dinero d50 = new Dinero(50, 10);
        Dinero d100 = new Dinero(100, 5);
        Dinero d200 = new Dinero(200, 6);
        Dinero d500 = new Dinero(500, 10);
        Dinero d1000 = new Dinero(1000, 1);
        Dinero d2000 = new Dinero(2000, 0);
        //Bucle do que repite el programa hasta que el administrador decide salir
        do {
            //Bucle do que controla la introduccion correcta del codigo
            do {
                codigo = JOptionPane.showInputDialog("El codigo del administrador es: " + CODIGO_GENERADO + "\n" + listaBandejas + "\nIntroduce un codigo");
                //bloque try catch que sirve para controlar las excepciones de datos a la hora de pasar a int
                try {
                    //bloque try catch que utilizamos para controlar que no haya valores vacions
                    try {
                        //Si el codigo introducido es igual que el del administrador interrumpimos el programa para que se salga del menu de compra
                        if (codigo.equals(CODIGO_GENERADO)) {
                            break;
                        }
                    } catch (NullPointerException npe) {
                        JOptionPane.showMessageDialog(null, "EL programa solo puede ser cancelado por el Administrador", "Error de formato",
                                JOptionPane.ERROR_MESSAGE);
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
            //Si el codigo introducido es igual al codigo generado entramos en el menu de administrador
            if (codigo.contentEquals(CODIGO_GENERADO)) {
                do {
                    repetirMenuAdmin = true;
                    //Array de string que nos almacena en cada posision un string que equivale a la opcion del menu 
                    String[] botones = {
                        "Consultar y cambiar código",
                        "Consultar y cambiar el producto",
                        "Consultar y cambiar el stock",
                        "Consultar y recaudar efectivo",
                        "Recargar efectivo",
                        "Consultar dinero tarjetas",
                        "Apagar",
                        "salir"};
                    //Almacena en ventana el numero de la posicion de la eleccion del menu en el array
                    int ventana = JOptionPane.showOptionDialog(null,
                            "Elige la opcion que desea:",
                            "Bienvenido al menu de administracion",
                            JOptionPane.INFORMATION_MESSAGE,
                            JOptionPane.QUESTION_MESSAGE, null,
                            botones, botones[0]);
                    switch (ventana) {
                        case 0:
                            //Array de string que nos almacena en cada posision un string que equivale a la opcion del menu 
                            String[] botonesCodigo = {
                                "Consultar código",
                                "cambiar codigo", "salir"};
                            //Almacena en ventana el numero de la posicion de la eleccion del menu en el array
                            int ventanaCodigo = JOptionPane.showOptionDialog(null,
                                    "Elige la opcion que desea:",
                                    "Consultar y cambiar el código de las bandejas",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    botonesCodigo, botonesCodigo[0]);
                            switch (ventanaCodigo) {
                                case 0:
                                    //Muestra todos los objetos guardados en la lista de bandejas
                                    JOptionPane.showMessageDialog(null, listaBandejas);
                                    break;
                                case 1:
                                    //metodo privado y estatico que nos sirve para cambiar el codigo del producto
                                    modificarCodigoProducto(listaBandejas, comprobarIntroduccionIncorrectaUsuario);
                                case 2:
                                    JOptionPane.showMessageDialog(null, "volviendo al menu");
                            }

                            break;
                        case 1:
                            //Array de string que nos almacena en cada posision un string que equivale a la opcion del menu 
                            String[] botonesProducto = {
                                "Consultar producto",
                                "cambiar producto", "salir"};
                            //Almacena en ventana el numero de la posicion de la eleccion del menu en el array
                            int ventanaProducto = JOptionPane.showOptionDialog(null,
                                    "Elige la opcion que desea:",
                                    "Bienvenido al menu de administracion",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    botonesProducto, botonesProducto[0]);
                            switch (ventanaProducto) {
                                case 0:
                                    //Muestra todos los objetos guardados en la lista de bandejas
                                    JOptionPane.showMessageDialog(null, listaBandejas);
                                    break;
                                case 1:
                                    modificarNombreProducto(listaBandejas, comprobarIntroduccionIncorrectaUsuario);
                                case 2:
                                    JOptionPane.showMessageDialog(null, "volviendo al menu");
                            }

                            break;

                        case 2:
                            //Array de string que nos almacena en cada posision un string que equivale a la opcion del menu 
                            String[] botonesStock = {
                                "Consultar stock",
                                "cambiar stock", "salir"};
                            //Almacena en ventana el numero de la posicion de la eleccion del menu en el array
                            int ventanaStock = JOptionPane.showOptionDialog(null,
                                    "Elige la opcion que desea:",
                                    "Bienvenido al menu de administracion",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    botonesStock, botonesStock[0]);

                            switch (ventanaStock) {
                                case 0:
                                    String stock = "";
                                    //bucle foreach que nos imprime la lista del stock actualizada 
                                    for (Bandeja listaBandeja : listaBandejas) {
                                        stock += listaBandeja.toStringStock() + "\n";
                                    }
                                    JOptionPane.showMessageDialog(null, stock);

                                    break;

                                case 1:
                                    modificarStock(listaBandejas, comprobarIntroduccionIncorrectaUsuario);

                                case 2:
                                    JOptionPane.showMessageDialog(null, "volviendo al menu");
                            }
                            break;

                        case 3:
                            String[] botonesEfectivo = {
                                "Consultar efectivo",
                                "recaudar efectivo", "salir"};
                            int ventanaEfectivo = JOptionPane.showOptionDialog(null,
                                    "Elige la opcion que desea:",
                                    "Bienvenido al menu de administracion",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    botonesEfectivo, botonesEfectivo[0]);

                            switch (ventanaEfectivo) {
                                case 0:
                                    JOptionPane.showMessageDialog(null, Utilidades.consultarEfectivo(d5, d10, d20, d50, d100, d200, d500, d1000, d2000));
                                    break;
                                case 1:
                                    Utilidades.recaudarDinero(d5, d10, d20, d50, d100, d200, d500, d1000, d2000);
                                    JOptionPane.showMessageDialog(null, "Se ha recaudado el día: " + ultimaFecha);
                                    break;
                                case 2:
                                    JOptionPane.showMessageDialog(null, "volviendo al menu");
                            }
                            break;
                        case 4:
                            Utilidades.cambiarCantidad(d5, d10, d20, d50, d100, d200, d500, d1000);
                            break;
                        case 5:
                            dineroRecaudado = Utilidades.getContadorDineroTarjeta();
                            JOptionPane.showMessageDialog(null, "Se han recaudado: " + (dineroRecaudado / 100) + " €");
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
                        compraProducto(codigo, listaBandejas, d5, d10, d20, d50, d100, d200, d500, d1000, d2000);

                        break;
                    case 2:
                        compraProducto(codigo, listaBandejas, d5, d10, d20, d50, d100, d200, d500, d1000, d2000);

                        break;

                    case 3:
                        compraProducto(codigo, listaBandejas, d5, d10, d20, d50, d100, d200, d500, d1000, d2000);

                        break;

                    case 4:
                        compraProducto(codigo, listaBandejas, d5, d10, d20, d50, d100, d200, d500, d1000, d2000);

                        break;

                    case 5:
                        compraProducto(codigo, listaBandejas, d5, d10, d20, d50, d100, d200, d500, d1000, d2000);

                        break;

                    case 6:
                        compraProducto(codigo, listaBandejas, d5, d10, d20, d50, d100, d200, d500, d1000, d2000);

                        break;
                }
            }
        } while (repetir);
    }

    //metodo privado y estatico que recibe el codigo y la lista de bandeja que nos los productos y si la compra se ha realizado con exito
    private static void compraProducto(String codigo, ArrayList bandeja, Dinero d5, Dinero d10, Dinero d20, Dinero d50, Dinero d100, Dinero d200, Dinero d500, Dinero d1000, Dinero d2000) {
        ArrayList<Bandeja> listaBandejas = bandeja;

        for (Bandeja listaBandeja : listaBandejas) {
            if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigo)) {
                JOptionPane.showMessageDialog(null, "El precio es " + (listaBandeja.getPrecioProducto()) / 100 + "€.");
                if (Utilidades.formaPagoEfectivoTarjeta((codigo), listaBandejas, d5, d10, d20, d50, d100, d200, d500, d1000, d2000)) {
                    JOptionPane.showMessageDialog(null, "Recoja su producto, gracias por su compra");
                    listaBandeja.setStockBandeja(listaBandeja.getStockBandeja() - 1);

                } else {
                    JOptionPane.showMessageDialog(null, "La compra no se ha realizado");

                }
            }
        }
    }
    //metodo privado y estatico que tiene como parametros la lista de bandejas y una variable booleana que lo utilizamos para modificar el codigo del producto

    private static void modificarCodigoProducto(ArrayList bandeja, boolean comprobarIntroduccionIncorrectaUsuario) {
        String codigoNuevo = "";
        ArrayList<Bandeja> listaBandejas = bandeja;

        do {
            comprobarIntroduccionIncorrectaUsuario = false;
            try {
                codigoNuevo = JOptionPane.showInputDialog(listaBandejas + "\nIntroduce el codigo del producto que desea modificar");
                for (Bandeja listaBandeja : listaBandejas) {
                    if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigoNuevo)) {
                        codigoNuevo = JOptionPane.showInputDialog("El producto es " + listaBandeja.getTipoDeProducto() + " introduce el codigo nuevo");
                        listaBandeja.setCodigoProducto(Integer.parseInt(codigoNuevo));
                    }
                }
            } catch (NumberFormatException NFE) {
                //Mensaje de error
                JOptionPane.showMessageDialog(null, "Formato incorrecto:\n"
                        + "Por favor ingrese un valor valido", "Error de formato",
                        JOptionPane.ERROR_MESSAGE);
                comprobarIntroduccionIncorrectaUsuario = true;
            }
        } while (comprobarIntroduccionIncorrectaUsuario);
    }
    //metodo privado y estatico que tiene como parametros la lista de bandejas y una variable booleana que lo utilizamos para modificar el nombre del producto

    private static void modificarNombreProducto(ArrayList bandeja, boolean comprobarIntroduccionIncorrectaUsuario) {
        ArrayList<Bandeja> listaBandejas = bandeja;
        do {
            comprobarIntroduccionIncorrectaUsuario = false;
            try {
                String codigoNuevo = JOptionPane.showInputDialog(listaBandejas + "\nIntroduce el codigo del producto que desea modificar");
                for (Bandeja listaBandeja : listaBandejas) {
                    if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigoNuevo)) {
                        String nombreNuevo = JOptionPane.showInputDialog("El producto es " + listaBandeja.getTipoDeProducto() + " introduce el nombre nuevo");
                        listaBandeja.setTipoDeProducto((nombreNuevo));
                    }
                }

            } catch (NumberFormatException NFE) {
                //Mensaje de error
                JOptionPane.showMessageDialog(null, "Formato incorrecto:\n"
                        + "Por favor ingrese un valor valido", "Error de formato",
                        JOptionPane.ERROR_MESSAGE);
                comprobarIntroduccionIncorrectaUsuario = true;
            }
        } while (comprobarIntroduccionIncorrectaUsuario);
    }

    //metodo privado y estatico que tiene como parametros la lista de bandejas y una variable booleana que lo utilizamos para modificar el stock
    private static void modificarStock(ArrayList bandeja, boolean comprobarIntroduccionIncorrectaUsuario) {
        ArrayList<Bandeja> listaBandejas = bandeja;
        do {
            comprobarIntroduccionIncorrectaUsuario = false;
            try {
                String codigoNuevo = JOptionPane.showInputDialog(listaBandejas + "\nIntroduce el codigo del producto que desea modificar");
                String stockNuevo;
                for (Bandeja listaBandeja : listaBandejas) {
                    if (listaBandeja.getCodigoProducto() == Integer.parseInt(codigoNuevo)) {
                        do {
                            stockNuevo = JOptionPane.showInputDialog("El producto es " + listaBandeja.getTipoDeProducto() + " introduce el stock nuevo");
                        } while (Integer.parseInt(stockNuevo) >= 16 || Integer.parseInt(stockNuevo) <= 0);
                        listaBandeja.setStockBandeja((Integer.parseInt(stockNuevo)));
                    }
                }
            } catch (NumberFormatException NFE) {
                //Mensaje de error
                JOptionPane.showMessageDialog(null, "Formato incorrecto:\n"
                        + "Por favor ingrese un valor valido", "Error de formato",
                        JOptionPane.ERROR_MESSAGE);
                comprobarIntroduccionIncorrectaUsuario = true;
            }
        } while (comprobarIntroduccionIncorrectaUsuario);
    }
}
