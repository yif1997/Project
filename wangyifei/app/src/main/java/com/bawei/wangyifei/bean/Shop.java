package com.bawei.wangyifei.bean;

import java.io.Serializable;

/**
 * @author 王艺霏
 * @fileName Shop
 * @package com.bawei.wangyifei.bean
 **/
public class Shop implements Serializable {
    private String commodityId;
    private String commodityName;
    private String pic;
    private int price;
    private int count;
    private boolean item_check;

    public Shop(String commodityId, String commodityName, String pic, int price, int count, boolean item_check) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.pic = pic;
        this.price = price;
        this.count = count;
        this.item_check = item_check;
    }

    public Shop(String commodityId, String commodityName, String pic, int price, int count) {
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isItem_check() {
        return item_check;
    }

    public void setItem_check(boolean item_check) {
        this.item_check = item_check;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "commodityId='" + commodityId + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", pic='" + pic + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", item_check=" + item_check +
                '}';
    }
}
