package com.lianchuang.model;

/**
 * Created by Administrator on 2016/10/26.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String nick;
    private int role;
    private int shop;

    public int getShop() {
        return shop;
    }

    public void setShop(int shop) {
        this.shop = shop;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    //    id	int(11)	NO	PRI		auto_increment
//    username	varchar(20)	NO
//    password	varchar(40)	NO
//    role	int(2)	YES
//    p_id	int(3)	YES
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


}
