package com.homefun.wpj.serviceImpl;

import com.homefun.wpj.damain.Customer;
import com.homefun.wpj.service.CustomerService;
import com.homefun.wpj.service.LogisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Name：LogisticalServiceImpl
 * Time：2016/8/26 10:06
 * author：WPJ587
 * description：
 **/
@Service
public class LogisticalServiceImpl implements LogisticalService {
    @Autowired
    CustomerService customerService;

    /**
     * 通过customer获取对应的数据
     *
     * @param customer
     * @return
     */
    @Override
    public List<Customer> findByUserWX(Customer customer) {
        if (customer == null) {
            return null;
        }
        Example example = new Example(Customer.class);
        Example.Criteria criteria = example.createCriteria();
        if (customer.getUserWx() != null) {
            criteria.andEqualTo("userWx", customer.getUserWx());
        }
        if (customer.getCardNum() != null) {
            criteria.andEqualTo("cardNum", customer.getCardNum());
        }
        return customerService.selectByExample(example);
    }
}
