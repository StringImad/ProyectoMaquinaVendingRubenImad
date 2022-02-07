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

    //Declaracion de variables
    private double deposito;
    private String ubicacion;
    private final UUID ID;
    private final String PSW;
    private LocalDate fecha;
//Constructor

    public MaquinaVending() {
        this.ID = UUID.randomUUID();
        this.PSW = Utilidades.getPassword();
    }

    //constructor parametrizado
    public MaquinaVending(int deposito, String ubicacion, LocalDate fecha) {
        this.deposito = deposito;
        this.ubicacion = ubicacion;
        this.ID = UUID.randomUUID();
        this.PSW = Utilidades.getPassword();
        this.fecha = fecha;
    }
//Geters and setter

    public double getDeposito() {
        return deposito;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public UUID getId() {
        return ID;
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
//toString

    @Override
    public String toString() {
        return "MaquinaVending{" + "deposito=" + deposito + ", ubicacion=" + ubicacion + ", id=" + ID + ", fecha=" + fecha + '}';
    }

}
