package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName Classity
 * @package com.bawei.wangyifei.bean
 **/
public class Classity {
    public String commodityName;
    public String masterPic;
    public String price;
    public String commodityId;

    public Classity(String commodityName, String masterPic, String price, String commodityId) {
        this.commodityName = commodityName;
        this.masterPic = masterPic;
        this.price = price;
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getMasterPic() {
        return masterPic;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    @Override
    public String toString() {
        return "Classity{" +
                "commodityName='" + commodityName + '\'' +
                ", masterPic='" + masterPic + '\'' +
                ", price='" + price + '\'' +
                ", commodityId='" + commodityId + '\'' +
                '}';
    }
}
