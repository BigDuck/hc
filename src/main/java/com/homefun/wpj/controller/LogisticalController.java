package com.homefun.wpj.controller;

import com.homefun.wpj.damain.Customer;
import com.homefun.wpj.exception.CheckException;
import com.homefun.wpj.service.LogisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Name：LogisticalController
 * Time：2016/8/26 9:51
 * author：WPJ587http://51homefun.com/hc/logistical
 * description：物流
 **/
@Controller
@RequestMapping("/hc")
public class LogisticalController extends BaseController {

    @Autowired
    LogisticalService logisticalService;

    @RequestMapping(value = "/logistical")
    public Object logistical() {

        return super.returnPage("wl/logistical");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/logistical/order")
    @ResponseBody
    public Object message(
            @RequestParam(value = "cardNum", required = false) String cardNum
    ) {
        Customer customer = new Customer();
        customer.setCardNum(cardNum);

        List<Customer> res = logisticalService.findByUserWX(customer);

        if (res != null) {
            if(res.size()==0){
                throw new CheckException("404","暂无该卡券信息");
            }
            try {
                customer = res.get(0);
            } catch (CheckException c) {
                throw new CheckException("500","暂无该卡券信息");
            }
            customer.setUserName(customer.getUserName().replace(customer.getUserName().substring(customer.getUserName().length() / 2, customer.getUserName().length() / 2 + 1), "*"));
            customer.setUserId(null);
            customer.setUserWx(null);
            customer.setUserAddress(null);
            customer.setUserFb(null);
            customer.setUserPhone(null);
            customer.setUserOrder(customer.getUserOrder().substring(2));
        }
        return customer;
    }
}
