package com.bawei.wangyifei.bean;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName JsonBean
 * @package com.bawei.wangyifei.bean
 **/
public class JsonBean {
    public List<ResultBean> result;

    public JsonBean(List<ResultBean> result) {
        this.result = result;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JsonBean{" +
                "result=" + result +
                '}';
    }
}
