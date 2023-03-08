package com.javainstitute.codefestcompetitiondayprojectadmin.model;

import java.util.Date;

public class Product {

    private String productName;
    private double productPrice;
    private String ownerName;
    private String shopName;
    private String email;
    private String mobile;
    private Date createdDate;
    private String productImagePath;
    private String status;

    public Product() {
    }

    public Product(String productName, double productPrice, String ownerName, String shopName, String email, String mobile, Date createdDate, String productImagePath, String status) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.ownerName = ownerName;
        this.shopName = shopName;
        this.email = email;
        this.mobile = mobile;
        this.createdDate = createdDate;
        this.productImagePath = productImagePath;
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
