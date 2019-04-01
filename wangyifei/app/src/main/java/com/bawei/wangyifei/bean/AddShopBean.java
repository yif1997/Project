package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName AddShopBean
 * @package com.bawei.wangyifei.bean
 **/
public class AddShopBean {
    public String message;
    public String status;

    public AddShopBean(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AddShopBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
