/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 * Clase para manejar errores.
 * @author m_pau_000
 */
public class ErrorLog {
    private String metodo;
    private String clase;
    private String mensaje;

    public ErrorLog(String metodo, String entidad, String mensaje) {
        this.metodo = metodo;
        this.clase = entidad;
        this.mensaje = mensaje;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getEntidad() {
        return clase;
    }

    public void setEntidad(String entidad) {
        this.clase = entidad;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
