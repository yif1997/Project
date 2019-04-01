package com.bawei.wangyifei.bean;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName ShopBean
 * @package com.bawei.wangyifei.bean
 **/
public class ShopBean {
    public String status;
    public String message;
    public List<Shop> result;

    public ShopBean(String status, String message, List<Shop> result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Shop> getResult() {
        return result;
    }

    public void setResult(List<Shop> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ShopBean{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }



}
