/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kospek.port2ubs.db;

import com.kospek.port2ubs.constant.Constant;
import com.mysql.jdbc.Connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author tsuyu_7
 */
public class MysqlDB {

    private static Properties prop;
    private static StringBuilder url;
    private static Connection connection = null;

    public static Connection connectMysql() throws FileNotFoundException, IOException{

        FileInputStream in = new FileInputStream(Constant.mySqlPath);

        prop = new Properties();
        prop.loadFromXML(in);

        url = new StringBuilder();
        url.append("jdbc:mysql://");
        url.append(prop.getProperty("HOST"));
        url.append(":");
        url.append(prop.getProperty("PORT"));
        url.append("/");
        url.append(prop.getProperty("DATABASE"));
        // com.mysql.jdbc.Driver
        //jdbc:mysql://localhost/mybankdb?user=root&password=123456

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Where is your MySQL JDBC Driver!!!", "Port2UBS",
                    JOptionPane.ERROR_MESSAGE);
        }

        try {
            connection = (Connection) DriverManager.getConnection(url.toString(),
                    prop.getProperty("USER"), prop.getProperty("PASSWORD"));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Port2UBS",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (connection != null) {
		return connection;
	} else {
                return null;
	}
       
    }
}
