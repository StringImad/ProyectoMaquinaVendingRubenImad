 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.maquinavendingrubenimad;

/**
 *
 * @author MSI
 */
public class Bandeja {
//Declaracion de variables
    private String tipoDeProducto;
    private int codigoProducto;
    private int precioProducto;
    private int stockBandeja;
//constructor parametrizado
    public Bandeja(String tipoDeProducto, int codigoProducto, int precioProducto, int stockBandeja) {
        this.tipoDeProducto = tipoDeProducto;
        this.codigoProducto = codigoProducto;
        this.precioProducto = precioProducto;
        this.stockBandeja = stockBandeja;
    }
//constructor por defecto
    public Bandeja() {
    }
//GEtter and Setter
    public String getTipoDeProducto() {
        return tipoDeProducto;
    }

    public void setTipoDeProducto(String tipoDeProducto) {
        this.tipoDeProducto = tipoDeProducto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getStockBandeja() {
        return stockBandeja;
    }

    public void setStockBandeja(int stockBandeja) {
        this.stockBandeja = stockBandeja;
    }

    @Override
    public String toString() {
        return "Producto: " + getTipoDeProducto() + ", Código: " +getCodigoProducto() +"\n";
    }
    
    public String toStringStock() {
      return "Producto: " + getTipoDeProducto() + ", Código: " +getCodigoProducto() +", Stock: "+getStockBandeja()+"\n";
    }

}
