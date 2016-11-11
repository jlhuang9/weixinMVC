package com.lianchuang.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.lianchuang.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */
@Repository
public interface IUserInfo {
    int insert(UserInfo userInfo);

    int listinsert(List<UserInfo> userInfolist);

    List<UserInfo> getFansList(PageBounds pageBounds, UserInfo userInfo);

}
