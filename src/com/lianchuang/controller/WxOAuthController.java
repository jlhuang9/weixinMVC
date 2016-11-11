package com.lianchuang.controller;

import com.lianchuang.dao.UserInfoService;
import com.lianchuang.entity.pojo.WeixinOauth2Token;
import com.lianchuang.model.UserInfo;
import com.lianchuang.util.AdvancedUtil;
import com.lianchuang.util.Constants;
import com.lianchuang.util.WeixinUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/29.
 */
@Controller
@RequestMapping("/OAuth")
public class WxOAuthController {
    @Resource
    UserInfoService userInfoService;
    @RequestMapping("/oaindex")
    public String oaindex(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String code = request.getParameter("code");
        if (!"authdeny".equals(code)) {
            // 获取网页授权access_token
            WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(Constants.APPID, Constants.SECRET, code);
            // 网页授权接口访问凭证
            String accessToken = weixinOauth2Token.getAccessToken();
            // 用户标识
            String openid = weixinOauth2Token.getOpenId();
            //获取用户信息
            UserInfo userInfo =AdvancedUtil.getSNSUserInfo(WeixinUtil.gettoken(),openid);
            //插入数据库
            int i = userInfoService.insert(userInfo);
            JSONObject jb = new JSONObject();
            jb.put("nick",userInfo.getNickname());
            jb.put("head",userInfo.getHeadimgurl());
            jb.put("id", userInfo.getOpenid());
            // 获取用户信息
            request.getSession().setAttribute("user",jb);
        }
        // 用户同意授权
        return "app/index";
    }
}
