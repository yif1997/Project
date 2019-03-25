package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName LoginBean
 * @package com.bawei.wangyifei.bean
 **/
public class LoginBean {
    Login result;
    public String message;
    public String status;

    public LoginBean(Login result, String message, String status) {
        this.result = result;
        this.message = message;
        this.status = status;
    }

    public Login getResult() {
        return result;
    }

    public void setResult(Login result) {
        this.result = result;
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
        return "LoginBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
