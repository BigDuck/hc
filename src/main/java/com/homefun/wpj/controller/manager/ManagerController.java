package com.homefun.wpj.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Name：ManagerController
 * Time：2016/8/31 9:16
 * author：WPJ587
 * description：管理主界面
 **/
@RequestMapping("/admin")
@Controller
public class ManagerController extends BaseManagerController {
    @RequestMapping("/main")
    public String index() {
        return "manager/main";
    }
}
