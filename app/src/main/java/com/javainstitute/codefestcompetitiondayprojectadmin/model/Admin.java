package com.javainstitute.codefestcompetitiondayprojectadmin.model;

public class Admin {

    private String googleId;
    private String adminName;
    private String email;
    private String telephone;
    private String address;
    private String shopName;
    private String fcmToken;
    private int status;

    public Admin() {
    }

    public Admin(String googleId, String adminName, String email, String telephone, String address, String shopName, String fcmToken, int status) {
        this.googleId = googleId;
        this.adminName = adminName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.shopName = shopName;
        this.fcmToken = fcmToken;
        this.status = status;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
