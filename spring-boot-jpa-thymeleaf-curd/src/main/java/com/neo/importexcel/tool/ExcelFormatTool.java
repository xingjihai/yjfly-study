package com.neo.importexcel.tool;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ExcelFormatTool {
    ImportMessage importMessage;

    public void setImportMessage(ImportMessage importMessage) {
        this.importMessage = importMessage;
    }

    public ImportMessage getImportMessage() {
        if(importMessage==null){
            importMessage=new ImportMessage();
        }
        return importMessage;
    }

    public static String[] sdfArr={"yyyy-MM-dd","EEE MMM dd HH:mm:ss Z yyyy","yyyy/MM/dd"};
    private int dateIndex=0;
    private int errorCount=0;


    /**
     * excel 计数（count从1开始算）
     * @param count
     * @param countStr
     * @return
     */
    public static String excelCount(int count,String countStr){
        if(count<=0){
            return countStr;
        }
        if(countStr==null){
            countStr="";
        }
        int mantissa=count%26;
        int multiple=count/26;
        countStr=excelCount(multiple,countStr);
        char countChar=(char)(mantissa+64);
        countStr+=String.valueOf(countChar);
        return countStr;
    }

    /**
     * excel头部比较
     */
    public static StringBuffer needHead(String[] modelHead,String[] importHead){
        Map importHeadMap=new HashMap();
        for (String s : importHead) {
            importHeadMap.put(s,s);
        }
        StringBuffer message=new StringBuffer();
        for (int i = 0;  i < modelHead.length ; i++) {
            if(importHeadMap.get(modelHead[i] ) ==null ){
                message.append( "缺少'"+modelHead[i]+"'字段;" );
            }
        }
        return message;
    }


    // 完整的判断中文汉字和符号
    public static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }
    // 根据Unicode编码完美的判断中文汉字和符号
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }


    /**
     * 日期格式
     * @param dateStr
     * @return
     */
    public Date getDate(String dateStr){

        if(dateIndex>=sdfArr.length){
            dateIndex=0;
        }

        if(errorCount>=sdfArr.length){
            getImportMessage().addMsg("日期格式错误："+dateStr);
            errorCount=0;
            return null;
        }

        try {
            SimpleDateFormat sdfDate = new SimpleDateFormat(sdfArr[dateIndex], Locale.UK);
            Date date=sdfDate.parse(dateStr);
            errorCount=0;
            return date;
        } catch (ParseException e) {
            dateIndex++;
            errorCount++;
            return getDate(dateStr);
        }
    }
    /**
     * Double格式
     * @return
     */
    public Double getCurrencyDouble(String value){
        try {
            Double doub=Double.parseDouble(value);
            return doub;
        } catch (Exception e) {
            getImportMessage().addMsg("金额格式错误："+value);
        }
        return null;
    }
    public Integer getDictionaryInteger(String value,String dictionaryStr){
        try{
            return Integer.parseInt(value);
        }catch (Exception e){
            getImportMessage().addMsg(dictionaryStr+"字典值设置错误,应为整数");
            return null;
        }
    }
    public Integer getInteger(String value,String errorMsg){
        try{
            return Integer.parseInt(value);
        }catch (Exception e){
            getImportMessage().addMsg( errorMsg );
            return null;
        }
    }


}
