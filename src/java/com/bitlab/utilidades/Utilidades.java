/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.utilidades;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author henry
 */
public class Utilidades {
    public static void lanzarMensaje(FacesMessage.Severity severidad, String titulo, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidad, titulo, detalle));
    }

    public static void redireccionar(String pagina){
        ExternalContext contexto = FacesContext.getCurrentInstance().getExternalContext();
        try{
            contexto.redirect(contexto.getRequestContextPath() + "/"+pagina + ".bitlab");
        }catch(IOException ex){
            ex.getMessage();
        }
    }
}
