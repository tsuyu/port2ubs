/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsuyu.port2ubs.api;

import com.tsuyu.port2ubs.constant.Constant;
import com.tsuyu.port2ubs.db.XbaseDB;
import com.tsuyu.port2ubs.db.MysqlDB;
import com.tsuyu.port2ubs.util.Util;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author tsuyu_7
 */
public class Excel {
   //debtor account first level
    public static int getMaxIncrementId() throws SQLException, ClassNotFoundException {
        int id = 0;

        Connection conn = XbaseDB.connectXbase();

        Statement stmt = conn.createStatement();

        // execute a query
        ResultSet rs = stmt.executeQuery("SELECT MAX(ENTRY) AS ENTRY FROM \""+Constant.GLPOST+"\" LIMIT 1");

        while (rs.next()) {
            id = Integer.parseInt(rs.getString("Entry"));
        }

        rs.close();

        stmt.close();

        conn.close();
        System.out.println(id);
        return id;
    }

    public void generateExcel(String department,String batchNo, String codeNo, Date from, Date to){
        
        try {
            String fromS = Util.convertDateMysql(from);
            String toS = Util.convertDateMysql(to);

            String[][] detailData = detailData(department, batchNo, codeNo, fromS, toS);
 
            HSSFWorkbook myWorkBook = new HSSFWorkbook();
            HSSFSheet mySheet = myWorkBook.createSheet();
            HSSFRow myRow = null;
            HSSFCell myCell = null;
            
            for (int rowNum = 0; rowNum < detailData.length; rowNum++) {
                myRow = mySheet.createRow(rowNum);
                for (int cellNum = 0; cellNum < 67; cellNum++) {
                    myCell = myRow.createCell(cellNum);
                    myCell.setCellValue(detailData[rowNum][cellNum]);
                }
            }
            
            FileOutputStream out = new FileOutputStream(Constant.outputExcel);
            myWorkBook.write(out);
            out.close();

            JOptionPane.showMessageDialog(null, "Excel file generate");

        } catch (Exception e) {
             System.err.println("Error:" + e);
        }

    }

    // status P or not
    public static String columnAH(String firstLevel) {
        if (Arrays.asList(Constant.FEE_ACCOUNT).contains(firstLevel)|| Arrays.asList(Constant.SHARE_ACCOUNT).contains(firstLevel)) {
            return "";
        } else if (Arrays.asList(Util.exceptYuranSaham()).contains(firstLevel)) {
            return "P";
        } else {
            return "";
        }
    }

    //column K
    public static String potonganKod(String month, String year,String accountNo) {
        
        String firstLevel = accountNo.substring(0,4);
        String tail = Util.leadingZero(Integer.parseInt(month),2) + "/" + year.substring(2, 4);
        
         //yuran
        if (Arrays.asList(Constant.FEE_ACCOUNT).contains(firstLevel) || accountNo.equals(Constant.FEE_CONTROL_ACCOUNT)) {
            return Constant.FEE_DEDUCTION + tail;
        } else if (Arrays.asList(Constant.SHARE_ACCOUNT).contains(firstLevel)|| accountNo.equals(Constant.SHARE_CONTROL_ACCOUNT)) {
            return Constant.SHARE_DEDUCTION + tail;
        } else if (Arrays.asList(Constant.ACTIVITY1_ACCOUNT).contains(firstLevel)|| accountNo.equals(Constant.ACTIVITY1_CONTROL_ACCOUNT)) {
            return Constant.ACTIVITY1_DEDUCTION + tail;
        } else if (Arrays.asList(Constant.ACTIVITY2_ACCOUNT).contains(firstLevel)|| accountNo.equals(Constant.ACTIVITY2_CONTROL_ACCOUNT)) {
            return Constant.ACTIVITY2_DEDUCTION + tail;
        } else if (Arrays.asList(Constant.ACTIVITY3_ACCOUNT).contains(firstLevel)|| accountNo.equals(Constant.ACTIVITY3_CONTROL_ACCOUNT)) {
            return Constant.ACTIVITY3_DEDUCTION3 + tail;
        } else if (Arrays.asList(Constant.ACTIVITY4_ACCOUNT).contains(firstLevel)|| accountNo.equals(Constant.ACTIVITY4_CONTROL_ACCOUNT)) {
            return Constant.ACTIVITY4_DEDUCTION + tail;
        }  else{
            return "";
        }       
    }
    
    public static String source(String accountNo)
    {
        String firstLevel = accountNo.substring(0,4);
         //yuran
        if (Arrays.asList(Constant.FEE_ACCOUNT).contains(firstLevel) || accountNo.equals(Constant.FEE_CONTROL_ACCOUNT)) {
            return Constant.SHARE_S;
        } else if (Arrays.asList(Constant.SHARE_ACCOUNT).contains(firstLevel)|| accountNo.equals(Constant.SHARE_CONTROL_ACCOUNT)) {
            return Constant.SHARE_S;
        } else if (Arrays.asList(Constant.ACTIVITY1_ACCOUNT).contains(firstLevel)|| accountNo.equals(Constant.ACTIVITY1_CONTROL_ACCOUNT)) {
            return Constant.FEE_F;
        } else if (Arrays.asList(Constant.ACTIVITY2_ACCOUNT).contains(firstLevel)|| accountNo.equals(Constant.ACTIVITY2_CONTROL_ACCOUNT)) {
            return Constant.ACTIVITY_2;
        } else if (Arrays.asList(Constant.ACTIVITY3_ACCOUNT).contains(firstLevel)|| accountNo.equals(Constant.ACTIVITY3_CONTROL_ACCOUNT)) {
            return Constant.ACTIVITY_3;
        } else if (Arrays.asList(Constant.ACTIVITY4_ACCOUNT).contains(firstLevel)|| accountNo.equals(Constant.ACTIVITY4_CONTROL_ACCOUNT)) {
            return Constant.ACTIVITY_4;
        }  else{
            return "";
        }
    }    
    //column J GD or RC
    public static String TTYPE(String firstLevel, String department) {
        //yuran atau saham GD/GC
        System.out.println(firstLevel);
        if (department.equals(Constant.FEE) || department.equals(Constant.SHARE)) {
            if (firstLevel.equals("8000")) {
                return "GD";
            } else {
                return "GC";
            }
        } else {
            if (firstLevel.equals("8000")) {
                return "GD";
            } else {
                return "RC";
            }

        }
    }
    
    //column Z
    public static String ARAPTYPE(String accountNo) {
        String firstLevel = accountNo.substring(0,4);
        if (Arrays.asList(Constant.FEE_ACCOUNT).contains(firstLevel)|| Arrays.asList(Constant.SHARE_ACCOUNT).contains(firstLevel)
                   || accountNo.equals(Constant.FEE_CONTROL_ACCOUNT)|| accountNo.equals(Constant.SHARE_CONTROL_ACCOUNT)) {
            return "Z";
        }else if (Arrays.asList(Util.exceptYuranSaham()).contains(firstLevel)) {
            return "P";
        }else{
            return "Z";
        }
    }
    
    //column T
    public static String debit(String value, String mod){
        if(mod.equals("D")){
            return value;
        }else{
            return "0";
        }
    }
    
    //column U
    public static String credit(String value, String mod){
        if(mod.equals("C")){
            return value;
        }else{
            return "0";
        }
    }
    
    public static String echoDetail(String staff_no, String department, String accountNo){
        String firstLevel = accountNo.substring(0,4);
        if(Arrays.asList(Constant.FEE_ACCOUNT).contains(firstLevel)|| Arrays.asList(Constant.SHARE_ACCOUNT).contains(firstLevel)
                   || accountNo.equals(Constant.FEE_CONTROL_ACCOUNT)|| accountNo.equals(Constant.SHARE_CONTROL_ACCOUNT)){
            return "";
        }else{
            return new Api().debtorAccountDesc(staff_no, department);
        }
    }
    
    public static String echoDetailYS(String staff_no, String department, String accountNo){
        String firstLevel = accountNo.substring(0,4);
        if(Arrays.asList(Constant.FEE_ACCOUNT).contains(firstLevel)|| Arrays.asList(Constant.SHARE_ACCOUNT).contains(firstLevel)
                   || accountNo.equals(Constant.FEE_CONTROL_ACCOUNT)|| accountNo.equals(Constant.SHARE_CONTROL_ACCOUNT)){
            return new Api().debtorAccountDesc(staff_no, department);
        }else{
            return "";
        }
    }
    
    public static String[][] detailData(String department, String batchNo,String codeNo, String fromS, String toS) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

        int n;
        
        Connection conn = MysqlDB.connectMysql();

        Statement prep = conn.createStatement();
        
        String sql = null;

        sql = new Api().switchSql(department,fromS,toS);

        ResultSet rs = prep.executeQuery(sql.trim());
        
        rs.last();
        
        n = rs.getRow()+1;
        
        String[][] excelData = new String[n][67];
        
        int i = 1;

        int incrementId = Integer.parseInt(Util.leadingZero(getMaxIncrementId(),8))+1;
      
        //Column A
        excelData[0][0] = Constant.ENTRY;
        //Column B
        excelData[0][1] = Constant.ACC_CODE;
        //Column C
        excelData[0][2] = Constant.ACCNO;
        //Column D
        excelData[0][3] = Constant.FPERIOD;
        //Column E
        excelData[0][4] = Constant.DATE;
        //Column F
        excelData[0][5] = Constant.BATCHNO;
        //Column G
        excelData[0][6] = Constant.TRANNO;
        //Column H
        excelData[0][7] = Constant.VOUC_SEQ;
        //Column I
        excelData[0][8] = Constant.VOUC_SEQ_2;
        //Column J
        excelData[0][9] = Constant.TTYPE;
        //Column K
        excelData[0][10] = Constant.REFERENCE;
        //Column L
        excelData[0][11] = Constant.REFNO;
        //Column M
        excelData[0][12] = Constant.DESP;
        //Column N
        excelData[0][13] = Constant.DESPA;
        //Column O
        excelData[0][14] = Constant.DESPB;
        //Column P
        excelData[0][15] = Constant.DESPC;
        //Column Q
        excelData[0][16] = Constant.DESPD;
        //Column R
        excelData[0][17] = Constant.DESPE;
        //Column S
        excelData[0][18] = Constant.TAXPEC;
        //Column T
        excelData[0][19] = Constant.DEBITAMT;
        //Column U
        excelData[0][20] = Constant.CREDITAMT;
        //Column V
        excelData[0][21] = Constant.FCAMT;
        //Column W
        excelData[0][22] = Constant.DEBIT_FC;
        //Column X
        excelData[0][23] = Constant.CREDIT_FC;
        //Column Y
        excelData[0][24] = Constant.EXC_RATE;
        //Column Z
        excelData[0][25] = Constant.ARAPTYPE;
        //Column AA
        excelData[0][26] = Constant.AGE;
        //Column AB
        excelData[0][27] = Constant.SOURCE;
        //Column AC
        excelData[0][28] = Constant.JOB;
        //Column AD
        excelData[0][29] = Constant.JOB2;
        //Column AE
        excelData[0][30] = Constant.SUBJOB;
        //Column AF
        excelData[0][31] = Constant.JOB_VALUE;
        //Column AG
        excelData[0][32] = Constant.JOB2_VALUE;
        //Column AH
        excelData[0][33] = Constant.POSTED;
        //Column AI
        excelData[0][34] = Constant.EXPORTED;
        //Column AJ
        excelData[0][35] = Constant.EXPORTED1;
        //Column AK
        excelData[0][36] = Constant.EXPORTED2;
        //Column AL
        excelData[0][37] = Constant.EXPORTED;
        //Column AM
        excelData[0][38] = Constant.REM1;
        //Column AN
        excelData[0][39] = Constant.REM2;
        //Column AO
        excelData[0][40] = Constant.REM3;
        //Column AP
        excelData[0][41] = Constant.REM4;
        //Column AQ
        excelData[0][42] = Constant.REM5;
        //Column AR
        excelData[0][43] = Constant.RPT_ROW;
        //Column AS
        excelData[0][44] = Constant.AGENT;
        //Column AT
        excelData[0][45] = Constant.SITE;
        //Column AU
        excelData[0][46] = Constant.STRAN;
        //Column AV
        excelData[0][47] = Constant.TAXPUR;
        //Column AW
        excelData[0][48] = Constant.PAYMODE;
        //Column AX
        excelData[0][49] = Constant.TRDATETIME;
        //Column AY
        excelData[0][50] = Constant.CORR_ACC;
        //Column AZ
        excelData[0][51] = Constant.ACCNO2;
        //Column BA
        excelData[0][52] = Constant.ACCNO3;
        //Column BB
        excelData[0][53] = Constant.DATE2;
        //Column BC
        excelData[0][54] = Constant.USERID;
        //Column BD
        excelData[0][55] = Constant.TCURRCODE;
        //Column BE
        excelData[0][56] = Constant.TCURRAMT;
        //Column BF
        excelData[0][57] = Constant.ISSUDATE;
        //Column BG
        excelData[0][58] = Constant.BPERIOD;
        //Column BH
        excelData[0][59] = Constant.BDATE;
        //Column BI
        excelData[0][60] = Constant.VPERIOD;
        //Column BJ
        excelData[0][61] = Constant.ORIGIN;
        //Column BK
        excelData[0][62] = Constant.MPERIOD;
        //Column BL
        excelData[0][63] = Constant.CREATED_BY;
        //Column BM
        excelData[0][64] = Constant.UPDATED_BY;
        //Column BN
        excelData[0][65] = Constant.CREATED_ON;
        //Column BO
        excelData[0][66] = Constant.UPDATED_ON;

        rs.beforeFirst();
                 
        while (rs.next()) {  
            
            String glChartAcc = new Api().glChartAcc(rs.getString("staff_no"),department,rs.getString("mod"));
            
            String firstLevel = new Api().firstLevel(rs.getString("staff_no"), department,rs.getString("mod")); 
            //Column A
            excelData[i][0] = Integer.toString(incrementId);
            //Column B
            excelData[i][1] = "";
            //Column C/mysql
            excelData[i][2] = glChartAcc; 
            //Column D/mysql
            excelData[i][3] = rs.getString("month"); 
            //Column E/mysql
            //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd"); 
            //Date convertedDate = dateFormat.parse("12/12/2010");
            
            excelData[i][4] = Util.convertToXbaseDate(rs.getString("cop_trx_date"));
            //Column F/user key in
            excelData[i][5] = batchNo;//BATCHNO,N,4,0
            //Column G
            excelData[i][6] = Integer.toString(i);//TRANNO,N,4,0 increment based on batch
            //Column H
            excelData[i][7] = batchNo;//VOUC_SEQ,N,4,0 same as batch no
            //Column I
            excelData[i][8] = "";//VOUC_SEQ_2,N,4,0 NO FILL
            //Column J
            excelData[i][9] = TTYPE(firstLevel,department);//TTYPE(String firstLevel)
            //Column K
            excelData[i][10] = codeNo;//helmi key in//potonganKod(String month, String year,String accountNo)
            //Column L
            excelData[i][11] = "";
            //Column M
            excelData[i][12] = new Api().debtorAccountDescMod(rs.getString("staff_no"), department,rs.getString("mod"));//gl_chart_des
            //Column N
            excelData[i][13] = new Api().icNo(rs.getString("cop_mbr_ic"), rs.getString("mod"));//cop_mbr_ic
            //Column O
            excelData[i][14] = "";
            //Column P
            excelData[i][15] = "";
            //Column Q
            excelData[i][16] = "";
            //Column R
            excelData[i][17] = "";//DESPE,C,40
            //Column S
            excelData[i][18] = "0";
            //Column T
            excelData[i][19] = Util.convertToDbfDouble(debit(rs.getString("cop_lgr_amt"),rs.getString("mod")));
            //Column U
            excelData[i][20] = Util.convertToDbfDouble(credit(rs.getString("cop_lgr_amt"),rs.getString("mod")));
            //Column V
            excelData[i][21] = "0";
            //Column W
            excelData[i][22] = "0";
            //Column X
            excelData[i][23] = "0";
            //Column Y
            excelData[i][24] = "0";
            //Column Z
            excelData[i][25] = ARAPTYPE(glChartAcc);//ARAPTYPE,C,1 P/Z
            //Column AA
            excelData[i][26] = "11";
            //Column AB
            /* 01 MESRA MINIMARKET
             * 02 KOSPEK DUA
             * 03 KOSPEK TIGA
             * 04 PERBELANJAAN PENTADBIRAN & KEWANGAN
             * 05 KOSPEK TRADING
             * 06 KOSPEK EMPAT
             */
            excelData[i][27] = source(glChartAcc);//SOURCE,C,4
            //Column AC
            excelData[i][28] = "";
            //Column AD
            excelData[i][29] = "";
            //Column AE
            excelData[i][30] = "";
            //Column AF
            excelData[i][31] = "0";
            //Column AG
            excelData[i][32] = "0";
            //Column AH
            excelData[i][33] = columnAH(firstLevel);//POSTED,C,1 P for potongan and empty for debtor
            //Column AI
            excelData[i][34] = "";
            //Column AJ
            excelData[i][35] = "";
            //Column AK
            excelData[i][36] = "";
            //Column AL
            excelData[i][37] = "";
            //Column AM
            excelData[i][38] = "";
            //Column AN
            excelData[i][39] = echoDetailYS(rs.getString("staff_no"), department,glChartAcc) +" "+rs.getString("cop_mbr_ic");//REM2,C,100
            //Column AO
            /*kospek 4 - ada description debtor account
             *kospek 2 bainah - ada description debtor account
             *kospek 2 barangan - ada description debtor account
             *kospek 1 - ada description debtor account
             *kecemasan - ada description debtor account
             *yuran - tak ada
             *saham - tak ada 
             */
            excelData[i][40] = echoDetail(rs.getString("staff_no"), department,glChartAcc);//REM3,C,100
            //Column AP
            excelData[i][41] = "";
            //Column AQ
            excelData[i][42] = "0";
            //Column AR
            excelData[i][43] = "0";
            //Column AS
            excelData[i][44] = "";
            //Column AT
            excelData[i][45] = "";
            //Column AU
            excelData[i][46] = "";
            //Column AV
            excelData[i][47] = "0";
            //Column AW
            excelData[i][48] = "";
            //Column AX
            excelData[i][49] = "";//Util.createByDate();
            //Column AY
            excelData[i][50] = glChartAcc; 
            //Column AZ
            excelData[i][51] = "";
            //Column BA
            excelData[i][52] = "";
            //Column BB
            excelData[i][53] = "";
            //Column BC
            excelData[i][54] = "PIN_0";
            //Column BD
            excelData[i][55] = "";
            //Column BE
            excelData[i][56] = "0";
            //Column BF
            excelData[i][57] = "";
            //Column BG
            excelData[i][58] = rs.getString("month");
            //Column BH
            excelData[i][59] = Util.convertToXbaseDate(rs.getString("cop_trx_date"));
            //Column BI
            excelData[i][60] = rs.getString("month");
            //Column BJ
            excelData[i][61] = "UACC";
            //Column BK
            excelData[i][62] = rs.getString("month");//cop_tmp_lgr_prd
            //Column BL
            excelData[i][63] = "PIN_0";
            //Column BM
            excelData[i][64] = "PIN_0";
            //Column BN
            excelData[i][65] = ""; //Util.createByDate();
            //Column BO
            excelData[i][66] = "";//Util.createByDate();
            i++;
            incrementId++;
          }
        
        return excelData;
    }
    
    /*public static void main(String[] args) throws SQLException, ClassNotFoundException{
        System.out.println(getMaxIncrementId());
    }*/
}
