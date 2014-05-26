/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;
import DAO.DAOArticulo;
import DAO.DAOGeneric;
import Negocio.Articulo;
import Negocio.Cliente;
import Negocio.CondicionPago;
import Negocio.Estado;
import Negocio.Pedido;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase para persistir articulos
 * @author m_pau_000
 */
public class TomaPedidos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Borramos la DB actual
        DAOGeneric.BorrarDB();
        //Instanciamos Articulos para los dos pedidos del cliente
        Articulo articulo1 = new Articulo(1,10.55,"articulo1",5,"unas caracteristicas","www.fotito.com/articulo1.jpeg",Date.from(Instant.now()),Date.from(Instant.now()));
        Articulo articulo2 = new Articulo(2,6.66,"articulo2",10,"otras caracteristicas","www.fotito.com/666.jpeg",Date.from(Instant.now()),Date.from(Instant.now()));
        Articulo articulo3 = new Articulo(3,15.77,"articulo3",15,"mas caracteristicas","www.fotoart3.com",Date.from(Instant.now()),Date.from(Instant.now()));
        //Instanciamos el Estado "Tomado"
        Estado estado1 = new Estado(1,"Tomado");
        //Instanciamos Condicion de Pago "Efectivo"
        CondicionPago condicionPago1 = new CondicionPago(1,"Efectivo");
        //Instanciamos Cliente
        Cliente cliente1 = new Cliente(1234,"San Martin 638","Coca Cola",condicionPago1);
        //Instanciamos 2 listas de articulos. A cada una se agregan diferentes Articulos
        List<Articulo> listaArticulos = new ArrayList();
        listaArticulos.add(articulo1);
        listaArticulos.add(articulo2);
        
        List<Articulo> listaArticulos2 = new ArrayList();
        listaArticulos2.add(articulo3);
        //Instanciamos 2 Pedidos y a cada uno le pasamos una Lista de Articulos diferente
        Pedido pedido1 = new Pedido(1,estado1,Date.from(Instant.now()),cliente1,listaArticulos);
        Pedido pedido2 = new Pedido(1,estado1,Date.from(Instant.now()),cliente1,listaArticulos2);
        //Instanciamos una Lista de Pedidos y agregamos los dos Pedidos
        List<Pedido> listaPedidos = new ArrayList();
        listaPedidos.add(pedido1);
        listaPedidos.add(pedido2);
        //Agregamos la Lista de Pedidos al Cliente
        cliente1.setLstPedidos(listaPedidos);
        
        System.out.println("");
        System.out.println("*********** AGREGANDO ARTICULOS *************");
        System.out.println("");
        
        for(Articulo art : listaArticulos){
            if(DAOArticulo.AgregarArticulo(art)){
                System.out.println("Articulo: " + art.getCodigo() + ". Succeded");
            }
            else{
                System.out.println("Articulo: " + art.getCodigo() + ". ERROR. VEO LA MUERTE EN CADA RINCON.");
            }
        }
        
        System.out.println("");
        System.out.println("*********** LISTANDO ARTICULOS AGREGADOS *************");
        System.out.println("");
        
        for(Articulo a : DAOArticulo.GetAll()){
            System.out.println(a.toString());
        }
    
        System.out.println("");
        System.out.println("*********** AGREGANDO CLIENTES *************");
        System.out.println("");
    }
}
