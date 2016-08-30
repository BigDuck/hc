package com.homefun.wpj.serviceImpl;

import com.homefun.wpj.damain.Cards;
import com.homefun.wpj.damain.Customer;
import com.homefun.wpj.dao.CustomerMapper;
import com.homefun.wpj.exception.CheckException;
import com.homefun.wpj.service.BaseService;
import com.homefun.wpj.service.CardService;
import com.homefun.wpj.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Name：CustomerServiceImpl
 * Time：2016/8/25 9:51
 * author：WPJ587
 * description：
 **/
@Service
public class CustomerServiceImpl extends BaseService<Customer> implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    CardService cardService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void checkCustomer(String token, HttpServletRequest request, Customer customer) {
        // 验证token 看是否合法提交
        logger.info("token:" + token + "customer" + customer);
        HttpSession session = request.getSession();
        String newToken = session.getAttribute("newToken") + "";
        if (token != null) {
            if (!token.equals(newToken)) {
                throw new CheckException("403", "非法提交");
            }
        }
        // 验证表单是否被多次提交了
     Cards cards= cardService.selectByKey(customer.getCardNum());
        if(cards==null){
            throw new CheckException("403","非法提交");
        }else if (cards.getIsUsed()==true){
            throw new CheckException("403","请勿重复提交哦><!!!");
        }
        // 验证完后进行数据库的操作  增加用户的提交信息
        int res = customerMapper.insert(customer);
        if (res != 1) {
            throw new CheckException("500", "订单失败");
        }
        // 注销卡券，标记为已使用
        if (!cardService.writtenOffCard(customer.getCardNum())) {

            throw new CheckException("500", "卡券注销失败");
        }

    }

    /**
     * 通过卡券号获取用户信息
     *
     * @param cardNum 卡券号
     * @return
     */
    @Override
    public Customer findCustomerByCardNum(String cardNum) {

        return null;
    }
}
