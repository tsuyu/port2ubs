/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsuyu.port2ubs.util;

import com.tsuyu.port2ubs.constant.Constant;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Util {

    public static String[] merge(final String[] a, final String[] b) {

        List lst = new ArrayList(Arrays.asList(a));
        lst.addAll(Arrays.asList(b));

        Object[] objectArray = lst.toArray();

        String[] stringArray = Arrays.copyOf(objectArray, objectArray.length, String[].class);

        return stringArray;
    }

    //2 digit
    public static String leadingZero(final int number, final int length) {

        String formatted = String.format("%0" + length + "d", number);

        return formatted;
    }

    public static String[] exceptYuranSaham() {

        List lst = new ArrayList(Arrays.asList(Constant.ACTIVITY1_ACCOUNT));
        lst.addAll(Arrays.asList(Constant.ACTIVITY2_ACCOUNT));
        lst.addAll(Arrays.asList(Constant.ACTIVITY3_ACCOUNT));
        lst.addAll(Arrays.asList(Constant.ACTIVITY4_ACCOUNT));
        Object[] objectArray = lst.toArray();
        String[] stringArray = Arrays.copyOf(objectArray, objectArray.length, String[].class);
        return stringArray;

    }

    public static String createByDate() {
        //01/29/11 08:08 AM
        SimpleDateFormat format =
                new SimpleDateFormat("MM/dd/yy hh:mm aa");
        return format.format(new Date()).toString();
    }

    public static String convertDateMysql(java.util.Date strDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = formatter.format(strDate);
        return dateStr.toString();
    }

    public static String convertToXbaseDate(String dateStr) {
        String day = dateStr.substring(8, 10);
        String month = dateStr.substring(5, 7);
        String year = dateStr.substring(2, 4);
        return day + "/" + month + "/" + year;
    }

    public static java.lang.String convertToDbfDouble(java.lang.String str) {
        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(Double.parseDouble(str));
    }
}
