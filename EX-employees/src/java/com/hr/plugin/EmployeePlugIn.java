/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.plugin;

import java.util.Properties;
import javax.servlet.ServletException;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

/**
 *
 * @author David
 */
public class EmployeePlugIn implements PlugIn {

    String DB_CONN_STRING;
    String DRIVER_CLASS_NAME;
    String USER_NAME;
    String PASSWORD;
    String modelEmployee;


    public String getDB_CONN_STRING() {
        return DB_CONN_STRING;
    }

    public void setDB_CONN_STRING(String DB_CONN_STRING) {
        this.DB_CONN_STRING = DB_CONN_STRING;
    }

    public String getDRIVER_CLASS_NAME() {
        return DRIVER_CLASS_NAME;
    }

    public void setDRIVER_CLASS_NAME(String DRIVER_CLASS_NAME) {
        this.DRIVER_CLASS_NAME = DRIVER_CLASS_NAME;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("model cache plugIn destroyed.");
    }

    public String getModelEmployee() {
        return modelEmployee;
    }

    public void setModelEmployee(String modelEmployee) {
        this.modelEmployee = modelEmployee;
    }

    
    

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
/*
        //nom doivent être pareils
        servlet.getServletContext().setAttribute("DB_CONN_STRING", this.getDB_CONN_STRING());
        servlet.getServletContext().setAttribute("DRIVER_CLASS_NAME", this.getDRIVER_CLASS_NAME());
        servlet.getServletContext().setAttribute("USER_NAME", this.getUSER_NAME());
        servlet.getServletContext().setAttribute("PASSWORD", this.getPASSWORD());
        */
        Properties properties = new Properties();
        properties.setProperty("DB_CONN_STRING", this.getDB_CONN_STRING());
        properties.setProperty("DRIVER_CLASS_NAME", this.getDRIVER_CLASS_NAME());
        properties.setProperty("USER_NAME", this.getUSER_NAME());
        properties.setProperty("PASSWORD", this.getPASSWORD());
        
        servlet.getServletContext().setAttribute("modelEmployee", this.getModelEmployee());
         servlet.getServletContext().setAttribute("Properties", properties);
        System.out.println("model Cache plugIn created");
    }

}
