/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Negocio.ArticuloPedido;
import Utiles.Utiles;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maurogarcia
 */
public class DAOArticuloPedido {
    
    private static ObjectContainer db;

    public static boolean AgregarArticuloPedido(ArticuloPedido articuloPedido){
        boolean flag = true;
        try{
            //Abre el archivo de la DB
            db = Db4o.openFile(Utiles.DB_FILE_PATH);
            //Graba el ArticuloPedido recibido por parametro
            db.store(articuloPedido);
            //Persistir los cambios
            db.commit();
        }
        catch(Exception ex){
            //Volver al estado anterior
            db.rollback();
            flag = false;
            //Graba log del error
            DAOErrorLog.AgregarErrorLog("AgregarArticuloPedido", "DAOArticuloPedido", ex.getMessage());
        }
        finally{
            //Cierra la DB
            db.close();
        }
        //Devuelve TRUE en caso de exito y FALSE en caso contrario
        return flag;
    }

    public static List<ArticuloPedido> GetAll(){
       List<ArticuloPedido> lstArticulosPedido = new ArrayList();
       try{
            //Abre el archivo de la DB
            db = Db4o.openFile(Utiles.DB_FILE_PATH); 
            //Trae todos los objetos del tipo ArticuloPedido
            ObjectSet<ArticuloPedido> result = db.query(ArticuloPedido.class); 
            //Carga una lista del tipo ArticuloPedido 
            for(ArticuloPedido a : result){
                lstArticulosPedido.add(a);
            }
       }
       catch(Exception ex){
           //Graba un log de errores en la DB
           DAOErrorLog.AgregarErrorLog("GetAll", "DAOArticuloPedido", ex.getMessage());
       }
       finally{
           //Cierra el archivo
           db.close();
       }
       //Devuelvo la lista cargada (o vacía en caso de excepcion)
       return lstArticulosPedido;
    }
    
    public static boolean AgregarArticuloPedido(List<ArticuloPedido> lstArticuloPedido){
        boolean flag = true;
        
        try{
            for(ArticuloPedido a : lstArticuloPedido){
                if(!AgregarArticuloPedido(a)){
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
    
//        public static List<ArticuloPedido> ImportarArticuloPedido(){
//        List<ArticuloPedido> lstArticuloPedido = new ArrayList();
//        
//        BufferedReader br = null;
//	String line = "";
//        String error = "";
//        
//        try {
//		br = new BufferedReader(new FileReader(Utiles.IMPORT_FILE_PATH_ARTICULOPEDIDO));
//		while ((line = br.readLine()) != null) {
//                        
//			String[] condicion = line.split(Utiles.CSV_SPLIT_BY);
//                        // Crea un objeto y lo agrega a la lista
//                        lstArticuloPedido.add(new ArticuloPedido(DAOPedido.GetByCodigo(Integer.parseInt(condicion[0])), 
//                                                      DAOArticulo.GetByCodigo(Integer.parseInt(condicion[1])),
//                                                      condicion[3],
//                                                      Integer.parseInt(condicion[3])));
// 
//		}
// 
//	} catch (FileNotFoundException e) {
//		error = "No se encontro el archivo: " + e.getStackTrace();
//	} catch (IOException e) {
//		error = "Error al leer el archivo: " + e.getStackTrace();
//	}catch(Exception e){
//            error = "Error al leer el archivo: " + e.getStackTrace();
//        }
//        finally {
//		if (br != null) {
//			try {
//				br.close();
//			} catch (IOException e) {
//				error = "Error al cerrar el archivo: " + e.getStackTrace().toString();
//			}
//		}
//                
//                if(error.trim() != ""){
//                    DAOErrorLog.AgregarErrorLog("ImportarArticuloPedido", "DAOArticuloPedido", error);
//                }
//                
//	}
//        return lstArticuloPedido;
//    }
}
