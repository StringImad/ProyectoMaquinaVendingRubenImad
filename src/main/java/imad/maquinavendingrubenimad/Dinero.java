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
        switch(valor){
            case 5: 
                this.valor = valor;
                break;
            case 10:
                this.valor = valor;
                break;
            case 20:
                this.valor = valor;
                break;
            case 50:
                this.valor = valor;
                break;
            case 100:
                this.valor = valor;
                break;
            case 200:
                this.valor = valor;
                break;
            case 500:
                this.valor = valor;
                break;
            case 10000:
                this.valor = valor;
                break;
            case 20000:
                this.valor = valor;
                break;
            default:
                break;
        }
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
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
