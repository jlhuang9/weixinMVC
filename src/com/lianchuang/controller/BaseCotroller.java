package com.lianchuang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/3.
 */
public class BaseCotroller {
    protected int getpageNow(HttpServletRequest request){
        String pageNow = request.getParameter("page");
        int page = 1;
        if (pageNow != null && !"".equals(pageNow)) {
            page = Integer.parseInt(pageNow);
        }
        return page;
    }
    protected int getpageRow(HttpServletRequest request){
        String pageRow = request.getParameter("rows");
        int limit = 10;
        if (pageRow != null && !"".equals(pageRow)) {
            limit = Integer.parseInt(pageRow);
        }
        return limit;
    }

    protected void writeResponse(HttpServletResponse response, String message) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragrma", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setDateHeader("Expires", 0);
        try {
            response.getWriter().write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
