package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName First
 * @package com.bawei.wangyifei.bean
 **/
public class First {
    public String id;
    public String name;

    public First(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "First{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
