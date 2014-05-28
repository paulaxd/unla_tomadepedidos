/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maurogarcia
 */
public class Cliente {
    
    private String cuil;
    private String domicilio;
    private String razonSocial;
    private List<Pedido> lstPedidos;
    private CondicionPago condicionPago;

    public Cliente(String cuil, String domicilio, String razonSocial, CondicionPago condicionPago) {
        this.cuil = cuil;
        this.domicilio = domicilio;
        this.razonSocial = razonSocial;
        this.lstPedidos = new ArrayList();
        this.condicionPago = condicionPago;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<Pedido> getLstPedidos() {
        return lstPedidos;
    }

    public void setLstPedidos(List<Pedido> lstPedidos) {
        this.lstPedidos = lstPedidos;
    }

    public CondicionPago getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(CondicionPago condicionPago) {
        this.condicionPago = condicionPago;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cuil=" + cuil + ", domicilio=" + domicilio + ", razonSocial=" + razonSocial + ", lstPedidos=" + lstPedidos + ", condicionPago=" + condicionPago + '}';
    }

}
