package com.homefun.wpj.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.homefun.wpj.conf.WXconfig;
import com.homefun.wpj.service.WxService;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.terracotta.modules.ehcache.ToolkitInstanceFactoryImpl.LOGGER;

/**
 * Name：WxServiceImpl
 * Time：2016/8/26 9:08
 * author：WPJ587
 * description：微信用户操作
 **/
@Service
public class WxServiceImpl implements WxService {

    /**
     * 获取用户的openId
     *
     * @param code
     * @return key openid，access_token
     */
    @Override
    public Map<String, Object> getWxUserOpenIdAndAccessToken(String code) {
         Logger logger = LoggerFactory.getLogger(this.getClass());
        if (code == null || code == "") {
            return null;
        }

        // 如果不为空的话就进行用户openId 的获取
        String accessCodeUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
                + WXconfig.WX_APP_ID + "&secret="
                + WXconfig.WX_APP_SECRET + "&code=" + code + "&grant_type=authorization_code";
        HttpPost post = new HttpPost(accessCodeUrl);
        String aToken;
        HttpResponse resp;
        String openId;
        ByteArrayOutputStream bout = null;
        // 结果集
        Map<String, Object> resultMap = new HashMap<>();
        try {
            resp = HttpClients.createDefault().execute(post);
            if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                InputStream inputStream = resp.getEntity().getContent();
                byte[] buff = new byte[1024];
                int len;
                bout = new ByteArrayOutputStream();
                while ((len = inputStream.read(buff)) != -1) {
                    bout.write(buff, 0, len);
                }
                JSONObject result = JSON.parseObject(new String(bout.toByteArray()));
                openId = (String) result.get("openid");
                aToken = (String) result.get("access_token");
                resultMap.put("openid", openId);
                resultMap.put("access_token", aToken);
                if (result.containsKey("errcode")) {
                    logger.error("result{}",result);
                    resultMap = null;
                }
            } else {

                resultMap = null;
                //out.println("用户授权失败。");
                LOGGER.error("发送请求返回失败：" + resp.getStatusLine().getStatusCode());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            post.releaseConnection();
            if (bout == null) {
                try {
                    bout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    LOGGER.error("释放链接失败{}", e.getCause());
                }
            }
        }
        return resultMap;
    }
}
