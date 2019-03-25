package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName DetailsBean
 * @package com.bawei.wangyifei.bean
 **/
public class DetailsBean {
    Details result;

    public DetailsBean(Details result) {
        this.result = result;
    }

    public Details getResult() {
        return result;
    }

    public void setResult(Details result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "DetailsBean{" +
                "result=" + result +
                '}';
    }
}
