package com.bawei.wangyifei.bean;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName FirstBean
 * @package com.bawei.wangyifei.bean
 **/
public class FirstBean {
    public List<First> result;

    public FirstBean(List<First> result) {
        this.result = result;
    }

    public List<First> getResult() {
        return result;
    }

    public void setResult(List<First> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "FirstBean{" +
                "result=" + result +
                '}';
    }
}
