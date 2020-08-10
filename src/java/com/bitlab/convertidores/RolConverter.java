/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.convertidores;

import com.bitlab.controladores.RolControlador;
import com.bitlab.entidades.Rol;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author Aguilar
 */

// de esta manera no es necesario poner el identificador en el <p:selectOneMenu> por que automaticamente lo convierte los valores de la lista
@FacesConverter("rolConverter") 
public class RolConverter implements Converter{
    //convertidor para trabajar las lista del select en la vista usuarios (solo aplica para la listas)

    @Override // retorna el identificador de item seleccionado pero manda el string convertido en integer (el id)
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            RolControlador rolControlador = new RolControlador();
            return rolControlador.encontrar(Integer.parseInt(value));
        } catch (Exception ex) {
            Logger.getLogger(RolConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override //metodo retorna los valores de la lista de roles identificados por id (convertidos a string)
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Rol) o).getRolIdPk().toString();
    }
    
}
