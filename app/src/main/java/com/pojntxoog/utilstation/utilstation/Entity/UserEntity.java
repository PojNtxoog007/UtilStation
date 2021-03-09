package com.pojntxoog.utilstation.utilstation.Entity;

import java.util.Date;

/**
 * Created by 丰 on 2020-08-19.
 */

public class UserEntity {

    private Integer ID;	//
    private String User;	//
    private String UserName;	//
    private String Additional;	//
    private String PassWord;	//
    private String Xauv;	//
    private String ContractKey;	//
    private String HeadUrl;	//
    private String IndexMap;	//
    private Integer Money;	//
    private Date Time;	//

    public UserEntity() {
    }

    public UserEntity(String user, String userName, String additional, String contractKey, String headUrl, String indexMap) {
        User = user;
        UserName = userName;
        Additional = additional;
        ContractKey = contractKey;
        HeadUrl = headUrl;
        IndexMap = indexMap;
    }

    public UserEntity(String passWord) {
        PassWord = passWord;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getAdditional() {
        return Additional;
    }

    public void setAdditional(String additional) {
        Additional = additional;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getXauv() {
        return Xauv;
    }

    public void setXauv(String xauv) {
        Xauv = xauv;
    }

    public String getContractKey() {
        return ContractKey;
    }

    public void setContractKey(String contractKey) {
        ContractKey = contractKey;
    }

    public String getHeadUrl() {
        return HeadUrl;
    }

    public void setHeadUrl(String headUrl) {
        HeadUrl = headUrl;
    }

    public String getIndexMap() {
        return IndexMap;
    }

    public void setIndexMap(String indexMap) {
        IndexMap = indexMap;
    }

    public Integer getMoney() {
        return Money;
    }

    public void setMoney(Integer money) {
        Money = money;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

}
