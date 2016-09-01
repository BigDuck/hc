package com.homefun.wpj;

/**
 * Name：TTT
 * Time：2016/8/31 16:54
 * author：WPJ587
 * description：
 **/

public class TTT {
    public static void main(String[] args) {
        String a="020505070009";
        String aa[]=a.split("0");
//        String re=a.replaceAll("[0]{1}([0]{2,})+","");
//        for (int i=0;i<aa.length;i++){
//            System.out.println(aa[i]);
//        }(?!.*[0]{2,})^.*[0]{1}
        String re=a.replaceAll("(?!.*[0]{2,})^.*[0]{1}","");// 25570009
        System.out.println(re);
    }
}
