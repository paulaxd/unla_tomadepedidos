/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import DAO.DAOArticulo;
import DAO.DAOArticuloPedido;
import DAO.DAOCliente;
import DAO.DAOCondicionPago;
import DAO.DAOEstado;
import DAO.DAOGeneric;
import DAO.DAOPedido;
import Negocio.Articulo;
import Negocio.ArticuloPedido;
import Negocio.Cliente;
import Negocio.CondicionPago;
import Negocio.Estado;
import Negocio.Pedido;
import java.util.List;

/**
 *
 * @author m_pau_000
 */
public class PruebaImport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAOGeneric.BorrarDB();
        
        List<Articulo> lst = DAOArticulo.ImportarArticulos();
        DAOArticulo.AgregarArticulo(lst);
        
        List<CondicionPago> lstCondicion = DAOCondicionPago.ImportarCondicionPago();
        DAOCondicionPago.AgregarCondicionPago(lstCondicion);
        
        List<Cliente> lstCliente = DAOCliente.ImportarClientes();
        DAOCliente.AgregarCliente(lstCliente);
        
        List<Estado> lstEstado = DAOEstado.ImportarEstado();
        DAOEstado.AgregarEstado(lstEstado);
        
        List<Pedido> lstPedido = DAOPedido.ImportarPedidos();
        DAOPedido.AgregarPedido(lstPedido);
        
        List<ArticuloPedido> lstArticuloPedido = DAOArticuloPedido.ImportarArticuloPedido();
        DAOArticuloPedido.AgregarArticuloPedido(lstArticuloPedido);
        
        for(Articulo a : DAOArticulo.GetAll()){
            System.out.println(a.toString());
        }
        
        for(Cliente c : DAOCliente.GetAll()){
            System.out.println(c.toString());
        }
        
        for(CondicionPago c : DAOCondicionPago.GetAll()){
            System.out.println(c.toString());
        }
        
        for(Estado e : DAOEstado.GetAll()){
            System.out.println(e.toString());
        }
        
        for(Pedido p : DAOPedido.GetAll()){
            System.out.println(p.toString());
        }
        
        for(ArticuloPedido ap : DAOArticuloPedido.GetAll()){
            System.out.println(ap.toString());
        }
        
    }
    
}
