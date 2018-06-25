package com.example.backendmoxi.model;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend-moxi
 * User: quent
 * Date: 2018/6/20
 * Time: 22:35
 */
public class ResObject<T> {

    private String resCode;
    private String resMessage;
    private Object resObject;
    private List<T> resList;

    public ResObject(String resCode,String resMessage,Object resObject,List<T> resList){
        this.resCode = resCode;
        this.resMessage = resMessage;
        this.resObject = resObject;
        this.resList = resList;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public void setResObject(Object resObject) {
        this.resObject = resObject;
    }

    public void setResList(List<T> resList) {
        this.resList = resList;
    }

    public String getResCode() {
        return resCode;
    }

    public String getResMessage() {
        return resMessage;
    }

    public Object getResObject() {
        return resObject;
    }

    public List<T> getResList() {
        return resList;
    }
}
