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
 * @author henry
 */
@FacesConverter(forClass = Rol.class)
public class RolConvertidor implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            RolControlador rolControlador = new RolControlador();
            return rolControlador.encontrar(Integer.valueOf(value));
        } catch (Exception ex) {
            Logger.getLogger(RolConvertidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Rol)value).getRolIdPk().toString();
    }
    
}
