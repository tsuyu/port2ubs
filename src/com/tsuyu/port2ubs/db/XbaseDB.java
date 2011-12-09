/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kospek.port2ubs.db;

import com.kospek.port2ubs.constant.Constant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tsuyu_7
 */
public class XbaseDB {
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    public static Connection connectXbase() throws ClassNotFoundException,
            SQLException {
        // Instantiate the name of class
        Class.forName("jstels.jdbc.dbf.DBFDriver2");

        return (Connection) DriverManager.getConnection("jdbc:jstels:dbf:" + Constant.xBasePath);
    }
}
