package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName DefaultBean
 * @package com.bawei.wangyifei.bean
 **/
public class DefaultBean {
   public String message;
   public String status;

    public DefaultBean(String message, String status) {
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
        return "DefaultBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
