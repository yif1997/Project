package com.bawei.wangyifei.bean;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName PicBean
 * @package com.bawei.wangyifei.bean
 **/
public class PicBean {
    public List<ResultBean1> result;

    public PicBean(List<ResultBean1> result) {
        this.result = result;
    }

    public List<ResultBean1> getResult() {
        return result;
    }

    public void setResult(List<ResultBean1> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PicBean{" +
                "result=" + result +
                '}';
    }
}
