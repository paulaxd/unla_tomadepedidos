/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import DAO.DAOArticulo;
import Negocio.Articulo;
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
        List<Articulo> lst = DAOArticulo.ImportarArticulos();
        
        for(Articulo a : lst){
            System.out.println(a.toString());
        }
    }
    
}
