package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName ShowResult
 * @package com.bawei.wangyifei.bean
 **/
public class ShowResult {
    public Show1 mlss;
    public Show1 pzsh;
    public Show1 rxxp;

    public ShowResult(Show1 mlss, Show1 pzsh, Show1 rxxp) {
        this.mlss = mlss;
        this.pzsh = pzsh;
        this.rxxp = rxxp;
    }

    public Show1 getMlss() {
        return mlss;
    }

    public void setMlss(Show1 mlss) {
        this.mlss = mlss;
    }

    public Show1 getPzsh() {
        return pzsh;
    }

    public void setPzsh(Show1 pzsh) {
        this.pzsh = pzsh;
    }

    public Show1 getRxxp() {
        return rxxp;
    }

    public void setRxxp(Show1 rxxp) {
        this.rxxp = rxxp;
    }

}
