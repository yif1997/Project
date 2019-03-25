package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName Zhan
 * @package com.bawei.wangyifei.bean
 **/
public class Zhan {
    public String commodityName;
    public String masterPic;
    public String price;
    public String commodityId;

    public Zhan(String commodityName, String masterPic, String price, String commodityId) {
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
}
