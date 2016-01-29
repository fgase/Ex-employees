/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.model;

import com.myapp.struts.bean.Employe;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author David
 */
public class EmployeeManagement implements IEmployeeManagement {

    Employe employe;
    ArrayList employes = new ArrayList();
    ResultSet rs = null;
    Statement stmt = null;
    Connection conn = null;

    @Override
    public ArrayList<Employe> searchList(HttpServletRequest request) {

        try {

            Properties ress = (Properties) request.getServletContext().getAttribute("Properties");
            Class.forName(ress.getProperty("DRIVER_CLASS_NAME"));
            conn = DriverManager.getConnection(ress.getProperty("DB_CONN_STRING"), ress.getProperty("USER_NAME"), ress.getProperty("PASSWORD"));
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            rs = stmt.executeQuery("select * from employes, roles, "
                    + "services where employes.roleid=roles.roleid "
                    + "and employes.depid=services.depid");

            while (rs.next()) {

                employe = new Employe();

                employe.setUsername(rs.getString("username"));
                employe.setName(rs.getString("name"));
                employe.setRolename(rs.getString("rolename"));
                employe.setPhone(rs.getString("phone"));
                employe.setEmail(rs.getString("email"));
                employe.setRoleid((Integer) (rs.getInt("roleid")));
                employe.setDepid((Integer) (rs.getInt("depid")));
                employe.setDepartment(rs.getString("depname"));

                employes.add(employe);

                System.err.println("Username : " + employe.getUsername()
                        + " Department : " + employe.getDepartment());
            }

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        } finally {

            if (rs != null) {

                try {

                    rs.close();
                } catch (SQLException sqle) {

                    System.err.println(sqle.getMessage());
                }
            }
            if (stmt != null) {

                try {

                    stmt.close();
                } catch (SQLException sqle) {

                    System.err.println(sqle.getMessage());
                }
            }
            if (conn != null) {

                try {

                    conn.close();
                } catch (SQLException sqle) {

                    System.err.println(sqle.getMessage());
                }
            }
        }

        return employes;

    }
}
