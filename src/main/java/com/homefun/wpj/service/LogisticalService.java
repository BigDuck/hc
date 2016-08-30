package com.homefun.wpj.service;

import com.homefun.wpj.damain.Customer;

import java.util.List;

/**
 * Created by WPJ587 on 2016/8/26.
 */
public interface LogisticalService {
    /**
     * 通过customer获取对应的数据
     * @param customer
     * @return
     */
    List<Customer> findByUserWX(Customer customer);
}
