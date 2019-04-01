package com.bawei.wangyifei.bean;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName MyAddressBean
 * @package com.bawei.wangyifei.bean
 **/
public class MyAddressBean {
    public String message;
    public String status;
    public List<MyAddress> result;

    public MyAddressBean(String message, String status, List<MyAddress> result) {
        this.message = message;
        this.status = status;
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

    public List<MyAddress> getResult() {
        return result;
    }

    public void setResult(List<MyAddress> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MyAddressBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", result=" + result +
                '}';
    }
}
