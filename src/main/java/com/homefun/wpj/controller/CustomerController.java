package com.homefun.wpj.controller;

import com.homefun.wpj.damain.Customer;
import com.homefun.wpj.exception.CheckException;
import com.homefun.wpj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Name：CustomerController
 * Time：2016/8/25 9:05
 * author：WPJ587
 * description：客户信息
 **/
@Controller
@RequestMapping("/hc")
public class CustomerController extends BaseController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/customer/submit")
    public String messageSubmit(Customer customer, @RequestParam("token") String token, HttpServletRequest request, ModelMap map) {
        try {
            customerService.checkCustomer(token, request, customer);
        } catch (CheckException e) {
            map.put("msg", e.getErrMsg());

        }
        map.put("msg","提交成功");
        return "yuyue/success";
    }
}
