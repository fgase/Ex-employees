/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author carine
 */
public class factory {
    
    public static Object newInstance (String name) throws ClassNotFoundException,
                                            InstantiationException,IllegalAccessException {
        Class t = Class.forName(name);
        return t.newInstance();
    }
    
}
