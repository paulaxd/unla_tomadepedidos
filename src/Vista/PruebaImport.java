/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import DAO.DAOArticulo;
import DAO.DAOCliente;
import DAO.DAOCondicionPago;
import DAO.DAOGeneric;
import Negocio.Articulo;
import Negocio.Cliente;
import Negocio.CondicionPago;
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
        
        for(Articulo a : lst){
            System.out.println(a.toString());
        }
        
        for(Cliente c : lstCliente){
            System.out.println(c.toString());
        }
        
        for(CondicionPago c : lstCondicion){
            System.out.println(c.toString());
        }
        
//        String[] propiedades = { "codigo", "precio", "nombre", "cantidadPorBulto", "caracteristicas", "fotografiaURL", "fechaActualizacion", "vigenciaPrecio" };
//        String json = Utiles.Utiles.CsvToJson(Utiles.Utiles.IMPORT_FILE_PATH_ARTICULOS, propiedades, "Articulos");
//        System.out.println(json);
        
    }
    
}
