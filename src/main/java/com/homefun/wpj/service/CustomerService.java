package com.homefun.wpj.service;

import com.homefun.wpj.damain.Customer;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by WPJ587 on 2016/8/25.
 */
public interface CustomerService extends IService<Customer> {
    /**
     * @param token    token验证
     * @param request
     * @param customer 客户填写的信息
     * @return
     */
    void checkCustomer(String token, HttpServletRequest request, Customer customer);

    /**
     * 通过卡券号获取用户信息
     * @param cardNum 卡券号
     * @return
     */
    Customer findCustomerByCardNum(String cardNum);
}
