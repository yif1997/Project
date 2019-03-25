package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName RegistBean
 * @package com.bawei.wangyifei.bean
 **/
public class RegistBean {
    public String message;
    public String status;

    public RegistBean(String message, String status) {
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
        return "RegistBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
