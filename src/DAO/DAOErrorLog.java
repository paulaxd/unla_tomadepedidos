/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Negocio.ErrorLog;
import Utiles.Utiles;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;

/***
 * Clase para la persistencia del LOG de errores.
 * @author m_pau_000
 */
public class DAOErrorLog {
    private static ObjectContainer db;
    
    /***
     * Método que agrega un Articulo
     * @param metodo El metodo donde se dio el error.
     * @param clase La clase donde se dio el error.
     * @param mensaje El mensaje de error.
     * @return True en caso de exito. False en caso de error.
     */
    public static boolean AgregarErrorLog(String metodo, String clase, String mensaje){
        boolean flag = true;
        ErrorLog error = new ErrorLog(metodo, clase, mensaje);
        try{
            db = Db4o.openFile(Utiles.DB_FILE_PATH);
            db.store(error);
            db.commit();
        }
        catch(Exception ex){
            db.rollback();
            flag = false;
        }
        finally{
            db.close();
        }
        return flag;
    }
    
    public static List<ErrorLog> GetAll(){
       List<ErrorLog> lstArticulos = new ArrayList();
       try{
            db = Db4o.openFile(Utiles.DB_FILE_PATH);
            ObjectSet<ErrorLog> result = db.query(ErrorLog.class);

            for(ErrorLog a : result){
                lstArticulos.add(a);
            }
       }
       catch(Exception ex){
       }
       finally{
           db.close();
       }
       return lstArticulos;
    }
}
