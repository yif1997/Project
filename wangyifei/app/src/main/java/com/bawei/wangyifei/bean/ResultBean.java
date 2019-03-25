package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName ResultBean
 * @package com.bawei.wangyifei.bean
 **/
public class ResultBean {
    public String commodityName;
    public String price;
    public String masterPic;
    public String commodityId;

    public ResultBean(String commodityName, String price, String masterPic, String commodityId) {
        this.commodityName = commodityName;
        this.price = price;
        this.masterPic = masterPic;
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

    public String getMasterPic() {
        return masterPic;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "commodityName='" + commodityName + '\'' +
                ", price='" + price + '\'' +
                ", masterPic='" + masterPic + '\'' +
                ", commodityId='" + commodityId + '\'' +
                '}';
    }
}
