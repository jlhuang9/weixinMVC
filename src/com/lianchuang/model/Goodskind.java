package com.lianchuang.model;

/**
 * Created by Administrator on 2016/11/3.
 */
public class Goodskind {
//      `id` int(11) NOT NULL AUTO_INCREMENT,                                 -- id主键
//  `name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,			-- 种类名称
//  `su_id` int(11) DEFAULT NULL,											-- 供应商主键
    private int id ;
    private String name;
    private int su_id;
    private int list;

    public int getList() {
        return list;
    }

    public void setList(int list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSu_id() {
        return su_id;
    }

    public void setSu_id(int su_id) {
        this.su_id = su_id;
    }
}
