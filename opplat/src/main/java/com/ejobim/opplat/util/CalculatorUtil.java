package com.ejobim.opplat.util;

/**
 * 只支持普通的四则及（） 组合运算
 */
public class CalculatorUtil {
    /*static boolean isNumber(String str) {//判断表达式是不是只有一个数字
        for(int i=0;i<str.length();i++) {
            if(!Character.isDigit(str.charAt(i)) && str.charAt(i)!='.') return false;
        }
        return true;
    }*/
    static boolean isNumber(String str) {//判断表达式是不是只有一个数字
        for(int i=0;i<str.length();i++) {
            if(str.indexOf("-")==0){
                str = str.substring(1);
            }
            if(!Character.isDigit(str.charAt(i)) && str.charAt(i)!='.') {
                return false;
            }

        }
        return true;
    }
    public static Double getResult(String str) {
        if(str.isEmpty() || isNumber(str)) {//递归头
            return str.isEmpty() ? 0  : Double.parseDouble(str);
        }

        //递归体
        if(str.contains(")")) {
            int lIndex = str.lastIndexOf("(");//最后一个左括号
            int rIndex = str.indexOf(")", lIndex);//对于的右括号
            return getResult(str.substring(0,lIndex) + getResult(str.substring(lIndex+1, rIndex)) + str.substring(rIndex+1));
        }
        if(str.contains("+")) {
            int index = str.lastIndexOf("+");
            return getResult(str.substring(0,index)) + getResult(str.substring(index+1));
        }
        /*if(str.contains("-")) {
            int index = str.lastIndexOf("-");
            return getResult(str.substring(0,index)) - getResult(str.substring(index+1));
        }*/
        if(str.contains("-")) {
            int index = str.lastIndexOf("-");
            if(index>0&&str.lastIndexOf("/")!=index-1&&str.lastIndexOf("*")!=index-1){
                return getResult(str.substring(0,index)) - getResult(str.substring(index+1));
            }
        }
        if(str.contains("*")) {
            int index = str.lastIndexOf("*");
            return getResult(str.substring(0,index)) * getResult(str.substring(index+1));
        }
        if(str.contains("/")) {
            int index = str.lastIndexOf("/");
            return getResult(str.substring(0,index)) / getResult(str.substring(index+1));
        }
        return null;//出错
    }
}
