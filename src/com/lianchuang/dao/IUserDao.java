package com.lianchuang.dao;

/**
 * Created by Administrator on 2016/10/26.
 */

import com.lianchuang.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Repository
public interface IUserDao {
    User findUserByName(String username);

    List<User> getSupplierList(PageBounds pageBounds,User user);

    int addUser(User user);

    int upUserById(User user);

    int delUserByid( String[] id);

    User getUserByShop(String shop);
}
