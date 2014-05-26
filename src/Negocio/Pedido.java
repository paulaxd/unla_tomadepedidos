/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.util.Date;
import java.util.List;

/**
 *
 * @author maurogarcia
 */
public class Pedido {
    
    private int codigo;
    private Estado estado;
    private Date fecha;
    private Cliente cliente;
    private List<Articulo> lstArticulos;

    public Pedido(int codigo, Estado estado, Date fecha, Cliente cliente, List<Articulo> lstArticulos) {
        this.codigo = codigo;
        this.estado = estado;
        this.fecha = fecha;
        this.cliente = cliente;
        this.lstArticulos = lstArticulos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Articulo> getLstArticulos() {
        return lstArticulos;
    }

    public void setLstArticulos(List<Articulo> lstArticulos) {
        this.lstArticulos = lstArticulos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", estado=" + estado + ", fecha=" + fecha + ", cliente=" + cliente + ", lstArticulos=" + lstArticulos + '}';
    }
    
    
}
