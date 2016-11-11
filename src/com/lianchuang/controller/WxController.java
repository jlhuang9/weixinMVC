package com.lianchuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/2.
 */
@Controller
@RequestMapping("/weixin")
public class WxController {
    @RequestMapping("/cershi")
    public String ceshi(HttpServletRequest request){
        return "app/index";
    }
    @RequestMapping("/cershi1")
    public String ceshi1(HttpServletRequest request){
        return "app/shop";
    }

}
