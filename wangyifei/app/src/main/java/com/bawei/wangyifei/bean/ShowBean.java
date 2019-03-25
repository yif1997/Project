package com.bawei.wangyifei.bean;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName ShowBean
 * @package com.bawei.wangyifei.bean
 **/
public class ShowBean {
    public ShowResult result;

    public ShowBean(ShowResult result) {
        this.result = result;
    }

    public ShowResult getResult() {
        return result;
    }

    public void setResult(ShowResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ShowBean{" +
                "result=" + result +
                '}';
    }
}
