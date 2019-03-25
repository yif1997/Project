package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName Second
 * @package com.bawei.wangyifei.bean
 **/
public class Second {
    public String name;
    public String id;

    public Second(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Second{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
