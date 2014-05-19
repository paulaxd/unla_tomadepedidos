/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;
import DAO.DAOArticulo;
import DAO.DAOGeneric;
import Negocio.Articulo;
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
        
        Articulo articulo1 = new Articulo(1, 10.55, "articulo1", 5, "unas caracteristicas", "www.fotito.com/articulo1.jpeg", Date.from(Instant.now()), Date.from(Instant.now()));
        Articulo articulo2 = new Articulo(2, 6.66, "articulo2", 10, "otras caracteristicas", "www.fotito.com/666.jpeg", Date.from(Instant.now()), Date.from(Instant.now()));
        
        List<Articulo> listaArticulos = new ArrayList();
        listaArticulos.add(articulo1);
        listaArticulos.add(articulo2);
        
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
    }
}
