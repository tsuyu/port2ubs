/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsuyu.port2ubs.api;

import com.tsuyu.port2ubs.constant.Constant;
import com.tsuyu.port2ubs.db.XbaseDB;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author tsuyu_7
 */
public class Dbf {

    public void ubsPort() {
        try {
            Connection conn = XbaseDB.connectXbase();

            Statement stmt = conn.createStatement();

            stmt.execute("INSERT INTO \""+Constant.GLPOST+"\" SELECT * FROM \""+Constant.PORT+"\"");
            //stmt.execute("INSERT INTO \""+Constant.GLPOST+"\" (UPDATED_ON) VALUES (PARSEDATETIME('01/12/11 08:35 AM','MM/DD/YY HH:MM AM/PM')");
            stmt.close();

            conn.close();

        } catch (Exception DBExeption) {
             System.err.println("Error:" + DBExeption);
        }

    }
}
