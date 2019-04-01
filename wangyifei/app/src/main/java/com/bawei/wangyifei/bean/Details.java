package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName Details
 * @package com.bawei.wangyifei.bean
 **/
public class Details {
    public String commodityName;
    public String price;
    public String picture;
    public String details;
    public String commodityId;

    public Details(String commodityName, String price, String picture, String details, String commodityId) {
        this.commodityName = commodityName;
        this.price = price;
        this.picture = picture;
        this.details = details;
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    @Override
    public String toString() {
        return "Details{" +
                "commodityName='" + commodityName + '\'' +
                ", price='" + price + '\'' +
                ", picture='" + picture + '\'' +
                ", details='" + details + '\'' +
                ", commodityId='" + commodityId + '\'' +
                '}';
    }
}
