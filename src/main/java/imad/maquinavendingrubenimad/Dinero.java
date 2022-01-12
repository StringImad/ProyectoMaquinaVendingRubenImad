/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imad.maquinavendingrubenimad;

/**
 *
 * @author ruben
 */
public class Dinero {

    private int valor;
    private int cantidad;

    public Dinero() {
        this.cantidad = 5;
    }

    public Dinero(int valor, int cantidad) {
        if (valor >= 1 || valor <= 2000) {
            this.valor = valor;
        }
        if (cantidad < 5) {
            this.cantidad = 5;
        } else {
            this.cantidad = cantidad;
        }
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Dinero{" + "valor=" + valor + ", cantidad=" + (cantidad / 100) + '}';
    }

}
