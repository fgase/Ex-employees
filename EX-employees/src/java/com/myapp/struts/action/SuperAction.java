/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.action;

import com.myapp.model.IEmployeeManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.Action;

/**
 *
 * @author David
 */
public class SuperAction extends Action {

    // retourne connexion is better
// avoir une fonction qui ferme co
   
    
    
    public IEmployeeManagement getModel(String model) {
        Factory f = new Factory();
        IEmployeeManagement employeeModel = (IEmployeeManagement) f.instantiate(model);
        return employeeModel;
    }
    
}
