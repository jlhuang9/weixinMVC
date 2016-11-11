package com.lianchuang.model;

/**
 * Created by Administrator on 2016/11/3.
 */
public class Goods {
//    `id` int(11) NOT NULL AUTO_INCREMENT,                                -- id主键
//  `ki_id` int(11) DEFAULT NULL,										   -- 种类id
//  `name` varchar(32) DEFAULT NULL,		  							 -- 商品名称
//  `price` int(16) DEFAULT NULL,										   -- 价格
    private int id;
    private int ki_id;
    private String name;
    private float price;
    private Goodskind goodskind;

    public Goodskind getGoodskind() {
        return goodskind;
    }

    public void setGoodskind(Goodskind goodskind) {
        this.goodskind = goodskind;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKi_id() {
        return ki_id;
    }

    public void setKi_id(int ki_id) {
        this.ki_id = ki_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
