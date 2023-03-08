package com.javainstitute.codefestcompetitiondayprojectadmin.model;

import java.util.Date;

public class ticket {

    private String title;
    private String description;
    private String email;
    private String mobile;
    private String ImagePath;
    private String type;
    private Date createdDate;

    public ticket() {
    }

    public ticket(String title, String description, String email, String mobile, String imagePath, String type, Date createdDate) {
        this.title = title;
        this.description = description;
        this.email = email;
        this.mobile = mobile;
        ImagePath = imagePath;
        this.type = type;
        this.createdDate = createdDate;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
