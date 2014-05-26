/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author maurogarcia
 */
public class ArticuloPedido {
    
    private Pedido pedido;
    private Articulo articulo;
    private CondicionPago condicionPago;
    private String direccionEnvio;
    private int cantidad;

    public ArticuloPedido(Pedido pedido, Articulo articulo, CondicionPago condicionPago, String direccionEnvio, int cantidad) {
        this.pedido = pedido;
        this.articulo = articulo;
        this.condicionPago = condicionPago;
        this.direccionEnvio = direccionEnvio;
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public CondicionPago getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(CondicionPago condicionPago) {
        this.condicionPago = condicionPago;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ArticuloPedido{" + "pedido=" + pedido + ", articulo=" + articulo + ", condicionPago=" + condicionPago + ", direccionEnvio=" + direccionEnvio + ", cantidad=" + cantidad + '}';
    }
    
    
}
