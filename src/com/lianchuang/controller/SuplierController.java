package com.lianchuang.controller;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.lianchuang.dao.GoodsService;
import com.lianchuang.dao.GoodskindService;
import com.lianchuang.model.Goods;
import com.lianchuang.model.Goodskind;
import com.lianchuang.util.MessageUtil;
import com.lianchuang.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Administrator on 2016/11/3.
 */
@Controller
@RequestMapping("/suplier")
public class SuplierController extends BaseCotroller {
    @Resource
    GoodskindService goodskindService;
    //getGoodskind start
    @RequestMapping("/getGoodskindList")
    public String getGoodskindList(HttpServletRequest request, HttpServletResponse response, HttpSession session,  @RequestParam(required =false,defaultValue ="1") int page,
                                   @RequestParam(required =false,defaultValue ="10") int limit) {
        JSONObject user = JSONObject.fromObject(session.getAttribute("user"));
        String message = "";
        String id = user.getString("id");
        PageBounds pageBounds = new PageBounds(page,limit);
        message = goodskindService.findGoodskindBySuId(pageBounds, id).toString();
        this.writeResponse(response, message);
        return null;
    }
    @RequestMapping("/getGoodskindallList")
    public String getGoodskindallList(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        JSONObject user = JSONObject.fromObject(session.getAttribute("user"));
        String message = "";
        String id = user.getString("id");
        message = goodskindService.findGoodskindallBySuId(id).toString();
        this.writeResponse(response, message);
        return null;
    }
    //add
    @RequestMapping(value = "/suplier/goodskindadd",method = RequestMethod.POST)
    public String goodskindadd(HttpServletRequest request, HttpServletResponse response){
        Goodskind goodskind = new  Goodskind();
        goodskind.setList(Integer.parseInt(MessageUtil.getString(request,"list")));
        goodskind.setName(MessageUtil.getString(request,"name"));
        this.writeResponse(response, goodskindService.addGoodsKind(request,goodskind));
        return null;
    }
    //edit
    @RequestMapping(value = "/suplier/goodskindedit",method = RequestMethod.POST)
    public String goodskindedit(HttpServletRequest request, HttpServletResponse response, Goodskind goodskind){
        this.writeResponse(response, goodskindService.upGoodsKindById(goodskind));
        return null;
    }
    //del
    @RequestMapping(value = "/suplier/goodskinddel",method = RequestMethod.POST)
    public String goodskinddelt(HttpServletRequest request, HttpServletResponse response){
        String[] id = MessageUtil.getString(request,"id").split(",");
        this.writeResponse(response, goodskindService.delGoodsKindByid(id));
        return null;
    }
    //getGoodskind end

    //getGoods start
    @Resource
    GoodsService goodsService;
    @RequestMapping("/getgoodsList")
    public String getgoodsList(HttpServletRequest request, HttpServletResponse response, HttpSession session,  @RequestParam(required =false,defaultValue ="1") int page,
                               @RequestParam(required =false,defaultValue ="10") int limit) {
        JSONObject user = JSONObject.fromObject(session.getAttribute("user"));
        String message = "";
        String id = user.getString("id");
        PageBounds pageBounds = new PageBounds(page,limit);
        message = goodsService.findgoodsBySuId(pageBounds, id).toString();
        this.writeResponse(response, message);
        return null;
    }
    //add
    @RequestMapping(value = "/suplier/goodsadd",method = RequestMethod.POST)
    public String goodsadd(HttpServletRequest request, HttpServletResponse response){
        Goods goods =new Goods();
        goods.setName(MessageUtil.getString(request,"name"));
        goods.setKi_id(MessageUtil.getInt(request,"ki_id"));
        goods.setPrice(Float.parseFloat(MessageUtil.getString(request,"price")));
        this.writeResponse(response, goodsService.addGoods(request,goods));
        return null;
    }
    //edit
    @RequestMapping(value = "/suplier/goodsedit",method = RequestMethod.POST)
    public String goodsedit(HttpServletRequest request, HttpServletResponse response, Goods goods){
        this.writeResponse(response, goodsService.upGoodsById(goods));
        return null;
    }
    //del
    @RequestMapping(value = "/suplier/goodsdel",method = RequestMethod.POST)
    public String goodsdelt(HttpServletRequest request, HttpServletResponse response){
        String[] id = MessageUtil.getString(request,"id").split(",");
        this.writeResponse(response, goodsService.delGoodsByid(id));
        return null;
    }
    //getGoods end
}
