/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utiles;

/**
 *
 * @author m_pau_000
 */
public final class Utiles {
    //Ruta del archivo de la DB
    public static final String DB_FILE_PATH = System.getProperty("user.dir") + "\\src\\Data\\TomaPedidosDB";
    //Ruta del archivo de importación
    public static final String IMPORT_FILE_PATH_ARTICULOS = System.getProperty("user.dir") + "\\src\\Data\\Articulos.csv";
    //Ruta del log de errores
    public static final String ERRORLOG_FILE_PATH = System.getProperty("user.dir") + "\\src\\Data\\ErrorLog.txt";
    //Caracter separador del CSV
    public static final String CSV_SPLIT_BY = ",";
}
