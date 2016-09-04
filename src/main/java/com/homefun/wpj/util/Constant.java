package com.homefun.wpj.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Name：Constant
 * Time：2016/8/25 9:24
 * author：WPJ587
 * description：常量类型
 **/

public class Constant {

    public static Map<Integer, String> ORDER_STATE = new HashMap<Integer, String>() {
        private static final long serialVersionUID = 4896121447465087526L;
        {
            put(0, "待审核");
            put(1, "审核通过");
            put(2, "订单取消");
        }
    };

    public static void main(String[] args) {
        System.out.println(Constant.ORDER_STATE.get(0));
    }
}
