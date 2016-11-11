package com.lianchuang.model;

/**
 * Created by Administrator on 2016/11/3.
 */
public class plate {
//      `id` int(11) NOT NULL AUTO_INCREMENT,                        -- 板块id
//  `name` varchar(20) DEFAULT NULL,							   -- 板块名称
//  `list` int(2) DEFAULT NULL,								   -- 排序列
//  `su_id` int(11) DEFAULT NULL,								   -- 供应商主键
    private int id;
    private String name;
    private int list;
    private int su_id;

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

    public int getList() {
        return list;
    }

    public void setList(int list) {
        this.list = list;
    }

    public int getSu_id() {
        return su_id;
    }

    public void setSu_id(int su_id) {
        this.su_id = su_id;
    }
}
