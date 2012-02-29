/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsuyu.port2ubs.api;

import com.tsuyu.port2ubs.constant.Constant;
import com.tsuyu.port2ubs.db.MysqlDB;
import com.tsuyu.port2ubs.util.Util;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author tsuyu_7
 */
public class Api {

    private String[][] data;
    private int n;
    private double total;
    private String field;

    public String switchSql(String department, String fromS, String toS) {
        String sql = null;

        if (department.equals(Constant.FEE)) {
            
            sql = "SELECT cop_mbr_ic,staff_no,cop_lgr_amt, `month`, `year`,`mod`,`cop_trx_date` FROM("
                    + " SELECT staff_ic AS cop_mbr_ic,staff_no,fee_figure AS cop_lgr_amt,period AS month, year,'D' AS `mod`,"
                    + " `cop_trx_date` FROM virtual_transaction"
                    + " WHERE `cop_trx_date` BETWEEN '" + fromS + "' AND '" + toS + "' "
                    + " UNION"
                    + " SELECT staff_ic AS cop_mbr_ic,staff_no,fee_figure AS cop_lgr_amt,period AS month, year,'C' AS `mod`,"
                    + " `cop_trx_date` FROM virtual_transaction"
                    + " WHERE `cop_trx_date` BETWEEN '" + fromS + "' AND '" + toS + "'"
                    + ") AS alias  WHERE cop_lgr_amt != 0 ORDER BY `staff_no`,`mod` DESC";
            System.out.println(sql);
            return sql;

        } else if (department.equals(Constant.SHARE)) {

            sql = "SELECT cop_mbr_ic,staff_no,cop_lgr_amt, `month`, `year`,`mod`,`cop_trx_date` FROM("
                    + " SELECT staff_ic AS cop_mbr_ic,staff_no,saham_figure AS cop_lgr_amt,period AS month, year,'D' AS `mod`,"
                    + " `cop_trx_date` FROM virtual_transaction"
                    + " WHERE `cop_trx_date` BETWEEN '" + fromS + "' AND '" + toS + "' "
                    + " UNION"
                    + " SELECT staff_ic AS cop_mbr_ic,staff_no,saham_figure AS cop_lgr_amt,period AS month, year,'C' AS `mod`,"
                    + " `cop_trx_date` FROM virtual_transaction"
                    + " WHERE `cop_trx_date` BETWEEN '" + fromS + "' AND '" + toS + "'"
                    + ") AS alias  WHERE cop_lgr_amt != 0 ORDER BY `staff_no`,`mod` DESC";
            System.out.println(sql);
            return sql;
        } else if (department.equals(Constant.ACTIVITY1)) {

            sql = "SELECT cop_mbr_ic,staff_no,cop_lgr_amt, `month`, `year`,`mod`,`cop_trx_date` FROM("
                    + " SELECT staff_ic AS cop_mbr_ic,staff_no,activity_1 AS cop_lgr_amt,period AS month, year,'D' AS `mod`,"
                    + " `cop_trx_date` FROM virtual_transaction"
                    + " WHERE `cop_trx_date` BETWEEN '" + fromS + "' AND '" + toS + "' "
                    + " UNION"
                    + " SELECT staff_ic AS cop_mbr_ic,staff_no,activity_1 AS cop_lgr_amt,period AS month, year,'C' AS `mod`,"
                    + " `cop_trx_date` FROM virtual_transaction"
                    + " WHERE `cop_trx_date` BETWEEN '" + fromS + "' AND '" + toS + "'"
                    + ") AS alias  WHERE cop_lgr_amt != 0 ORDER BY `staff_no`,`mod` DESC";
            System.out.println(sql);
            return sql;

        } else if (department.equals(Constant.ACTIVITY2)) {

            sql = "SELECT cop_mbr_ic,staff_no,cop_lgr_amt, `month`, `year`,`mod`,`cop_trx_date` FROM("
                    + " SELECT staff_ic AS cop_mbr_ic,staff_no,activity_2 AS cop_lgr_amt,period AS month, year,'D' AS `mod`,"
                    + " `cop_trx_date` FROM virtual_transaction"
                    + " WHERE `cop_trx_date` BETWEEN '" + fromS + "' AND '" + toS + "' "
                    + " UNION"
                    + " SELECT staff_ic AS cop_mbr_ic,staff_no,activity_2 AS cop_lgr_amt,period AS month, year,'C' AS `mod`,"
                    + " `cop_trx_date` from virtual_transaction"
                    + " WHERE `cop_trx_date` BETWEEN '" + fromS + "' AND '" + toS + "'"
                    + ") AS alias  WHERE cop_lgr_amt != 0 ORDER BY `staff_no`,`mod` DESC";
            System.out.println(sql);
            return sql;
        } else if (department.equals(Constant.ACTIVITY3)) {

            sql = "SELECT cop_mbr_ic,staff_no,cop_lgr_amt, `month`, `year`,`mod`,`cop_trx_date` FROM("
                    + " SELECT staff_ic AS cop_mbr_ic,staff_no,activity_3 AS cop_lgr_amt,period AS month, year,'D' AS `mod`,"
                    + " `cop_trx_date` FROM virtual_transaction"
                    + " WHERE `cop_trx_date` BETWEEN '" + fromS + "' AND '" + toS + "' "
                    + " UNION"
                    + " SELECT staff_ic AS cop_mbr_ic,staff_no,activity_3 AS cop_lgr_amt,period AS month, year,'C' AS `mod`,"
                    + " `cop_trx_date` FROM virtual_transaction"
                    + " WHERE `cop_trx_date` BETWEEN '" + fromS + "' AND '" + toS + "'"
                    + ") AS alias  WHERE cop_lgr_amt != 0 ORDER BY `staff_no`,`mod` DESC";
            System.out.println(sql);
            return sql;
        } else if (department.equals(Constant.ACTIVITY4)) {

            sql = "SELECT cop_mbr_ic,staff_no,cop_lgr_amt, `month`, `year`,`mod`,`cop_trx_date` FROM("
                    + " SELECT staff_ic AS cop_mbr_ic,staff_no,activity_4 AS cop_lgr_amt,period AS month, year,'D' AS `mod`,"
                    + " `cop_trx_date` FROM virtual_transaction"
                    + " WHERE `cop_trx_date` BETWEEN '" + fromS + "' AND '" + toS + "' "
                    + " UNION"
                    + " SELECT staff_ic AS cop_mbr_ic,staff_no,activity_4 AS cop_lgr_amt,period AS month, year,'C' AS `mod`,"
                    + " `cop_trx_date` FROM virtual_transaction"
                    + " WHERE `cop_trx_date` BETWEEN '" + fromS + "' AND '" + toS + "'"
                    + ") AS alias  WHERE cop_lgr_amt != 0 ORDER BY `staff_no`,`mod` DESC";
            System.out.println(sql);
            return sql;
        } else {
            return "";
        }
    }

    public static java.lang.String debtorAccount(String staff_no, String department) {

        java.lang.String[] sql = new java.lang.String[2];

        sql[0] = "SELECT `gl_chart_des` FROM `gl_chart` WHERE `staff_no` = '" + staff_no + "' AND first_level IN";

        if (department.equals(Constant.FEE)) {
            sql[1] = "('" + Constant.FEE_ACCOUNT[0] + "','" + Constant.FEE_ACCOUNT[1] + "','" + Constant.FEE_ACCOUNT[2] + "',"
                    + "'" + Constant.FEE_ACCOUNT[3] + "','" + Constant.FEE_ACCOUNT[4] + "','" + Constant.FEE_ACCOUNT[5] + "') LIMIT 1";
        } else if (department.equals(Constant.SHARE)) {
            sql[1] = "('" + Constant.SHARE_ACCOUNT[0] + "','" + Constant.SHARE_ACCOUNT[1] + "','" + Constant.SHARE_ACCOUNT[2] + "',"
                    + "'" + Constant.SHARE_ACCOUNT[3] + "','" + Constant.SHARE_ACCOUNT[4] + "','" + Constant.SHARE_ACCOUNT[5] + "') LIMIT 1";
        } else if (department.equals(Constant.ACTIVITY1)) {
            sql[1] = "('" + Constant.ACTIVITY1_ACCOUNT[0] + "','" + Constant.ACTIVITY1_ACCOUNT[1] + "','" + Constant.ACTIVITY1_ACCOUNT[2] + "',"
                    + "'" + Constant.ACTIVITY1_ACCOUNT[3] + "','" + Constant.ACTIVITY1_ACCOUNT[4] + "','" + Constant.ACTIVITY1_ACCOUNT[5] + "') LIMIT 1";
        } else if (department.equals(Constant.ACTIVITY2)) {
            sql[1] = "('" + Constant.ACTIVITY2_ACCOUNT[0] + "','" + Constant.ACTIVITY2_ACCOUNT[1] + "','" + Constant.ACTIVITY2_ACCOUNT[2] + "',"
                    + "'" + Constant.ACTIVITY2_ACCOUNT[3] + "','" + Constant.ACTIVITY2_ACCOUNT[4] + "','" + Constant.ACTIVITY2_ACCOUNT[5] + "') LIMIT 1";
        } else if (department.equals(Constant.ACTIVITY3)) {
            sql[1] = "('" + Constant.ACTIVITY3_ACCOUNT[0] + "','" + Constant.ACTIVITY3_ACCOUNT[1] + "') LIMIT 1";
        } else if (department.equals(Constant.ACTIVITY4)) {
            sql[1] = "('" + Constant.ACTIVITY4_ACCOUNT[0] + "','" + Constant.ACTIVITY4_ACCOUNT[1] + "','" + Constant.ACTIVITY4_ACCOUNT[2] + "','" + Constant.ACTIVITY4_ACCOUNT[3] + "') LIMIT 1";
        }
        return sql[0] + sql[1];
    }

    public String debtorAccountDesc(String staff_no, String department) {
        String debtorAccount = "";
        try {
            Connection conn = MysqlDB.connectMysql();
            Statement prep = (Statement) conn.createStatement();

            String sql = null;

            sql = debtorAccount(staff_no, department);

            ResultSet rs = prep.executeQuery(sql.trim());

            while (rs.next()) {
                debtorAccount = rs.getString("gl_chart_des");
            }

            conn.close();

        } catch (Exception DBExeption) {
            JOptionPane.showMessageDialog(null, DBExeption, "Port2UBS",
                    JOptionPane.ERROR_MESSAGE);
        }
        // System.out.println(debtorAccount);
        return debtorAccount;
    }

    public String glChartAcc(String staff_no, String department, String Mod) {
        if (Mod.equals("C")) {
            String debtorAccount = "";
            String[] sql = new String[2];

            sql[0] = "SELECT gl_chart_acc FROM gl_chart WHERE gl_chart.staff_no = '" + staff_no + "' AND ";

            try {
                Connection conn = MysqlDB.connectMysql();
                Statement prep = (Statement) conn.createStatement();

                if (department.equals(Constant.FEE)) {
                    sql[1] = "first_level IN('" + Constant.FEE_ACCOUNT[0] + "','" + Constant.FEE_ACCOUNT[1] + "','" + Constant.FEE_ACCOUNT[2] + "',"
                            + "'" + Constant.FEE_ACCOUNT[3] + "','" + Constant.FEE_ACCOUNT[4] + "','" + Constant.FEE_ACCOUNT[5] + "') LIMIT 1";
                } else if (department.equals(Constant.SHARE)) {
                    sql[1] = "first_level IN('" + Constant.SHARE_ACCOUNT[0] + "','" + Constant.SHARE_ACCOUNT[1] + "','" + Constant.SHARE_ACCOUNT[2] + "',"
                            + "'" + Constant.SHARE_ACCOUNT[3] + "','" + Constant.SHARE_ACCOUNT[4] + "','" + Constant.SHARE_ACCOUNT[5] + "') LIMIT 1";
                } else if (department.equals(Constant.ACTIVITY1)) {
                    sql[1] = "first_level IN('" + Constant.ACTIVITY1_ACCOUNT[0] + "','" + Constant.ACTIVITY1_ACCOUNT[1] + "','" + Constant.ACTIVITY1_ACCOUNT[2] + "',"
                            + "'" + Constant.ACTIVITY1_ACCOUNT[3] + "','" + Constant.ACTIVITY1_ACCOUNT[4] + "','" + Constant.ACTIVITY1_ACCOUNT[5] + "') LIMIT 1";
                } else if (department.equals(Constant.ACTIVITY2)) {
                    sql[1] = "first_level IN('" + Constant.ACTIVITY2_ACCOUNT[0] + "','" + Constant.ACTIVITY2_ACCOUNT[1] + "','" + Constant.ACTIVITY2_ACCOUNT[2] + "',"
                            + "'" + Constant.ACTIVITY2_ACCOUNT[3] + "','" + Constant.ACTIVITY2_ACCOUNT[4] + "','" + Constant.ACTIVITY2_ACCOUNT[5] + "') LIMIT 1";
                } else if (department.equals(Constant.ACTIVITY3)) {
                    sql[1] = "first_level IN('" + Constant.ACTIVITY3_ACCOUNT[0] + "','" + Constant.ACTIVITY3_ACCOUNT[1] + "') LIMIT 1";
                } else if (department.equals(Constant.ACTIVITY4)) {
                    sql[1] = "first_level IN('" + Constant.ACTIVITY4_ACCOUNT[0] + "','" + Constant.ACTIVITY4_ACCOUNT[1] + "','" + Constant.ACTIVITY4_ACCOUNT[2] + "','" + Constant.ACTIVITY4_ACCOUNT[3] + "') LIMIT 1";
                }

                ResultSet rs = prep.executeQuery(sql[0] + sql[1].trim());

                while (rs.next()) {
                    debtorAccount = rs.getString("gl_chart_acc");
                }

                conn.close();

            } catch (Exception DBExeption) {
                JOptionPane.showMessageDialog(null, DBExeption, "Port2UBS",
                        JOptionPane.ERROR_MESSAGE);
            }
            System.out.println(staff_no + " : " + debtorAccount);
            return debtorAccount;

        } else {
            if (department.equals(Constant.FEE)) {
                return Constant.FEE_CONTROL_ACCOUNT;
            } else if (department.equals(Constant.SHARE)) {
                return Constant.SHARE_CONTROL_ACCOUNT;
            } else if (department.equals(Constant.ACTIVITY1)) {
                return Constant.ACTIVITY1_CONTROL_ACCOUNT;
            } else if (department.equals(Constant.ACTIVITY2)) {
                return Constant.ACTIVITY2_CONTROL_ACCOUNT;
            } else if (department.equals(Constant.ACTIVITY3)) {
                return Constant.ACTIVITY3_CONTROL_ACCOUNT;
            } else if (department.equals(Constant.ACTIVITY4)) {
                return Constant.ACTIVITY4_CONTROL_ACCOUNT;
            } else {
                return "";
            }
        }
    }

    public String firstLevel(String staff_no, String department, String Mod) {
        if (Mod.equals("C")) {

            String debtorAccount = "";
            try {
                Connection conn = MysqlDB.connectMysql();
                Statement prep = (Statement) conn.createStatement();

                String[] sql = new String[2];

                sql[0] = "SELECT first_level FROM gl_chart WHERE gl_chart.staff_no = '" + staff_no + "' AND ";

                if (department.equals(Constant.FEE)) {
                    sql[1] = "first_level IN('" + Constant.FEE_ACCOUNT[0] + "','" + Constant.FEE_ACCOUNT[1] + "','" + Constant.FEE_ACCOUNT[2] + "',"
                            + "'" + Constant.FEE_ACCOUNT[3] + "','" + Constant.FEE_ACCOUNT[4] + "','" + Constant.FEE_ACCOUNT[5] + "') LIMIT 1";
                } else if (department.equals(Constant.SHARE)) {
                    sql[1] = "first_level IN('" + Constant.SHARE_ACCOUNT[0] + "','" + Constant.SHARE_ACCOUNT[1] + "','" + Constant.SHARE_ACCOUNT[2] + "',"
                            + "'" + Constant.SHARE_ACCOUNT[3] + "','" + Constant.SHARE_ACCOUNT[4] + "','" + Constant.SHARE_ACCOUNT[5] + "') LIMIT 1";
                } else if (department.equals(Constant.ACTIVITY1)) {
                    sql[1] = "first_level IN('" + Constant.ACTIVITY1_ACCOUNT[0] + "','" + Constant.ACTIVITY1_ACCOUNT[1] + "','" + Constant.ACTIVITY1_ACCOUNT[2] + "',"
                            + "'" + Constant.ACTIVITY1_ACCOUNT[3] + "','" + Constant.ACTIVITY1_ACCOUNT[4] + "','" + Constant.ACTIVITY1_ACCOUNT[5] + "') LIMIT 1";
                } else if (department.equals(Constant.ACTIVITY2)) {
                    sql[1] = "first_level IN('" + Constant.ACTIVITY2_ACCOUNT[0] + "','" + Constant.ACTIVITY2_ACCOUNT[1] + "','" + Constant.ACTIVITY2_ACCOUNT[2] + "',"
                            + "'" + Constant.ACTIVITY2_ACCOUNT[3] + "','" + Constant.ACTIVITY2_ACCOUNT[4] + "','" + Constant.ACTIVITY2_ACCOUNT[5] + "') LIMIT 1";
                } else if (department.equals(Constant.ACTIVITY3)) {
                    sql[1] = "first_level IN('" + Constant.ACTIVITY3_ACCOUNT[0] + "','" + Constant.ACTIVITY3_ACCOUNT[1] + "') LIMIT 1";
                } else if (department.equals(Constant.ACTIVITY4)) {
                    sql[1] = "first_level IN('" + Constant.ACTIVITY4_ACCOUNT[0] + "','" + Constant.ACTIVITY4_ACCOUNT[1] + "','" + Constant.ACTIVITY4_ACCOUNT[2] + "','" + Constant.ACTIVITY4_ACCOUNT[3] + "') LIMIT 1";
                }

                ResultSet rs = prep.executeQuery(sql[0] + sql[1].trim());

                while (rs.next()) {
                    debtorAccount = rs.getString("first_level");
                }

                conn.close();

            } catch (Exception DBExeption) {

                JOptionPane.showMessageDialog(null, DBExeption, "Port2UBS",
                        JOptionPane.ERROR_MESSAGE);
            }
            // System.out.println(debtorAccount);
            return debtorAccount;
        } else {
            return "8000";
        }
    }

    public String icNo(String ic, String Mods) {
        if (Mods.equals("D")) {
            return ic;
        } else if (Mods.equals("C")) {
            return "";
        } else {
            return "";
        }
    }

    public String debtorAccountDescMod(String staff_no, String department, String Mods) {
        String debtorDesc = "";
        //System.out.println(staff_no);
        if (Mods.equals("D")) {

            try {
                Connection conn = MysqlDB.connectMysql();
                Statement prep = (Statement) conn.createStatement();

                String sql = null;

                sql = debtorAccount(staff_no, department);

                ResultSet rs = prep.executeQuery(sql.trim());

                while (rs.next()) {
                    debtorDesc = rs.getString("gl_chart_des");
                }

                conn.close();

            } catch (Exception DBExeption) {
                JOptionPane.showMessageDialog(null, DBExeption, "Port2UBS",
                        JOptionPane.ERROR_MESSAGE);
            }
            // System.out.println(debtorAccount);
            return debtorDesc;
        } else if (Mods.equals("C")) {

            if (department.equals(Constant.FEE)) {
                return "MEMBER FEE DEDUCTION";
            } else if (department.equals(Constant.SHARE)) {
                return "MEMBER SHARE DEDUCTION";
            } else if (department.equals(Constant.ACTIVITY1)) {
                return "ACTIVITY 1 DEDUCTION";
            } else if (department.equals(Constant.ACTIVITY2)) {
                return "ACTIVITY 2 DEDUCTION";
            } else if (department.equals(Constant.ACTIVITY3)) {
                return "ACTIVITY 3 DEDUCTION";
            } else if (department.equals(Constant.ACTIVITY4)) {
                return "ACTIVITY 4 DEDUCTION";
            } else {
                return "";
            }

        } else {
            return "";
        }
    }

    /* public static void main(String args[]){
    System.out.print(new Api().debtorAccountDescMod("1234", "fee","C"));
    }*/
    public String[][] data(String department, Date from, Date to) {
        try {
            System.out.println(department);
            Connection conn = MysqlDB.connectMysql();
            Statement prep = (Statement) conn.createStatement();
            // JOptionPane.showMessageDialog(null, toS);

            String sql = switchSql(department, Util.convertDateMysql(from), Util.convertDateMysql(to));

            ResultSet rs = prep.executeQuery(sql.trim());

            rs.last();
            n = rs.getRow();
            data = new String[n][8];
            int p = 0;
            int no = 1;
            rs.beforeFirst();

            while (rs.next()) {
                data[p][0] = Integer.toString(no);
                data[p][1] = Util.leadingZero(Integer.parseInt(rs.getString("staff_no")), 4);
                data[p][2] = new Api().glChartAcc(rs.getString("staff_no"), department, rs.getString("mod"));
                data[p][3] = new Api().debtorAccountDescMod(rs.getString("staff_no"), department, rs.getString("mod"));
                data[p][4] = rs.getString("cop_lgr_amt");
                data[p][5] = rs.getString("month");
                data[p][6] = rs.getString("year");
                data[p][7] = rs.getString("mod");
                p++;
                no++;
            }

            conn.close();

        } catch (Exception DBExeption) {
            JOptionPane.showMessageDialog(null, DBExeption, "Port2UBS",
                    JOptionPane.ERROR_MESSAGE);
        }

        if (data.length == 0) {
            return new String[0][0];
        } else {
            return data;
        }
    }

    public Double totalAmount(String department, Date from, Date to) {

        try {
            Connection conn = MysqlDB.connectMysql();
            Statement prep = (Statement) conn.createStatement();
            if (department.equals(Constant.FEE)) {
                field = "fee_figure";
            } else if (department.equals(Constant.SHARE)) {
                field = "share_figure";
            } else if (department.equals(Constant.ACTIVITY1)) {
                field = "activity_1";
            } else if (department.equals(Constant.ACTIVITY2)) {
                field = "activity_2";
            } else if (department.equals(Constant.ACTIVITY3)) {
                field = "activity_3";
            } else if (department.equals(Constant.ACTIVITY4)) {
                field = "activity_4";
            }

            String sql = "SELECT SUM(`" + field + "`) AS sum FROM virtual_transaction WHERE `cop_trx_date` BETWEEN '" + Util.convertDateMysql(from) + "' AND '" + Util.convertDateMysql(to) + "' LIMIT 1";
            //System.out.println(sql);
            ResultSet rs = prep.executeQuery(sql.trim());

            while (rs.next()) {
                total = rs.getDouble("sum");
            }

            conn.close();

        } catch (Exception DBExeption) {
            JOptionPane.showMessageDialog(null, DBExeption, "Port2UBS",
                    JOptionPane.ERROR_MESSAGE);
        }

        if (total == 0) {
            return 0.00;
        } else {
            return total;
        }
    }
}
