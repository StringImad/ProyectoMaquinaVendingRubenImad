/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.maquinavendingrubenimad;


import java.time.LocalDateTime;

/**
 *
 * @author diabl
 */
public class TarjetaDeCredito {
    private int numero;
    private LocalDateTime fechaVencimiento;
    private int cvv;

    public TarjetaDeCredito(int numero, LocalDateTime fechaVencimiento, int cvv) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }
    
    //Método para saber si la tarjeta es valida para realizar el pago 
    public static boolean ValidarFecha(LocalDateTime fecha){
        LocalDateTime ahora = LocalDateTime.now();
        return fecha.isBefore(ahora);
    }
    
    public int getNumero() {
        return numero;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCvv() {
        return cvv;
    }
    
}
