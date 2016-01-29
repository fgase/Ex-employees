/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.model;

import com.myapp.struts.bean.Employe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author David
 */
public interface IEmployeeManagement {
    public ArrayList <Employe> searchList(HttpServletRequest request);
    
}
