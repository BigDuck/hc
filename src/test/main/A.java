package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Name：A
 * Time：2016/9/3 15:31
 * author：WPJ587
 * description：
 **/
public class A {
    public static void main(String[] args) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-dd-MM hh:mm:ss");
        String a="1472807799000";
        System.out.println(dateFormat.format(a));
//        Date date=new Date("1472807799000");
//        System.out.println(date);
    }
}
