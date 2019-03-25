package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName ResultBean1
 * @package com.bawei.wangyifei.bean
 **/
public class ResultBean1 {
    public String imageUrl;

    public ResultBean1(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ResultBean1{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
