package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName AddAddressBean
 * @package com.bawei.wangyifei.bean
 **/
public class AddAddressBean {
    public String status;
    public String message;

    public AddAddressBean(String status, String message) {
        this.status = status;
        this.message = message;
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

    @Override
    public String toString() {
        return "AddAddressBean{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
