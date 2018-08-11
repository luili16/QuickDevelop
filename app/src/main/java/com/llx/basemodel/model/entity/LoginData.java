package com.llx.basemodel.model.entity;

public class LoginData {

    private String userName;
    private String passWd;

    private String publicKey;

    public LoginData(String userName, String passWd, String publicKey) {
        this.userName = userName;
        this.passWd = passWd;
        this.publicKey = publicKey;
    }

    public LoginData() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
