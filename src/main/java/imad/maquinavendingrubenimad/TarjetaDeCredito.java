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
    private String numero;
    private LocalDateTime fechaVencimiento;
    private int cvv;

    public TarjetaDeCredito(String numero, LocalDateTime fechaVencimiento, int cvv) {
        if(numero.length() == 16){
           this.numero = numero; 
        }
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }
    
    //Método para saber si la tarjeta es valida para realizar el pago 
    public static boolean ValidarFecha(LocalDateTime fecha){
        LocalDateTime ahora = LocalDateTime.now();
        return fecha.isBefore(ahora);
    }
    
    public String getNumero() {
        return numero;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCvv() {
        return cvv;
    }
    
}
