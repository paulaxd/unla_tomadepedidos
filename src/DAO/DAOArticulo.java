package DAO;

import Negocio.Articulo;
import Utiles.Utiles;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m_pau_000
 */
public class DAOArticulo {
    
    private static ObjectContainer db;
    
    public static boolean AgregarArticulo(Articulo articulo){
        boolean flag = true;
        try{
            //Abre el archivo de la DB
            db = Db4o.openFile(Utiles.DB_FILE_PATH);
            //Graba el articulo recibido por parametro
            db.store(articulo);
            //Persistir los cambios
            db.commit();
        }
        catch(Exception ex){
            //Volver al estado anterior
            db.rollback();
            flag = false;
            //Graba log del error
            DAOErrorLog.AgregarErrorLog("AgregarArticulo", "DAOArticulo", ex.getMessage());
        }
        finally{
            //Cierra la DB
            db.close();
        }
        //Devuelve TRUE en caso de exito y FALSE en caso contrario
        return flag;
    }
    
    public static List<Articulo> GetAll(){
       List<Articulo> lstArticulos = new ArrayList();
       try{
            //Abre el archivo de la DB
            db = Db4o.openFile(Utiles.DB_FILE_PATH); 
            //Trae todos los objetos del tipo Articulo
            ObjectSet<Articulo> result = db.query(Articulo.class); 
            //Carga una lista del tipo Articulo 
            for(Articulo a : result){
                lstArticulos.add(a);
            }
       }
       catch(Exception ex){
           //Graba un log de errores en la DB
           DAOErrorLog.AgregarErrorLog("GetAll", "DAOArticulo", ex.getMessage());
       }
       finally{
           //Cierra el archivo
           db.close();
       }
       //Devuelvo la lista cargada (o vacía en caso de excepcion)
       return lstArticulos;
    }
    
}
