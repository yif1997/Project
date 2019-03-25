package com.bawei.wangyifei.bean;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName SecondBean
 * @package com.bawei.wangyifei.bean
 **/
public class SecondBean {
    public List<Second> result;

    public SecondBean(List<Second> result) {
        this.result = result;
    }

    public List<Second> getResult() {
        return result;
    }

    public void setResult(List<Second> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SecondBean{" +
                "result=" + result +
                '}';
    }
}
