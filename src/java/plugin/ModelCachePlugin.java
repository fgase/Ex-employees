/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugin;

import javax.servlet.ServletException;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

/**
 *
 * @author flo
 */
public class ModelCachePlugin implements PlugIn {
    private String modelEmployee;
   
    public String getModelEmployee() {
        return modelEmployee;
    }

    public void setModelEmployee(String modelEmployee) {
        this.modelEmployee = modelEmployee;
    }

    @Override
    public void destroy() {
        System.out.println("ModelCachePlugIn Destroyed");
    }

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        servlet.getServletContext().setAttribute("modelEmployee", this.modelEmployee);
        System.out.println("ModelCachePlugIn Created");
    }
}