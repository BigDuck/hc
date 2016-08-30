package com.homefun.wpj.vo;

import com.homefun.wpj.damain.BaseDamain;
import com.homefun.wpj.damain.Customer;

/**
 * Name：MessageVo
 * Time：2016/8/25 9:01
 * author：WPJ587
 * description：消息vo
 **/

public class MessageVo extends BaseDamain {
    private static final long serialVersionUID = -4281324467271415193L;
    private Customer customer;
    private String token; // token 信息用于验证信息是否属于正规提交

    public MessageVo(Customer customer, String token) {
        this.customer = customer;
        this.token = token;
    }

    public MessageVo() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "MessageVo{" +
                "customer=" + customer +
                ", token='" + token + '\'' +
                '}';
    }
}
