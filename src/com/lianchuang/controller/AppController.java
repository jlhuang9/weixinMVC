package com.lianchuang.controller;

import com.lianchuang.dao.GoodsService;
import com.lianchuang.dao.GoodskindService;
import com.lianchuang.dao.UserService;
import com.lianchuang.model.Goodskind;
import com.lianchuang.model.User;
import com.lianchuang.util.MessageUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2016/11/6.
 */
@Controller
@RequestMapping("/app")
public class AppController extends BaseCotroller{
    @Resource
    UserService userService;
    @Resource
    GoodskindService goodskindService;
    @Resource
    GoodsService goodsService;
    @RequestMapping("/shop")
    public String goodskind(HttpServletRequest request, String shop){
        //获取店铺商家信息
        User user = userService.getUserByShop(shop);
        List<Goodskind> lgoodskind = goodskindService.findGoodskindlistBySuId(String.valueOf(user.getId()));
        JSONArray ja =  JSONArray.fromObject(lgoodskind);
        JSONArray ja2 = goodsService.findgoodsallBySuId(user.getId());
        System.out.println(ja.toString());
        System.out.println(ja2.toString());
        request.setAttribute("list",ja);
        request.setAttribute("listnow",ja2);
        return "app/shop";
    }
    @RequestMapping(value = "/getitemlist",method = RequestMethod.POST)
    public String getitemlist(HttpServletRequest request, HttpServletResponse response){
        String id = MessageUtil.getString(request,"id");
        JSONObject ja = new JSONObject();
        if(goodsService.findgoodsByKiId(id).size()>0){
            ja.put("status","1");
            ja.put("rows", JSONArray.fromObject(goodsService.findgoodsByKiId(id)));
        }
        else {
            ja.put("status","2");
            ja.put("msg","此类商品还没有商品");
        }
        this.writeResponse(response,ja.toString());
        return null;
    }
}
