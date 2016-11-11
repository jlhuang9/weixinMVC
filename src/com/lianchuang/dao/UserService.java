package com.lianchuang.dao;

import com.lianchuang.dao.IUserDao;
import com.lianchuang.model.User;
import com.lianchuang.util.ResponseUtil;
import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;

/**
 * Created by Administrator on 2016/10/26.
 */
@Service
public class UserService {
    @Resource
    private IUserDao iUserDao;
    public User findUserByName(String username) {
        User user = iUserDao.findUserByName(username);
        return user;
    }
    public User getUserByShop(String shop){
        User user = new User();
        user = iUserDao.getUserByShop(shop);
        return user;
    }
    public Map<String,Object> getSupplierList(PageBounds pageBounds, String username) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = new User();
        if(username!=null){
            user.setUsername("%"+username+"%");
        }
        List<User> userlist = iUserDao.getSupplierList(pageBounds,user);
        if (userlist.size() > 0) {
            PageList pageList = (PageList) userlist;
            Paginator paginator = pageList.getPaginator();
            map.put("rows", userlist);
            map.put("paginator", paginator);
        }
        return map;
    }

    public String addUser(HttpServletRequest request, User user) {
        try {
            int i = iUserDao.addUser(user);
            if(i==1){
                return ResponseUtil.MESSAGE_ADD_TRUE;
            }
            return  ResponseUtil.MESSAGE_ADD_FALSE;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtil.MESSAGE_ADD_ERROR;
        }
    }

    public String upUserById(User user) {
        try {
            int i = iUserDao.upUserById(user);
            if(i==1){
                return ResponseUtil.MESSAGE_UP_TRUE;
            }
            return  ResponseUtil.MESSAGE_UP_FALSE;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtil.MESSAGE_UP_ERROR;
        }
    }

    public String delUserByid( String[] id) {
        try {
            int i = iUserDao.delUserByid(id);
            if(i!=0){
                return ResponseUtil.MESSAGE_DEL_TRUE;
            }
            return  ResponseUtil.MESSAGE_DEL_FALSE;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtil.MESSAGE_DEL_ERROR;
        }
    }
}
