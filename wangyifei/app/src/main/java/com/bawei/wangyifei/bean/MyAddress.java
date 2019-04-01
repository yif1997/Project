package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName MyAddress
 * @package com.bawei.wangyifei.bean
 **/
public class MyAddress {
    public String id;
    public String userId;
    public String phone;
    public String realName;
    public String whetherDefault;
    public String address;
    public String zipCode;
    public String createTime;

    public MyAddress(String id, String userId, String phone, String realName, String whetherDefault, String address, String zipCode, String createTime) {
        this.id = id;
        this.userId = userId;
        this.phone = phone;
        this.realName = realName;
        this.whetherDefault = whetherDefault;
        this.address = address;
        this.zipCode = zipCode;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getWhetherDefault() {
        return whetherDefault;
    }

    public void setWhetherDefault(String whetherDefault) {
        this.whetherDefault = whetherDefault;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MyAddress{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", phone='" + phone + '\'' +
                ", realName='" + realName + '\'' +
                ", whetherDefault='" + whetherDefault + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
