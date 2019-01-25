package com.xinmove.jjwtweb.pojo.vo;

/**
 * @ClassName UserVo
 * @Descripption 值对象
 * @Author chenweitao
 * @Date 2019/1/25 17:09
 **/
public class UserVo {

    private String username;

    private String password;

    private String type;

    public UserVo() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
