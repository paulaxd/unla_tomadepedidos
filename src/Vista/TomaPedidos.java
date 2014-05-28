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
import DAO.DAOGeneric;
import DAO.DAOPedido;
import Negocio.Articulo;
import Negocio.ArticuloPedido;
import Negocio.Cliente;
import Negocio.CondicionPago;
import Negocio.Estado;
import Negocio.Pedido;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
  Clase para persistir articulos
  @author m_pau_000
 */
public class TomaPedidos {
    private static ArticuloPedido ArticuloPedido;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        //Borramos la DB actual
//        DAOGeneric.BorrarDB();
//        //Instanciamos Articulos para los dos pedidos del cliente
//        //Articulo articulo1 = new Articulo(1,10.55,"articulo1",5,"unas caracteristicas","www.fotito.com/articulo1.jpeg",Date.from(Instant.now()),Date.from(Instant.now()));
//        //Articulo articulo2 = new Articulo(2,6.66,"articulo2",10,"otras caracteristicas","www.fotito.com/666.jpeg",Date.from(Instant.now()),Date.from(Instant.now()));
//        //Articulo articulo3 = new Articulo(3,15.77,"articulo3",15,"mas caracteristicas","www.fotoart3.com",Date.from(Instant.now()),Date.from(Instant.now()));
//        //Instanciamos el Estado "Tomado"
//        Estado estado1 = new Estado(1,"Tomado");
//        //Instanciamos Condicion de Pago "Efectivo"
//        CondicionPago condicionPago1 = new CondicionPago(1,"Efectivo");
//        
//        //AGREGO CONDICION DE PAGO A LA BASE
//        if (DAOCondicionPago.AgregarCondicionPago(condicionPago1)){
//            System.out.println("Condicion de Pago: " + condicionPago1.getCodigo() + ". Succeded");
//        }
//        else{
//            System.out.println("Error al insertar Condicion de Pago");
//        }
//        
//        
//        //Instanciamos Cliente
//        Cliente cliente1 = new Cliente("1234","San Martin 638","Coca Cola",DAOCondicionPago.GetByCodigo(1));
//        
//        //AGREGO Cliente A LA BASE
//        if (DAOCliente.AgregarCliente(cliente1)){
//            System.out.println("Cliente: " + cliente1.getRazonSocial() + ". Succeded");
//        }
//        else{
//            System.out.println("Error al insertar Cliente");
//        }
//        
//        //Instanciamos 2 Pedidos y a cada uno le pasamos su cliente
//        Pedido pedido1 = new Pedido(1,estado1,Date.from(Instant.now()),cliente1);
//        Pedido pedido2 = new Pedido(1,estado1,Date.from(Instant.now()),cliente1);
//        
//        //Instanciamos una Lista de Pedidos y agregamos los dos Pedidos
////        List<Pedido> lstPedido = new ArrayList();
////        lstPedido.add(pedido1);
////        lstPedido.add(pedido2);
////        
////        //Instanciamos ArticuloPedido para asociar los pedidos con sus articulos correspondientes
////        ArticuloPedido articuloPedido1 = new ArticuloPedido(pedido1,articulo1,"direccion 1",2);
////        ArticuloPedido articuloPedido2 = new ArticuloPedido(pedido1,articulo2,"direccion 1",3);
////        ArticuloPedido articuloPedido3 = new ArticuloPedido(pedido1,articulo3,"direccion 1",4);
////        ArticuloPedido articuloPedido4 = new ArticuloPedido(pedido2,articulo3,"direccion 2",2);
////        //Instanciamos 2 listas de "ArticuloPedido". A cada una se agregan diferentes ArticuloPedido
////        List<ArticuloPedido> lstArticuloPedido = new ArrayList();
////        lstArticuloPedido.add(articuloPedido1);
////        lstArticuloPedido.add(articuloPedido2);
////        lstArticuloPedido.add(articuloPedido3);
////        lstArticuloPedido.add(articuloPedido4);
//        
//        System.out.println("");
//        System.out.println("*********** LISTANDO CLIENTES AGREGADOS *************");
//        System.out.println("");
//        
//        for(Cliente cli : DAOCliente.GetAll()){
//            System.out.println(cli.toString());
//        }
//        
//        System.out.println("");
//        System.out.println("*********** LISTANDO CONDICIONES DE PAGO *************");
//        System.out.println("");
//        
//        for(CondicionPago c : DAOCondicionPago.GetAll()){
//            System.out.println(c.toString());
//        }
//        
//        /*
//        System.out.println("");
//        System.out.println("*********** LISTANDO ARTICULOS POR PEDIDO *************");
//        System.out.println("");
//        
//        for(ArticuloPedido artPed : DAOArticuloPedido.GetAll()){
//            System.out.println(artPed.getPedido().getCodigo() + ". Articulo: " + artPed.getArticulo() + " - " + artPed.getCantidad() + ". Succeded");
//        }*/
//        
    }
}
