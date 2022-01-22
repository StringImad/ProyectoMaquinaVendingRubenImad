/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imad.maquinavendingrubenimad;

import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author ruben
 */
public class MaquinaVending {

    
    private int deposito;
    private String ubicacion;
    private final UUID id;
    private final String psw;
    private LocalDate fecha;

    public MaquinaVending(int deposito, String ubicacion, LocalDate fecha) {
        this.deposito = deposito;
        this.ubicacion = ubicacion;
        this.id = UUID.randomUUID();
        this.psw = Utilidades.getPassword();
        this.fecha = fecha;
    }

    public int getDeposito() {
        return deposito;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setDeposito(int deposito) {
        this.deposito = deposito;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "MaquinaVending{" + "deposito=" + deposito + ", ubicacion=" + ubicacion + ", id=" + id + ", fecha=" + fecha + '}';
    }

    

}
