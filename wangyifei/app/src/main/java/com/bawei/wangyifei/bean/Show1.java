package com.bawei.wangyifei.bean;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName Show1
 * @package com.bawei.wangyifei.bean
 **/
public class Show1 {
    public String name;
    public List<Zhan> commodityList;
    public  String id;

    public Show1(String name, List<Zhan> commodityList, String id) {
        this.name = name;
        this.commodityList = commodityList;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Zhan> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<Zhan> commodityList) {
        this.commodityList = commodityList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Show1{" +
                "name='" + name + '\'' +
                ", commodityList=" + commodityList +
                ", id='" + id + '\'' +
                '}';
    }
}
