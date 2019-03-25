package com.bawei.wangyifei.bean;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName ClassityBean
 * @package com.bawei.wangyifei.bean
 **/
public class ClassityBean {
    public List<Classity> result;

    public ClassityBean(List<Classity> result) {
        this.result = result;
    }

    public List<Classity> getResult() {
        return result;
    }

    public void setResult(List<Classity> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ClassityBean{" +
                "result=" + result +
                '}';
    }
}
