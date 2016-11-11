package com.lianchuang.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.lianchuang.model.User;
import com.lianchuang.model.UserInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/2.
 */
@Service
public class UserInfoService {
    @Resource
    private IUserInfo iUserInfo;
    public int insert(UserInfo userInfo){
        int b = iUserInfo.insert(userInfo);
        return b;
    }
    public JSONObject getFansList(PageBounds pageBounds, String name) {

        UserInfo userInfo = new UserInfo();
        if(name!=null){
            userInfo.setNickname("%"+name+"%");
        }
        List<UserInfo> userlist = iUserInfo.getFansList(pageBounds,userInfo);
        PageList pageList =null;
        if (userlist.size() > 0) {
             pageList = (PageList) userlist;
        }
        return pageUtil.pageFormat(pageList);
    }
}
