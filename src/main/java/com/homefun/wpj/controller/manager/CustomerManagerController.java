package com.homefun.wpj.controller.manager;

import com.homefun.wpj.damain.BTRequestParams;
import com.homefun.wpj.damain.Customer;
import com.homefun.wpj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Name：CustomerManagerController
 * Time：2016/9/2 10:41
 * author：WPJ587
 * description：customer控制器
 **/
@Controller
@RequestMapping("/admin/cus")
public class CustomerManagerController extends BaseManagerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    @ResponseBody
    public Object getData(BTRequestParams btRequestParams) {

        return customerService.findByBTRequestParams(btRequestParams);
    }
    @InitBinder
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }
    @RequestMapping("/one")
    public Object toDetail(@RequestParam("userId") String userId, ModelMap map) {

        Customer customer = customerService.findByUser(userId);

        map.put("customer", customer);
        map.put("myTemplate", "manager/detail.vm");
        return "manager/main";
    }

    /**
     *  0失败
     *  1成败
     * @param customer
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(Customer customer) {
        if (customer == null) {

            return "0";// 失败
        }
        try {
            customerService.updateNotNull(customer);
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }
}
