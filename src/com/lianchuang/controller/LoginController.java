package com.lianchuang.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import com.lianchuang.model.User;
import com.lianchuang.util.me.MD5;


import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lianchuang.dao.UserService;

@Controller
@RequestMapping("/")
public class LoginController {

    @Resource
    UserService userService;
    @RequestMapping("/")
    public String login(){
        return "login";
    }
	@RequestMapping("/hello")
	public String hello(HttpSession session){
		session.setAttribute("LOGIN_USER", "zhang");
		System.out.println("/hello");
		return "hello";
	}
	@RequestMapping(value="/aaa")
	@ResponseBody
	public String aaa(){
		System.out.println("/aaa");
		return "测试乱码";
	}

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String index(HttpServletRequest request,String username,String password) {
		User user = userService.findUserByName(username);
		if(user!=null){
			if(user.getPassword().equals(new MD5().getMD5ofStr(password))){
				request.getSession().setAttribute("user", JSONObject.fromObject(user).toString());

				if(user.getRole()==0){
					return "jsp/index";//跳转至访问页面
				}
				else
					return "suplier/suplier";
			}else{
				request.setAttribute("message", "用户名密码错误，请重新登录");
				return "login";
			}
		}else{
			request.setAttribute("message", "用户名不存在，请重新登录");
			return "login";
		}
	}
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "login";
	}
}
