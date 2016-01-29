package com.myapp.struts.action;

import com.myapp.model.EmployeeManagement;
import com.myapp.model.IEmployeeManagement;
import com.myapp.struts.bean.Employe;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionMessage;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeListeAction extends SuperAction {

        Employe employe;
        ArrayList employes = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
    @Override
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException, ClassNotFoundException {

        // Default target to success
        String target = "success";
 IEmployeeManagement employeeManagement = (IEmployeeManagement) this.getModel((String) request.getServletContext().getAttribute("modelEmployee"));
        // Teste si l'utilisateur est identifie
        HttpSession session = request.getSession();
        if (session.getAttribute("USER") == null) {

            // The user is not logged in
            target = "login";
            ActionMessages errors = new ActionMessages();

            errors.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.login.required"));

            // Report any errors we have discovered back to
            // the original form
            if (!errors.isEmpty()) {

                saveErrors(request, errors);
            }

        }

        ArrayList employes;

        employes = employeeManagement.searchList(request);

        // Set the target to failure
        if (employes == null) {

            target = "login";
        } else {

            System.out.println("employes" + employes);
            request.setAttribute("employes", employes);
        }
        // Forward to the appropriate View
        return (mapping.findForward(target));
    }
}
