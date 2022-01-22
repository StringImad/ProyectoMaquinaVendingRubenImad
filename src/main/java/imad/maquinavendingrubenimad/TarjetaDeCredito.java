/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.maquinavendingrubenimad;

import java.time.LocalDate;


/**
 *
 * @author diabl
 */
public class TarjetaDeCredito {

    private String numero;
    private LocalDate fechaVencimiento;
    private int cvv;

    public TarjetaDeCredito(String numero, LocalDate fechaVencimiento, int cvv) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }

    //Método para saber si la tarjeta es valida para realizar el pago 
    public boolean ValidarFecha(LocalDate fecha){
        LocalDate ahora = LocalDate.now();
        return fecha.isAfter(ahora);
    }
    public boolean CompararTarjetas(TarjetaDeCredito t1) {

        return t1.cvv == this.cvv && t1.numero == this.numero && t1.fechaVencimiento == this.fechaVencimiento;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCvv() {
        return cvv;
    }

}
