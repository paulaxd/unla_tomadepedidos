/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Negocio.Estado;
import Utiles.Utiles;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maurogarcia
 */
public class DAOEstado {
    
    private static ObjectContainer db;

    public static boolean AgregarEstado(Estado estado){
        boolean flag = true;
        try{
            //Abre el archivo de la DB
            db = Db4o.openFile(Utiles.DB_FILE_PATH);
            //Graba el Estado recibido por parametro
            db.store(estado);
            //Persistir los cambios
            db.commit();
        }
        catch(Exception ex){
            //Volver al estado anterior
            db.rollback();
            flag = false;
            //Graba log del error
            DAOErrorLog.AgregarErrorLog("AgregarEstado", "DAOEstado", ex.getMessage());
        }
        finally{
            //Cierra la DB
            db.close();
        }
        //Devuelve TRUE en caso de exito y FALSE en caso contrario
        return flag;
    }

    public static List<Estado> GetAll(){
       List<Estado> lstEstado = new ArrayList();
       try{
            //Abre el archivo de la DB
            db = Db4o.openFile(Utiles.DB_FILE_PATH); 
            //Trae todos los objetos del tipo Estado
            ObjectSet<Estado> result = db.query(Estado.class); 
            //Carga una lista del tipo Estado 
            for(Estado a : result){
                lstEstado.add(a);
            }
       }
       catch(Exception ex){
           //Graba un log de errores en la DB
           DAOErrorLog.AgregarErrorLog("GetAll", "DAOEstado", ex.getMessage());
       }
       finally{
           //Cierra el archivo
           db.close();
       }
       //Devuelvo la lista cargada (o vacía en caso de excepcion)
       return lstEstado;
    }
    
    public static Estado GetByCodigo(int codigo){
        Estado resultado = null;
        try{
            //Abre el archivo de la DB
            db = Db4o.openFile(Utiles.DB_FILE_PATH); 
            //Trae todos los objetos del tipo Estado
            ObjectSet result = db.queryByExample(new Estado(codigo));
            Estado encontrado = (Estado)result.next();
            return encontrado;
        }
        catch(Exception ex){
           //Graba un log de errores en la DB
           DAOErrorLog.AgregarErrorLog("GetAll", "DAOEstado", ex.getMessage());
        }
        finally{
           //Cierra el archivo
           db.close();
        }
        return null;
    }
    
    public static boolean AgregarEstado(List<Estado> lstEstado){
        boolean flag = true;
        
        try{
            for(Estado a : lstEstado){
                if(!AgregarEstado(a)){
                    flag = false;
                    break;
                }
            }
        }
        catch(Exception ex){
            flag = false;
        }
        
        return flag;
    }
}
