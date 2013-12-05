/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author luismiranda
 */
public class persona extends org.apache.struts.action.ActionForm{
    
    
    private Integer codigo;
    private String nombre;

    @Override
    public String toString(){
        return "persona{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
//        
//        Por los momentos, esto es ignorable pero igual coloquenlo.
//        
//        if () {
//            errors.add("<nombre>", new ActionMessage("<actionDeclarado>"));
//            // TODO: add '<actionDeclarado>' key to your resources
//        }
//        
        return errors;
    }

}
