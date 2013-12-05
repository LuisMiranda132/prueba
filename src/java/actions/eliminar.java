/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import Clases.persona;
import DBMS.DBMS;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author luismiranda
 */
public class eliminar extends org.apache.struts.action.Action{
    
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        persona u = (persona) form;
        HttpSession session = request.getSession(true);
        
        ActionErrors error;
        
        error = u.validate(mapping, request);
        boolean huboError = false;
        
        if (error.size() != 0) {
            huboError = true;
        }
        
        if (huboError) {
            saveErrors(request, error);
            return mapping.findForward(FAILURE);
            
        } else {
            
            boolean eliminar = DBMS.getInstance().eliminarDatos(u);
            
            if (eliminar) {
                return mapping.findForward(SUCCESS);
            } else {
                return mapping.findForward(FAILURE);
            }
        }
    
    }

}