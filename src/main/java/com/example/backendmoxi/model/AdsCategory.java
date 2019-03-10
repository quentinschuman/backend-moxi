package com.example.backendmoxi.model;

import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend-moxi
 * User: quent
 * Date: 2018/6/20
 * Time: 22:32
 */
public class AdsCategory extends BaseObject {

    private long id;
    private String name;
    private String description;
    private String image;
    private Date addDate;
    private int state;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Date getAddDate() {
        return addDate;
    }

    public int getState() {
        return state;
    }
}
