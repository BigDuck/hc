package com.homefun.wpj.controller;

import com.homefun.wpj.damain.Customer;
import com.homefun.wpj.exception.CheckException;
import com.homefun.wpj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Name：FeedbackController
 * Time：2016/8/28 16:25
 * author：WPJ587
 * description：反馈
 **/
@Controller
@RequestMapping("/hc")
public class FeedbackController extends BaseController {
    @Autowired
    private CustomerService customerService;

    /**
     * 反馈页面
     *
     * @return
     */
    @RequestMapping("/feedback")
    public Object toFeedBack() {
        return super.returnPage("wl/feedback");
    }

    @RequestMapping("/feedback/sub")
    @ResponseBody
    public Object addFeedBack(Customer customer)  {
        Example example = new Example(Customer.class);
        Example.Criteria criteria = example.createCriteria();

        if (customer.getCardNum() != null) {
            criteria.andEqualTo("cardNum", customer.getCardNum());
        }
        // 查找卡券号为cardNum的用户订单信息
        List<Customer> re = customerService.selectByExample(example);
        Customer customer1 = null;
        if (re != null && re.size() != 0) {
            customer1 = re.get(0);
        } else {
            throw new CheckException("404", "不存在该卡券号信息");
        }
        String fb=customer.getUserFb();
        if (fb.length()>=254){
            customer1.setUserFb(fb.substring(0,253));
        }else {
            customer1.setUserFb(fb);
        }
        customerService.updateNotNull(customer1);
        return true;
    }
}
