package com.lianchuang.controller;

import com.lianchuang.dao.UserInfoService;
import com.lianchuang.entity.pojo.WeixinUserList;
import com.lianchuang.model.User;
import com.lianchuang.dao.UserService;
import com.lianchuang.model.UserInfo;
import com.lianchuang.util.*;
import com.lianchuang.util.me.MD5;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;


import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/10/27.
 */
@Controller
@RequestMapping("/web")
public class WebController  extends BaseCotroller {
    @Resource
    UserService userService;
    @Resource
    UserInfoService userInfoService;
    @RequestMapping(value = "/getlist",method = RequestMethod.POST)
    public String getlist(HttpServletRequest request,HttpServletResponse response){
        String token = WeixinUtil.gettoken();
        String data = MenuUtil.getMenu(token);
        String message = "{\"result\":1,\"data\":" + data + "}";
        writeResponse(response,message);
        return null;
    }
    @RequestMapping(value = "/makelist",method = RequestMethod.POST)
    public String makelist(HttpServletRequest request,HttpServletResponse response,String menu){
        boolean result = false;
        String token = WeixinUtil.gettoken();
        String url = MenuUtil.menu_create_url.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", "{\"button\":"+menu+"}");
        String message ="";
        if (null != jsonObject) {
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            if (0 == errorCode) {
                result = true;
                message = "{\"result\":1}";
            } else {
                result = false;
                message ="{\"result\":2,\"error\":\"" + errorCode + "\",\"errorMsg\":\"" + errorMsg + "\"}";
            }
        }
        writeResponse(response,message);
        return null;
    }
    //supplier  begin
    @RequestMapping(value = "/getSupplierList",method = {RequestMethod.POST,RequestMethod.GET})
    public String getSupplierList(HttpServletRequest request,HttpServletResponse response){
        String message ="";
        String name = MessageUtil.getString(request,"name");
        PageBounds pageBounds = new PageBounds(getpageNow(request), getpageRow(request));
        // 调用service查找 数据库，查询所有人
        Map<String, Object> map =  userService.getSupplierList(pageBounds,name);
        List<User> Userlist = (List<User>) map.get("rows");
        Paginator paginator = (Paginator) map.get("paginator");
        JSONArray jsonArray = JSONArray.fromObject(Userlist);
        if(paginator == null){
            message = "{\"result\":2}";
        }
        else
        message = "{\"result\":1,\"row\":"+jsonArray.toString()+",\"page\":"+paginator.getPage()+",\"totalPages\":"+paginator.getTotalPages()+",\"totalCount\":"+paginator.getTotalCount()+"}";
        this.writeResponse(response,message);
        return null;
    }

    //add
    @RequestMapping(value = "/supplieradd",method = RequestMethod.POST)
    public String goodsadd(HttpServletRequest request, HttpServletResponse response){
        User user =new User();
        user.setUsername(MessageUtil.getString(request,"username"));
        user.setPassword(new MD5().getMD5ofStr(MessageUtil.getString(request,"password")));
        user.setNick(MessageUtil.getString(request,"nick"));
        user.setRole(1);
        this.writeResponse(response, userService.addUser(request,user));
        return null;
    }
    //edit
    @RequestMapping(value = "/supplieredit",method = RequestMethod.POST)
    public String goodsedit(HttpServletRequest request, HttpServletResponse response, User user){
        this.writeResponse(response, userService.upUserById(user));
        return null;
    }
    //del
    @RequestMapping(value = "/supplierdel",method = RequestMethod.POST)
    public String goodsdelt(HttpServletRequest request, HttpServletResponse response){
        String[] id = MessageUtil.getString(request,"id").split(",");
        this.writeResponse(response, userService.delUserByid(id));
        return null;
    }

    //supplier  end


    @RequestMapping(value = "/getFansList",method = {RequestMethod.POST,RequestMethod.GET})
    public String getFansList(HttpServletRequest request, HttpServletResponse response ,
                              @RequestParam(required =false,defaultValue ="1") int page,
                              @RequestParam(required =false,defaultValue ="10") int limit){
        String message ="";
        String name = MessageUtil.getString(request,"name");
        PageBounds pageBounds = new PageBounds(page, limit);
        message = userInfoService.getFansList(pageBounds,name).toString();
        this.writeResponse(response,message);
        return null;
    }

    @RequestMapping("/fansListUP")
    public String fansListUP(HttpServletRequest request, HttpServletResponse respons){
        WeixinUserList weixinUserList = AdvancedUtil.getUserList(WeixinUtil.gettoken(),"");
		System.out.println("总关注用户数：" + weixinUserList.getTotal());

        List<String> al= weixinUserList.getOpenIdList();
        for(int i = 0 ; i<al.size();i++){
            UserInfo ui =AdvancedUtil.getUserInfo(WeixinUtil.gettoken(),al.get(i));
            try {
                ui.setNickname(CommonUtil.filterOffUtf8Mb4(ui.getNickname()));
            }
            catch (Exception e){
                e.printStackTrace();
            }

            userInfoService.insert(ui);
        }

		System.out.println("next_openid：" + weixinUserList.getNextOpenId());
        return null;
    }


}
