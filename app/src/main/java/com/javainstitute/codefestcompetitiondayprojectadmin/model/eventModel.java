package com.javainstitute.codefestcompetitiondayprojectadmin.model;

import java.util.Date;

public class eventModel {

    private String title;
    private String description;
    private String shopName;
    private String email;
    private String mobile;
    private String ImagePath;
    private String status;
    private String type;
    private double lattitude;
    private double longitude;
    private Date createdDate;

    public eventModel(String title, String description, String shopName, String email, String mobile, String imagePath, String status, String type, double lattitude, double longitude, Date createdDate) {
        this.title = title;
        this.description = description;
        this.shopName = shopName;
        this.email = email;
        this.mobile = mobile;
        ImagePath = imagePath;
        this.status = status;
        this.type = type;
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.createdDate = createdDate;
    }



    public eventModel() {
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
