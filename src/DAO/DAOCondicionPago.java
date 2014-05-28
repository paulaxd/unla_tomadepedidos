/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Negocio.CondicionPago;
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
public class DAOCondicionPago {
    
    private static ObjectContainer db;

    public static boolean AgregarCondicionPago(CondicionPago condicionPago){
        boolean flag = true;
        try{
            //Abre el archivo de la DB
            db = Db4o.openFile(Utiles.DB_FILE_PATH);
            //Graba la condicion de pago recibida por parametro
            db.store(condicionPago);
            //Persistir los cambios
            db.commit();
        }
        catch(Exception ex){
            //Volver al estado anterior
            db.rollback();
            flag = false;
            //Graba log del error
            DAOErrorLog.AgregarErrorLog("AgregarCondicionPago", "DAOCondicionPago", ex.getMessage());
        }
        finally{
            //Cierra la DB
            db.close();
        }
        //Devuelve TRUE en caso de exito y FALSE en caso contrario
        return flag;
    }

    public static List<CondicionPago> GetAll(){
       List<CondicionPago> lstCondicionPago = new ArrayList();
       try{
            //Abre el archivo de la DB
            db = Db4o.openFile(Utiles.DB_FILE_PATH); 
            //Trae todos los objetos del tipo CondicionPago
            ObjectSet<CondicionPago> result = db.query(CondicionPago.class); 
            //Carga una lista del tipo CondicionPago 
            for(CondicionPago a : result){
                lstCondicionPago.add(a);
            }
       }
       catch(Exception ex){
           //Graba un log de errores en la DB
           DAOErrorLog.AgregarErrorLog("GetAll", "DAOCondicionPago", ex.getMessage());
       }
       finally{
           //Cierra el archivo
           db.close();
       }
       //Devuelvo la lista cargada (o vacía en caso de excepcion)
       return lstCondicionPago;
    }
    
    public static CondicionPago getCondicionPagoByCodigo(int codigo){
        CondicionPago resultado = null;
        try{
            //Abre el archivo de la DB
            db = Db4o.openFile(Utiles.DB_FILE_PATH); 
            //Trae todos los objetos del tipo CondicionPago
            ObjectSet result = db.queryByExample(new CondicionPago(codigo,""));
            CondicionPago encontrado = (CondicionPago)result.next();
            return encontrado;
        }
        catch(Exception ex){
           //Graba un log de errores en la DB
           DAOErrorLog.AgregarErrorLog("GetAll", "DAOCondicionPago", ex.getMessage());
        }
        finally{
           //Cierra el archivo
           db.close();
        }
        return null;
    }
}
