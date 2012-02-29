/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsuyu.port2ubs.constant;

/**
 *
 * @author tsuyu_7
 */
public interface Constant {

    public static final String GLPOST = "glpost.dbf";
    public static final String PORT = "port.dbf";
    public static final String xBasePath = "C:\\port2ubs\\DATA";
    public static final String portDB = "C:\\port2ubs\\DATA\\port.dbf";
    public static final String outputExcel = "C:\\port2ubs\\DATA\\port.xls";
    public static final String mySqlPath = "C:\\port2ubs\\Port2UBS\\database.xml";
    public static final String ENTRY = "ENTRY,C,8";
    public static final String ACC_CODE = "ACC_CODE,C,15";
    public static final String ACCNO = "ACCNO,C,12";
    public static final String FPERIOD = "FPERIOD,N,2,0";
    public static final String DATE = "DATE,D";
    public static final String BATCHNO = "BATCHNO,N,4,0";
    public static final String TRANNO = "TRANNO,N,4,0";
    public static final String VOUC_SEQ = "VOUC_SEQ,N,4,0";
    public static final String VOUC_SEQ_2 = "VOUC_SEQ_2,N,4,0";
    public static final String TTYPE = "TTYPE,C,2";
    public static final String REFERENCE = "REFERENCE,C,10";
    public static final String REFNO = "REFNO,C,10";
    public static final String DESP = "DESP,C,40";
    public static final String DESPA = "DESPA,C,40";
    public static final String DESPB = "DESPB,C,40";
    public static final String DESPC = "DESPC,C,40";
    public static final String DESPD = "DESPD,C,40";
    public static final String DESPE = "DESPE,C,40";
    public static final String TAXPEC = "TAXPEC,N,5,2";
    public static final String DEBITAMT = "DEBITAMT,N,17,2";
    public static final String CREDITAMT = "CREDITAMT,N,17,2";
    public static final String FCAMT = "FCAMT,N,17,2";
    public static final String DEBIT_FC = "DEBIT_FC,N,17,2";
    public static final String CREDIT_FC = "CREDIT_FC,N,17,2";
    public static final String EXC_RATE = "EXC_RATE,N,18,10";
    public static final String ARAPTYPE = "ARAPTYPE,C,1";
    public static final String AGE = "AGE,N,2,0";
    public static final String SOURCE = "SOURCE,C,4";
    public static final String JOB = "JOB,C,4";
    public static final String JOB2 = "JOB2,C,4";
    public static final String SUBJOB = "SUBJOB,C,4";
    public static final String JOB_VALUE = "JOB_VALUE,N,19,2";
    public static final String JOB2_VALUE = "JOB2_VALUE,N,19,2";
    public static final String POSTED = "POSTED,C,1";
    public static final String EXPORTED = "EXPORTED,C,1";
    public static final String EXPORTED1 = "EXPORTED1,C,1";
    public static final String EXPORTED2 = "EXPORTED2,C,1";
    public static final String EXPORTED3 = "EXPORTED3,C,1";
    public static final String REM1 = "REM1,C,4";
    public static final String REM2 = "REM2,C,100";
    public static final String REM3 = "REM3,C,100";
    public static final String REM4 = "REM4,C,8";
    public static final String REM5 = "REM5,N,4,0";
    public static final String RPT_ROW = "RPT_ROW,N,4,0";
    public static final String AGENT = "AGENT,C,12";
    public static final String SITE = "SITE,C,12";
    public static final String STRAN = "STRAN,C,8";
    public static final String TAXPUR = "TAXPUR,N,17,2";
    public static final String PAYMODE = "PAYMODE,C,4";
    public static final String TRDATETIME = "TRDATETIME";
    public static final String CORR_ACC = "CORR_ACC,C,12";
    public static final String ACCNO2 = "ACCNO2,C,12";
    public static final String ACCNO3 = "ACCNO3,C,12";
    public static final String DATE2 = "DATE2,D";
    public static final String USERID = "USERID,C,8";
    public static final String TCURRCODE = "TCURRCODE,C,4";
    public static final String TCURRAMT = "TCURRAMT,N,19,2";
    public static final String ISSUDATE = "ISSUDATE,D";
    public static final String BPERIOD = "BPERIOD,N,2,0";
    public static final String BDATE = "BDATE,D";
    public static final String VPERIOD = "VPERIOD,N,2,0";
    public static final String ORIGIN = "ORIGIN,C,12";
    public static final String MPERIOD = "MPERIOD,N,2,0";
    public static final String CREATED_BY = "CREATED_BY,C,8";
    public static final String UPDATED_BY = "UPDATED_BY,C,8";
    public static final String CREATED_ON = "CREATED_ON";
    public static final String UPDATED_ON = "UPDATED_ON";
    public static final String FEE = "Fee";
    public static final String SHARE = "Share";
    public static final String ACTIVITY1 = "Activity 1";
    public static final String ACTIVITY2 = "Activity 2";
    public static final String ACTIVITY3 = "Activity 3";
    public static final String ACTIVITY4 = "Activity 4";
    public static final String[] FEE_ACCOUNT = {"2030", "2031", "2032", "2033", "2034", "2035"};
    public static final String[] SHARE_ACCOUNT = {"2040", "2041", "2042", "2043", "2044", "2045"};
    public static final String[] ACTIVITY1_ACCOUNT = {"4200", "4201", "4202", "4203", "4204", "4205"};
    public static final String[] ACTIVITY2_ACCOUNT = {"4300", "4301", "4302", "4303", "4304", "4305"};
    public static final String[] ACTIVITY3_ACCOUNT = {"4800", "4901"};
    public static final String[] ACTIVITY4_ACCOUNT = {"4500", "4501", "4502", "4503", "4504"};
    public static final String FEE_CONTROL_ACCOUNT = "7000/003";
    public static final String SHARE_CONTROL_ACCOUNT = "7000/002";
    public static final String ACTIVITY1_CONTROL_ACCOUNT = "7000/004";
    public static final String ACTIVITY2_CONTROL_ACCOUNT = "7000/005";
    public static final String ACTIVITY3_CONTROL_ACCOUNT = "7000/009";
    public static final String ACTIVITY4_CONTROL_ACCOUNT = "7000/006";
    public static final String FEE_DEDUCTION = "FD/";
    public static final String SHARE_DEDUCTION = "SD/";
    public static final String ACTIVITY1_DEDUCTION = "A1D/";
    public static final String ACTIVITY2_DEDUCTION = "A2D/";
    public static final String ACTIVITY3_DEDUCTION3 = "A3D/";
    public static final String ACTIVITY4_DEDUCTION = "A4D/";
    public static final String FEE_F = "01";
    public static final String ACTIVITY_2 = "02";
    public static final String ACTIVITY_3 = "03";
    public static final String SHARE_S = "04";
    public static final String ACTIVITY_1 = "05";
    public static final String ACTIVITY_4 = "06";
}
