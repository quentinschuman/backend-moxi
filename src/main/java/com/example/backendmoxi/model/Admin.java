package com.example.backendmoxi.model;

import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend-moxi
 * User: quent
 * Date: 2018/6/18
 * Time: 17:05
 */
public class Admin extends BaseObject {

    private long id;
    private String userName;
    private String password;
    private String realName;
    private int age;
    private String phoneNumber;
    private String headPicture;
    private Date addDate;
    private Date updateDate;
    private int state;

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRealName() {
        return realName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public Date getAddDate() {
        return addDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public int getState() {
        return state;
    }
}
