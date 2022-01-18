/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imad.maquinavendingrubenimad;

import java.util.UUID;

/**
 *
 * @author ruben
 */
public class MaquinaVending {
    
    private Bandeja bandeja;
    private Bandeja bandeja2;
    private Bandeja bandeja3;
    private Bandeja bandeja4;
    private Bandeja bandeja5;
    private Bandeja bandeja6;
    private TarjetaDeCredito t1;
    private TarjetaDeCredito t2;
    private TarjetaDeCredito t3;
    private int tamaño = 6;
    private int deposito;
    private String ubicacion;
    private UUID id;
    private final String psw;

    
    public MaquinaVending(Bandeja bandeja, Bandeja bandeja2, Bandeja bandeja3, 
            Bandeja bandeja4, Bandeja bandeja5, Bandeja bandeja6, TarjetaDeCredito t1,
            TarjetaDeCredito t2, TarjetaDeCredito t3, int deposito, String ubicacion) {
        this.bandeja = bandeja;
        this.bandeja2 = bandeja2;
        this.bandeja3 = bandeja3;
        this.bandeja4 = bandeja4;
        this.bandeja5 = bandeja5;
        this.bandeja6 = bandeja6;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.deposito = deposito;
        this.ubicacion = ubicacion;
        this.id = UUID.randomUUID();
        this.psw = Utilidades.getPassword();
    }
    
    
    
    public Bandeja getBandeja() {
        return bandeja;
    }

    public Bandeja getBandeja2() {
        return bandeja2;
    }

    public Bandeja getBandeja3() {
        return bandeja3;
    }

    public Bandeja getBandeja4() {
        return bandeja4;
    }

    public Bandeja getBandeja5() {
        return bandeja5;
    }

    public Bandeja getBandeja6() {
        return bandeja6;
    }

    public TarjetaDeCredito getT1() {
        return t1;
    }

    public TarjetaDeCredito getT2() {
        return t2;
    }

    public TarjetaDeCredito getT3() {
        return t3;
    }

    public int getTamaño() {
        return tamaño;
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

    public void setBandeja(Bandeja bandeja) {
        this.bandeja = bandeja;
    }

    public void setBandeja2(Bandeja bandeja2) {
        this.bandeja2 = bandeja2;
    }

    public void setBandeja3(Bandeja bandeja3) {
        this.bandeja3 = bandeja3;
    }

    public void setBandeja4(Bandeja bandeja4) {
        this.bandeja4 = bandeja4;
    }

    public void setBandeja5(Bandeja bandeja5) {
        this.bandeja5 = bandeja5;
    }

    public void setBandeja6(Bandeja bandeja6) {
        this.bandeja6 = bandeja6;
    }

    public void setT1(TarjetaDeCredito t1) {
        this.t1 = t1;
    }

    public void setT2(TarjetaDeCredito t2) {
        this.t2 = t2;
    }

    public void setT3(TarjetaDeCredito t3) {
        this.t3 = t3;
    }

    public void setDeposito(int deposito) {
        this.deposito = deposito;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "MaquinaVending{" + "bandeja=" + bandeja + ", bandeja2=" + bandeja2 + ", bandeja3=" + bandeja3 + ", bandeja4=" + bandeja4 + ", bandeja5=" + bandeja5 + ", bandeja6=" + bandeja6 + ", t1=" + t1 + ", t2=" + t2 + ", t3=" + t3 + ", tama\u00f1o=" + tamaño + ", deposito=" + deposito + ", ubicacion=" + ubicacion + ", id=" + id + ", psw=" + psw + '}';
    }

    
    
    
}
