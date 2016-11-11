package com.lianchuang.controller;

import com.lianchuang.dao.GoodskindService;
import com.lianchuang.model.Goodskind;
import com.lianchuang.util.MessageUtil;
import com.lianchuang.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/27.
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseCotroller{
    @Resource
    GoodskindService goodskindService;
    @RequestMapping(value = "/left/customMenu",method = RequestMethod.GET)
    public String menu(HttpServletRequest request){
        return "jsp/customMenu";
    }
    @RequestMapping(value = "/left/model",method = RequestMethod.GET)
    public String model(HttpServletRequest request){
        return "jsp/model";
    }
    @RequestMapping(value = "/supplier/main",method = RequestMethod.GET)
    public String supplierMain(HttpServletRequest request){
        return "jsp/supplierMain";
    }
    @RequestMapping(value = "/fans/fans",method = RequestMethod.GET)
    public String fansmain(HttpServletRequest request){
        return "jsp/fans";
    }
    @RequestMapping(value = "/suplier/suplier",method = RequestMethod.GET)
    public String suplierGoods(HttpServletRequest request){
        return "suplier/suplier";
    }
    @RequestMapping(value = "/suplier/goodskind",method = RequestMethod.GET)
    public String goodskind(HttpServletRequest request,String oper){
        return "suplier/goodskind";
    }

    //轮播图片
    @RequestMapping(value = "/index/imgs",method = RequestMethod.GET)
    public String indexImgs(HttpServletRequest request,String oper){
        return "jsp/indexImgs";
    }


}
