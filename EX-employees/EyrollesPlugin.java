package ex6;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;

import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.action.ActionServlet;

public class EyrollesPlugin implements PlugIn {

  public static final String PROPERTIES = "PROPERTIES";
  private String filePath=null;
  
  public String getFilePath () {
     return filePath;
 }
 public void setFilePath (String f){
     filePath=f;
 }
  public void init(ActionServlet servlet, ModuleConfig applicationConfig)
    throws javax.servlet.ServletException {

    System.out.println("---->Le plug-in démarre<----");
    Properties properties = new Properties();

    try {

      FileInputStream fis =
        new FileInputStream(getFilePath());

      properties.load(fis);

      ServletContext context = servlet.getServletContext();
      context.setAttribute(PROPERTIES, properties);

      Properties rProperties = (Properties)context.getAttribute(PROPERTIES);
      System.err.println("---->DAO " + rProperties.getProperty("DAO"));
    }
    catch (FileNotFoundException fnfe) {

      throw new ServletException(fnfe.getMessage());
    }
    catch (IOException ioe) {

      throw new ServletException(ioe.getMessage());
    }
  }

  public void destroy() {

    System.out.println("---->Le plug-in s'arrête<----");
  }
}
