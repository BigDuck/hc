package com.homefun.wpj.dao;

import com.homefun.wpj.damain.Customer;
import com.homefun.wpj.db.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper extends MyMapper<Customer> {
    Customer selectCustomerByUserId(@Param("userId") String userId);
}